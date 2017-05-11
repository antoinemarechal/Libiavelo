package dao.derby;

import java.util.ArrayList;

import dao.BikeDataAccess;
import model.Bike;

public class BikeDerbyDataAccess implements BikeDataAccess {
	public BikeDerbyDataAccess() {
	}

	/*************************************************************************************************
	 CREATE
	 *************************************************************************************************/
	public void addBike(Bike bike) {
		
	}
	
	/*************************************************************************************************
	 READ
	 *************************************************************************************************/
	public Bike getBike(int bikeID) {
		
		// NumeroVelo INTEGER  Etat  VARCHAR
		return null;
	}
	
	public ArrayList<Bike> getAllBikes() {
		return null;
	}
	
	/*************************************************************************************************
	 UPDATE
	 *************************************************************************************************/
	public void updateBike(Bike bike) {
		
	}
	
	/*************************************************************************************************
	 DELETE
	 *************************************************************************************************/
	public void removeBike(Bike bike) {
		
	}
}
