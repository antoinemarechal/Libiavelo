package business;

import java.sql.Date;
import java.util.ArrayList;

import dao.BikeDataAccess;
import dao.derby.BikeDerbyDataAccess;
import model.Bike;
import model.enumerations.BikeState;

public class BikeManager {
	BikeDataAccess bikeDataAccess;
	
	public BikeManager() {
		bikeDataAccess = new BikeDerbyDataAccess();
	}
	
	/*************************************************************************************************
	 CREATE
	 *************************************************************************************************/
	public void addBike(Bike bike) {
		bikeDataAccess.addBike(bike);		
	}
	
	/*************************************************************************************************
	 READ
	 *************************************************************************************************/
	public Bike getBike(int bikeID ){
		return bikeDataAccess.getBike(bikeID);
	}
	
	public ArrayList<Bike> getAllBikes() {
		return bikeDataAccess.getAllBikes();
	}
	
	public ArrayList<ArrayList<Object>> getSearch1Data(Date date, Boolean isExceptionnal, Boolean isAvailable) {
		return bikeDataAccess.getSearch1Data(date, isExceptionnal, isAvailable);
	}
	
	public ArrayList<ArrayList<Object>> getSearch2Data(Date startDate, Date endDate, BikeState state) {
		return bikeDataAccess.getSearch2Data(startDate, endDate, state);
	}
	
	public ArrayList<ArrayList<Object>> getSearch3Data(Boolean isValid, Date dateThreshold, Float minimumAmount) {
		return bikeDataAccess.getSearch3Data(isValid, dateThreshold, minimumAmount);
	}
	/*************************************************************************************************
	 UPDATE
	 *************************************************************************************************/
	public void updateBike(Bike bike){
		bikeDataAccess.updateBike(bike);
	}
	
	/*************************************************************************************************
	 DELETE
	 *************************************************************************************************/
	public void removeBike(Bike bike){
		bikeDataAccess.removeBike(bike);
	}
}
