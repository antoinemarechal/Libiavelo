package dao.derby;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.ConnectionSingleton;
import dao.RepairDataAccess;
import exception.InvalidDateException;
import exception.NoDataException;
import model.Bike;
import model.Garage;
import model.PersonnelMember;
import model.Repair;

public class RepairDerbyDataAccess implements RepairDataAccess {
	public RepairDerbyDataAccess() {
	}
	
	/*************************************************************************************************
	 CREATE
	 *************************************************************************************************/
	public void addRepair(Repair repair) {
		Connection connection = (Connection)  (ConnectionSingleton.getInstance());
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Reparation VALUES(?,?,?,?,?,?,?)");
			preparedStatement.setInt(1, repair.getBike().getId());
			preparedStatement.setDate(2, new Date(repair.getRepairStartDate().getTime()));
			preparedStatement.setString(3, repair.getDescription());
			preparedStatement.setString(4, repair.getNote());
			preparedStatement.setDate(5, new Date(repair.getRepairEndDate().getTime()));
			preparedStatement.setString(6, repair.getVerifier().getId());
			preparedStatement.setInt(7, repair.getGarage().getId());
			
			preparedStatement.executeUpdate();
		}
		catch (SQLException e) {
			// TODO: handle exception
		}
	}
	
	/*************************************************************************************************
	 READ
	 *************************************************************************************************/
	public Repair getRepair(int bikeID, java.util.Date entryDate) {
		Repair repair = null;
		
		BikeDerbyDataAccess bikeDerbyDataAccess = new BikeDerbyDataAccess();
		GarageDerbyDataAccess garageDerbyDataAccess = new GarageDerbyDataAccess();
		PersonnelMemberDerbyDataAccess personnelMemberDerbyDataAccess = new PersonnelMemberDerbyDataAccess();
		
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Reparation where ? = NumeroVelo AND ? = DateEntreeGarage");
			preparedStatement.setInt(1, bikeID);
			preparedStatement.setDate(2,  new Date(entryDate.getTime()));
			ResultSet queryResult = preparedStatement.executeQuery();
			while(queryResult.next()) {
				Date exitDate = queryResult.getDate("DateFinReparation");
				Integer premisesID = queryResult.getInt("CodeGarage");
				String verifierID = queryResult.getString("Matricule");
				String note = queryResult.getString("Remarques");
				String description = queryResult.getString("DescriptionProbleme");
				
				
				Bike bike = bikeDerbyDataAccess.getBike(bikeID);
				Garage garage = garageDerbyDataAccess.getGarage(premisesID);
				PersonnelMember verifier = personnelMemberDerbyDataAccess.getPersonnelMember(verifierID);
				
				repair = new Repair(bike, entryDate, garage, verifier, description);
				if (exitDate != null)
					repair.setEndDate(exitDate);
				if (note != null)
					repair.setNote(note);
			}
		} catch (SQLException | NoDataException | InvalidDateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return repair;
	}	
	
	public ArrayList<Repair> getAllRepairs() {
		Repair repair = null;
		ArrayList<Repair> repairs = new ArrayList<Repair>();
		
		BikeDerbyDataAccess bikeDerbyDataAccess = new BikeDerbyDataAccess();
		GarageDerbyDataAccess garageDerbyDataAccess = new GarageDerbyDataAccess();
		PersonnelMemberDerbyDataAccess personnelMemberDerbyDataAccess = new PersonnelMemberDerbyDataAccess();
		
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Reparation");
			ResultSet queryResult = preparedStatement.executeQuery();
			while(queryResult.next()) {
				Date entryDate = queryResult.getDate("DateEntreeGarage");
				Date exitDate = queryResult.getDate("DateFinReparation");
				Integer bikeID = queryResult.getInt("NumeroVelo");
				Integer premisesID = queryResult.getInt("CodeGarage");
				String verifierID = queryResult.getString("Matricule");
				String note = queryResult.getString("Remarques");
				String description = queryResult.getString("DescriptionProbleme");
					
				Bike bike = bikeDerbyDataAccess.getBike(bikeID);		
				Garage garage = garageDerbyDataAccess.getGarage(premisesID);				
				PersonnelMember verifier = personnelMemberDerbyDataAccess.getPersonnelMember(verifierID);
				
				repair = new Repair(bike, entryDate, garage, verifier, description);
				if (exitDate != null)
					repair.setEndDate(exitDate);
				if (note != null)
					repair.setNote(note);
				repairs.add(repair);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoDataException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidDateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return repairs;
	}
	
	/*************************************************************************************************
	 UPDATE
	 *************************************************************************************************/
	public void updateRepair(Repair repair) {
		Connection connection = (Connection)  (ConnectionSingleton.getInstance());
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Reparation SET DescriptionProbleme = ?, Remarques = ?, DateFinReparation = ?, Matricule = ?, CodeGarage = ? WHERE NumeroVelo = ? AND DateEntreeGarage = ?");
			preparedStatement.setString(1, repair.getDescription());
			preparedStatement.setString(2, repair.getNote());
			preparedStatement.setDate(3, new Date(repair.getRepairEndDate().getTime()));
			preparedStatement.setString(4, repair.getVerifier().getId());
			preparedStatement.setInt(5, repair.getGarage().getId());
			preparedStatement.setInt(6, repair.getBike().getId());
			preparedStatement.setDate(7, new Date(repair.getRepairStartDate().getTime()));
			
			preparedStatement.executeUpdate();
		}
		catch (SQLException e) {
			// TODO: handle exception
		}
	}
}
