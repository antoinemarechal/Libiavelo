package dao.derby;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.ConnectionSingleton;
import dao.HouseholdMemberDataAccess;
import exception.InvalidNumberException;
import exception.NoDataException;
import model.HouseholdMember;

public class HouseholdMemberDerbyDataAccess implements HouseholdMemberDataAccess {
	public HouseholdMemberDerbyDataAccess() {
	}
	/*************************************************************************************************
	 CREATE
	 *************************************************************************************************/
	public void addHouseholdMember(HouseholdMember householdMember, Integer clientID) {
		Connection connection = (Connection)  (ConnectionSingleton.getInstance());
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
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/*************************************************************************************************
	 READ
	 *************************************************************************************************/
	public HouseholdMember getHouseholdMember(Integer clientID) {
		HouseholdMember householdMember = null;
		Connection connexion = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connexion.prepareStatement("SELECT * FROM Membre_Menage");
			ResultSet queryResult = preparedStatement.executeQuery();
			while(queryResult.next()) {
				String surname = queryResult.getString("Nom");
				String firstNames[] = new String[5];
				firstNames[1] = queryResult.getString("Prenom1");
				firstNames[2] = queryResult.getString("Prenom2");
				firstNames[3] = queryResult.getString("Prenom3");
				firstNames[4] = queryResult.getString("Prenom4");
				firstNames[5] = queryResult.getString("Prenom5");
				String nationalNumber = queryResult.getString("NumeroNational");
				
				householdMember = new HouseholdMember(nationalNumber);
				householdMember.setSurname(surname);
				householdMember.setFirstNames(firstNames);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoDataException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidNumberException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return householdMember;
	}
	
	public ArrayList<HouseholdMember> getAllHouseholdMembers() {
		ArrayList<HouseholdMember> household = new ArrayList<HouseholdMember>();
		HouseholdMember householdMember = null;
		Connection connexion = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connexion.prepareStatement("SELECT * FROM Membre_Menage");
			ResultSet queryResult = preparedStatement.executeQuery();
			while(queryResult.next()) {
				String surname = queryResult.getString("Nom");
				String firstNames[] = new String[5];
				firstNames[1] = queryResult.getString("Prenom1");
				firstNames[2] = queryResult.getString("Prenom2");
				firstNames[3] = queryResult.getString("Prenom3");
				firstNames[4] = queryResult.getString("Prenom4");
				firstNames[5] = queryResult.getString("Prenom5");
				String nationalNumber = queryResult.getString("NumeroNational");
				
				householdMember = new HouseholdMember(nationalNumber);
				householdMember.setSurname(surname);
				householdMember.setFirstNames(firstNames);
				
				household.add(householdMember);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoDataException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidNumberException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return household;
	}
	
	/*************************************************************************************************
	 UPDATE
	 *************************************************************************************************/
	public void updateHouseholdMemebr(HouseholdMember householdMember) {
	}
	
	/*************************************************************************************************
	 DELETE
	 *************************************************************************************************/
	public void removeHouseholdMember(HouseholdMember householdMember) {
	}
}
