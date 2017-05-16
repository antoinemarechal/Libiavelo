package dao.derby;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import dao.ConnectionSingleton;
import dao.HouseholdMemberDataAccess;
import exception.DataAccessConnectionException;
import exception.DataAccessOperationException;
import exception.DataLengthException;
import exception.InvalidNumberException;
import exception.NoDataException;
import model.Client;
import model.HouseholdMember;

public class HouseholdMemberDerbyDataAccess implements HouseholdMemberDataAccess {

	// ===============================================================================================
	// CREATE
	// ===============================================================================================
	@Override
	public void addHouseholdMember(HouseholdMember householdMember, Client client) throws DataAccessConnectionException, DataAccessOperationException {
		Connection connection = ConnectionSingleton.getInstance();
		
		try {
			PreparedStatement addHouseholdMemberStatement = connection.prepareStatement("INSERT INTO Membre_Menage VALUES (?,?,?,?,?,?,?) ");
			String nationalNumber = householdMember.getNationalNumber();
			addHouseholdMemberStatement.setString(1, nationalNumber);
			addHouseholdMemberStatement.setString(2, householdMember.getSurname());
			
			String[] firstNames = householdMember.getFirstNames();
			addHouseholdMemberStatement.setString(3, firstNames[1]);
			if (firstNames[2] != "")
				addHouseholdMemberStatement.setString(4, firstNames[2]);
			if (firstNames[3] != "")
				addHouseholdMemberStatement.setString(5, firstNames[3]);
			if (firstNames[4] != "")
				addHouseholdMemberStatement.setString(6, firstNames[4]);
			if (firstNames[5] != "")
				addHouseholdMemberStatement.setString(7, firstNames[5]);	
			
			addHouseholdMemberStatement.executeUpdate();
			
			PreparedStatement addCompositionStatement = connection.prepareStatement("INSERT INTO COMPOSITION VALUES (?,?,?) ");
			addCompositionStatement.setString(1, nationalNumber);
			// addCompositionStatement.setDate(2, x); FIXME client.latestHouseHoldRenewal
			addCompositionStatement.setInt(3, client.getClientNumber());
		} 
		catch (SQLException e) {
			throw new DataAccessOperationException(getClass().getName() + ".addHouseholdMember(HouseholdMember, int)", e.getMessage());
		}
	}
	
	// ===============================================================================================
	// READ
	// ===============================================================================================
	@Override
	public HouseholdMember getHouseholdMember(String nationalNumber) throws DataAccessConnectionException, DataAccessOperationException, InvalidNumberException, NoDataException, DataLengthException {
		Connection connection = ConnectionSingleton.getInstance();
		
		HouseholdMember householdMember = null;
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Membre_Menage WHERE NumeroNational = ?");
			preparedStatement.setString(1, nationalNumber);
			
			ResultSet queryResult = preparedStatement.executeQuery();
			
			if(queryResult.next()) {
				String surname = queryResult.getString("Nom");
				String firstNames[] = new String[5];
				firstNames[1] = queryResult.getString("Prenom1");
				firstNames[2] = queryResult.getString("Prenom2");
				firstNames[3] = queryResult.getString("Prenom3");
				firstNames[4] = queryResult.getString("Prenom4");
				firstNames[5] = queryResult.getString("Prenom5");
				Date birthDate = queryResult.getDate("DateNaissance");
				
				householdMember = new HouseholdMember(nationalNumber, surname, firstNames, birthDate);
			}
		} 
		catch (SQLException e) {
			throw new DataAccessOperationException(getClass().getName() + ".getHouseholdMember(String)", e.getMessage());
		} 
		
