package dao.derby;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.ConnectionSingleton;
import dao.RepairDataAccess;
import exception.InvalidNumberException;
import model.Bike;
import model.BikeStation;
import model.Garage;
import model.Localisation;
import model.PersonnelMember;
import model.Repair;

public class RepairDerbyDataAccess implements RepairDataAccess {
	public RepairDerbyDataAccess() {
	}
	/*************************************************************************************************
	 CREATE
	 *************************************************************************************************/
	public void addRepair(Repair repair) {
	}
	
	/*************************************************************************************************
	 READ
	 *************************************************************************************************/
	public Repair getRepair(int repairID) {
		Repair repair = null;
		Connection connexion = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connexion.prepareStatement("SELECT * FROM Reparation");
			ResultSet queryResult = preparedStatement.executeQuery();
			while(queryResult.next()) {
				Date entryDate = queryResult.getDate("DateEntreeGarage");
				Date exitDate = queryResult.getDate("DateFinReparation");
				Integer bikeID = queryResult.getInt("NumeroVelo");
				Integer premisesID = queryResult.getInt("CodeGarage");
				Integer verifierID = queryResult.getInt("Matricule");
				String notes = queryResult.getString("Remarques");
				String description = queryResult.getString("DescriptionProbleme");
				
				BikeDerbyDataAccess bikeDerbyDataAccess = new BikeDerbyDataAccess();
				Bike bike = bikeDerbyDataAccess.getBike(bikeID);
				
				GarageDerbyDataAccess garageDerbyDataAccess = new GarageDerbyDataAccess();
				Garage garage = garageDerbyDataAccess.getGarage(premisesID);
				 
				PersonnelMemberDerbyDataAccess personnelMemberDerbyDataAccess = new PersonnelMemberDerbyDataAccess();
				PersonnelMember verifier = personnelMemberDerbyDataAccess.getPersonnelMember(verifierID);
				repair = new Repair(bike, entryDate, garage, verifier);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return repair;
	}	
	
	public ArrayList<Repair> getAllRepairs() {
		ArrayList<Repair> repairs = new ArrayList<Repair>();
		Repair repair = null;
		Connection connexion = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connexion.prepareStatement("SELECT * FROM Reparation");
			ResultSet queryResult = preparedStatement.executeQuery();
			while(queryResult.next()) {
				Date entryDate = queryResult.getDate("DateEntreeGarage");
				Date exitDate = queryResult.getDate("DateFinReparation");
				Integer bikeID = queryResult.getInt("NumeroVelo");
				Integer premisesID = queryResult.getInt("CodeGarage");
				Integer verifierID = queryResult.getInt("Matricule");
				String notes = queryResult.getString("Remarques");
				String description = queryResult.getString("DescriptionProbleme");
				
				BikeDerbyDataAccess bikeDerbyDataAccess = new BikeDerbyDataAccess();
				Bike bike = bikeDerbyDataAccess.getBike(bikeID);
				
				GarageDerbyDataAccess garageDerbyDataAccess = new GarageDerbyDataAccess();
				Garage garage = garageDerbyDataAccess.getGarage(premisesID);
				 
				PersonnelMemberDerbyDataAccess personnelMemberDerbyDataAccess = new PersonnelMemberDerbyDataAccess();
				PersonnelMember verifier = personnelMemberDerbyDataAccess.getPersonnelMember(verifierID);
				repair = new Repair(bike, entryDate, garage, verifier);
				repairs.add(repair);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return repairs;
	}
	
	/*************************************************************************************************
	 UPDATE
	 *************************************************************************************************/
	public void updateRepair(Repair repair) {
	}
	
	/*************************************************************************************************
	 DELETE
	 *************************************************************************************************/
	public void removeRepair(Repair repair) {
	}
}
