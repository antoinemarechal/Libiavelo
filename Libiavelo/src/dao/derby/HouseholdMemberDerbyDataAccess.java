package dao.derby;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.ConnectionSingleton;
import dao.HouseholdMemberDataAccess;
import exception.DataAccessConnectionException;
import exception.DataAccessOperationException;
import exception.DataLengthException;
import exception.InvalidNumberException;
import exception.NoDataException;
import model.HouseholdMember;

public class HouseholdMemberDerbyDataAccess implements HouseholdMemberDataAccess {

	// ===============================================================================================
	// CREATE
	// ===============================================================================================
	@Override
	public void addHouseholdMember(HouseholdMember householdMember, int clientID) throws DataAccessConnectionException, DataAccessOperationException {
		Connection connection = ConnectionSingleton.getInstance();
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Membre_Menage VALUES (?,?,?,?,?,?,?) ");
			String nationalNumber = "" + householdMember.getNationalNumber();
			preparedStatement.setString(1, nationalNumber);
			preparedStatement.setString(2, householdMember.getSurname());
			
			String[] firstNames = householdMember.getFirstNames();
			preparedStatement.setString(3, firstNames[1]);
			if (firstNames[2] != "")
				preparedStatement.setString(4, firstNames[2]);
			if (firstNames[3] != "")
				preparedStatement.setString(5, firstNames[3]);
			if (firstNames[4] != "")
				preparedStatement.setString(6, firstNames[4]);
			if (firstNames[5] != "")
				preparedStatement.setString(7, firstNames[5]);	
			
			preparedStatement.executeUpdate();
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
			PreparedStatement selectComposition = connection.prepareStatement("SELECT * FROM Composition WHERE NumeroClient = ?");
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
	public void updateHouseholdMemebr(HouseholdMember householdMember) throws DataAccessConnectionException, DataAccessOperationException {
		
	}
	
	// ===============================================================================================
	// DELETE
	// ===============================================================================================
	@Override
	public void removeHouseholdMember(HouseholdMember householdMember) throws DataAccessConnectionException, DataAccessOperationException {
		
	}
}
