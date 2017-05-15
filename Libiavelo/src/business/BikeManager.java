package business;

import java.util.ArrayList;
import java.util.Date;

import dao.BikeDataAccess;
import dao.derby.BikeDerbyDataAccess;
import exception.DataAccessConnectionException;
import exception.DataAccessOperationException;
import model.Bike;
import model.enumerations.BikeState;

public class BikeManager {
	
	private BikeDataAccess bikeDataAccess;
	
	public BikeManager() {
		bikeDataAccess = new BikeDerbyDataAccess();
	}
	
	// ===============================================================================================
	// CREATE
	// ===============================================================================================
	public void addBike(Bike bike) throws DataAccessConnectionException, DataAccessOperationException {
		bikeDataAccess.addBike(bike);		
	}
	
	// ===============================================================================================
	// READ
	// ===============================================================================================
	public Bike getBike(int bikeID ) throws DataAccessConnectionException, DataAccessOperationException {
		return bikeDataAccess.getBike(bikeID);
	}
	
	public ArrayList<Bike> getAllBikes() throws DataAccessConnectionException, DataAccessOperationException {
		return bikeDataAccess.getAllBikes();
	}
	
	public ArrayList<ArrayList<Object>> getSearch1Data(Date date, Boolean isExceptionnal, Boolean isAvailable) throws DataAccessConnectionException, DataAccessOperationException {
		return bikeDataAccess.getSearch1Data(date, isExceptionnal, isAvailable);
	}
	
	public ArrayList<ArrayList<Object>> getSearch2Data(Date startDate, Date endDate, BikeState state) throws DataAccessConnectionException, DataAccessOperationException {
		return bikeDataAccess.getSearch2Data(startDate, endDate, state);
	}
	
	public ArrayList<ArrayList<Object>> getSearch3Data(Boolean isValid, Date dateThreshold, Float minimumAmount) throws DataAccessConnectionException, DataAccessOperationException {
		return bikeDataAccess.getSearch3Data(isValid, dateThreshold, minimumAmount);
	}
	
	// ===============================================================================================
	// UPDATE
	// ===============================================================================================
	public void updateBike(Bike bike) throws DataAccessConnectionException, DataAccessOperationException {
		bikeDataAccess.updateBike(bike);
	}
	
	// ===============================================================================================
	// DELETE
	// ===============================================================================================
	public void removeBike(Bike bike) throws DataAccessConnectionException, DataAccessOperationException {
		bikeDataAccess.removeBike(bike);
	}
}
