package dao.derby;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.ConnectionSingleton;
import dao.RepairDataAccess;
import exception.DataAccessConnectionException;
import exception.DataAccessOperationException;
import exception.DataLengthException;
import exception.InvalidDateException;
import exception.InvalidNumberException;
import exception.NoDataException;
import model.Bike;
import model.Garage;
import model.PersonnelMember;
import model.Repair;

public class RepairDerbyDataAccess implements RepairDataAccess {
		
	// ===============================================================================================
	// CREATE
	// ===============================================================================================
	@Override
	public void addRepair(Repair repair) throws DataAccessConnectionException, DataAccessOperationException {
		Connection connection = ConnectionSingleton.getInstance();
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Reparation VALUES(?,?,?,?,?,?,?)");
			preparedStatement.setInt(1, repair.getBike().getId());
			preparedStatement.setDate(2, new Date(repair.getRepairStartDate().getTime()));
			preparedStatement.setString(3, repair.getDescription());
			preparedStatement.setString(4, repair.getNotes());
			preparedStatement.setDate(5, new Date(repair.getRepairEndDate().getTime()));
			preparedStatement.setString(6, repair.getVerifier().getId());
			preparedStatement.setInt(7, repair.getGarage().getId());
			
			preparedStatement.executeUpdate();
		}
		catch (SQLException e) {
			throw new DataAccessOperationException(getClass().getName() + ".addRepair(Repair)", e.getMessage());
		}
	}
	
	// ===============================================================================================
	// READ
	// ===============================================================================================
	@Override
	public Repair getRepair(int bikeID, java.util.Date entryDate) throws DataAccessConnectionException, DataAccessOperationException, NoDataException, InvalidNumberException, InvalidDateException, DataLengthException {
		Connection connection = ConnectionSingleton.getInstance();
		
		Repair repair = null;
		
		BikeDerbyDataAccess bikeDerbyDataAccess = new BikeDerbyDataAccess();
		GarageDerbyDataAccess garageDerbyDataAccess = new GarageDerbyDataAccess();
		PersonnelMemberDerbyDataAccess personnelMemberDerbyDataAccess = new PersonnelMemberDerbyDataAccess();
		
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
					repair.setNotes(note);
			}
		} 
		catch (SQLException e) {
			throw new DataAccessOperationException(getClass().getName() + ".getRepair(int, java.util.Date)", e.getMessage());
		}
		
		return repair;
	}	
	
	@Override
	public ArrayList<Repair> getAllRepairs() throws DataAccessConnectionException, DataAccessOperationException, NoDataException, DataLengthException, InvalidDateException, InvalidNumberException {
		Connection connection = ConnectionSingleton.getInstance();
		
		ArrayList<Repair> repairs = new ArrayList<Repair>();
		Repair repair = null;
		
		BikeDerbyDataAccess bikeDerbyDataAccess = new BikeDerbyDataAccess();
		GarageDerbyDataAccess garageDerbyDataAccess = new GarageDerbyDataAccess();
		PersonnelMemberDerbyDataAccess personnelMemberDerbyDataAccess = new PersonnelMemberDerbyDataAccess();
		
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
					repair.setNotes(note);
				
				repairs.add(repair);
			}
		} 
		catch (SQLException e) {
			throw new DataAccessOperationException(getClass().getName() + ".getAllRepairs()", e.getMessage());
		} 
		
		return repairs;
	}
	
	// ===============================================================================================
	// UPDATE
	// ===============================================================================================
	@Override
	public void updateRepair(Repair repair) throws DataAccessConnectionException, DataAccessOperationException {
		Connection connection = ConnectionSingleton.getInstance();
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Reparation SET DescriptionProbleme = ?, Remarques = ?, DateFinReparation = ?, Matricule = ?, CodeGarage = ? WHERE NumeroVelo = ? AND DateEntreeGarage = ?");
			preparedStatement.setString(1, repair.getDescription());
			preparedStatement.setString(2, repair.getNotes());
			preparedStatement.setDate(3, new Date(repair.getRepairEndDate().getTime()));
			preparedStatement.setString(4, repair.getVerifier().getId());
			preparedStatement.setInt(5, repair.getGarage().getId());
			preparedStatement.setInt(6, repair.getBike().getId());
			preparedStatement.setDate(7, new Date(repair.getRepairStartDate().getTime()));
			
			preparedStatement.executeUpdate();
		}
		catch (SQLException e) {
			throw new DataAccessOperationException(getClass().getName() + ".updateRepair(Repair)", e.getMessage());
		}
	}
}
