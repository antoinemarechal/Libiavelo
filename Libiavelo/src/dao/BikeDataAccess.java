package dao;

import java.util.Date;
import java.util.ArrayList;

import exception.DataAccessConnectionException;
import exception.DataAccessOperationException;
import model.Bike;
import model.enumerations.BikeState;

public interface BikeDataAccess {
	
	// ===============================================================================================
	// CREATE
	// ===============================================================================================
	public void addBike(Bike bike) throws DataAccessConnectionException, DataAccessOperationException;
	
	// ===============================================================================================
	// READ
	// ===============================================================================================
	public Bike getBike(int bikeID) throws DataAccessConnectionException, DataAccessOperationException;
	public ArrayList<Bike> getAllBikes() throws DataAccessConnectionException, DataAccessOperationException;
	public ArrayList<ArrayList<Object>> getSearch1Data(Date date, Boolean isExceptionnal, Boolean isAvailable) throws DataAccessConnectionException, DataAccessOperationException;
	public ArrayList<ArrayList<Object>> getSearch2Data(Date startDate, Date endDate, BikeState state) throws DataAccessConnectionException, DataAccessOperationException;	
	public ArrayList<ArrayList<Object>> getSearch3Data(Boolean isValid, Date dateThreshold, Float minimumAmount) throws DataAccessConnectionException, DataAccessOperationException;
	
	// ===============================================================================================
	// UPDATE
	// ===============================================================================================
	public void updateBike(Bike bike) throws DataAccessConnectionException, DataAccessOperationException;
	
	// ===============================================================================================
	// DELETE
	// ===============================================================================================
	public void removeBike(Bike bike) throws DataAccessConnectionException, DataAccessOperationException;
}
