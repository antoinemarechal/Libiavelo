package dao;

import java.sql.Date;
import java.util.ArrayList;

import model.Bike;
import model.enumerations.BikeState;

public interface BikeDataAccess {
	
	// ===============================================================================================
	// CREATE
	// ===============================================================================================
	public void addBike(Bike bike);
	
	// ===============================================================================================
	// READ
	// ===============================================================================================
	public Bike getBike(int bikeID);
	public ArrayList<Bike> getAllBikes();
	public ArrayList<ArrayList<Object>> getSearch1Data(Date date, Boolean isExceptionnal, Boolean isAvailable);
	public ArrayList<ArrayList<Object>> getSearch2Data(Date startDate, Date endDate, BikeState state);	
	public ArrayList<ArrayList<Object>> getSearch3Data(Boolean isValid, Date dateThreshold, Float minimumAmount);
	
	// ===============================================================================================
	// UPDATE
	// ===============================================================================================
	public void updateBike(Bike bike);
	
	// ===============================================================================================
	// DELETE
	// ===============================================================================================
	public void removeBike(Bike bike);
}