		return householdMember;
	}
	
	@Override
	public ArrayList<HouseholdMember> getAllHouseholdMembers(int clientID) throws DataAccessConnectionException, DataAccessOperationException, InvalidNumberException, NoDataException, DataLengthException {
		Connection connection = ConnectionSingleton.getInstance();
		
		ArrayList<HouseholdMember> household = new ArrayList<HouseholdMember>();
				
		try {
			PreparedStatement selectComposition = connection.prepareStatement("SELECT * FROM Membre_Menage WHERE NumeroNational IN (SELECT NumeroNationalMembre FROM COMPOSITION WHERE NumeroClient = 1)");
			selectComposition.setInt(1, clientID);
			
			ResultSet queryResult = selectComposition.executeQuery();
			
			while(queryResult.next()) {
				String nationalNumber = queryResult.getString("NumeroNational");
				household.add(this.getHouseholdMember(nationalNumber));
			}
		} 
		catch (SQLException e) {
			throw new DataAccessOperationException(getClass().getName() + ".getAllHouseholdMembers(int)", e.getMessage());
		}
		
		return household;
	}
	
	// ===============================================================================================
	// UPDATE
	// ===============================================================================================
	@Override
	public void updateHouseholdMember(Client client, HouseholdMember householdMember) throws DataAccessConnectionException, DataAccessOperationException {
		Connection connection = ConnectionSingleton.getInstance();
		
		try {
			PreparedStatement editCompositionStatement = connection.prepareStatement("UPDATE COMPOSITION SET DateDernierRenouvellement = ? WHERE NUMERONATIONALMEMBRE = ? AND  NumeroClient = ?");
			//editCompositionStatement.setDate(1, client.); FIXME client.latestHouseHoldRenewal
			editCompositionStatement.setString(2, householdMember.getNationalNumber());
			editCompositionStatement.setInt(3, client.getClientNumber());
			editCompositionStatement.executeUpdate();
			
			PreparedStatement editHouseholdMemberStatement = connection.prepareStatement("UPDATE Membre_Menage SET Nom = ?, Prenom1 = ?, Prenom2 = ?, Prenom3 = ?, Prenom4 = ?, Prenom5 = ?, DateNaissance = ? WHERE NUMERONATIONAL = ?");
			editHouseholdMemberStatement.setString(1, householdMember.getSurname());
			
			String[] firstNames = householdMember.getFirstNames();
			editHouseholdMemberStatement.setString(2, firstNames[1]);
			if (firstNames[2] != "")
				editHouseholdMemberStatement.setString(3, firstNames[2]);
			if (firstNames[3] != "")
				editHouseholdMemberStatement.setString(4, firstNames[3]);
			if (firstNames[4] != "")
				editHouseholdMemberStatement.setString(5, firstNames[4]);
			if (firstNames[5] != "")
				editHouseholdMemberStatement.setString(6, firstNames[5]);
			
			editHouseholdMemberStatement.setDate(7, new Date(householdMember.getBirthDate().getTime()));
			
			editHouseholdMemberStatement.executeUpdate();
			
		} catch (SQLException e) {
			throw new DataAccessOperationException(getClass().getName() + ".updateHouseholdMember(HouseholdMember)", e.getMessage());
		}	
	}
	
	@Override
	public void updateHousehold(Client client) throws DataAccessConnectionException, DataAccessOperationException {
		Connection connection = ConnectionSingleton.getInstance();
		
		try {
			PreparedStatement removeAllCompositionsStatement = connection.prepareStatement("DELETE FROM COMPOSITION WHERE NUMEROCLIENT = ?");
			removeAllCompositionsStatement.setInt(1, client.getClientNumber());
			removeAllCompositionsStatement.executeUpdate();
			
			PreparedStatement removeAllHouseholdMembersStatement = connection.prepareStatement("DELETE FROM Membre_Menage WHERE NUMERONATIONAL NOT IN (SELECT NUMERONATIONALMEMBRE FROM COMPOSITION)");
			removeAllHouseholdMembersStatement.executeUpdate();
			
			HouseholdMember householdMember;
			Iterator<HouseholdMember> householdIterator= client.getHousehold().iterator();
			while (householdIterator.hasNext()) {
				householdMember = householdIterator.next();
				this.addHouseholdMember(householdMember, client);
			}
		 }catch (SQLException e) {
			throw new DataAccessOperationException(getClass().getName() + ".updateHousehold(Client)", e.getMessage());
		}
	}
	
	// ===============================================================================================
	// DELETE
	// ===============================================================================================
	@Override
	public void removeHouseholdMember(HouseholdMember householdMember) throws DataAccessConnectionException, DataAccessOperationException {
		Connection connection = ConnectionSingleton.getInstance();
		
		try {
			PreparedStatement removeCompositionStatement = connection.prepareStatement("DELETE FROM COMPOSITION WHERE NUMERONATIONALMEMBRE = ?");
			removeCompositionStatement.setString(1, householdMember.getNationalNumber());
			removeCompositionStatement.executeUpdate();
			
			PreparedStatement removeHouseholdMemberStatement = connection.prepareStatement("DELETE FROM Membre_Menage WHERE NUMERONATIONAL = ");
			removeCompositionStatement.setString(1, householdMember.getNationalNumber());
			removeHouseholdMemberStatement.executeUpdate();
		}
		catch (SQLException e) {
			throw new DataAccessOperationException(getClass().getName() + ".removeHouseholdMember(HouseholdMember)", e.getMessage());
		}
	}
}
