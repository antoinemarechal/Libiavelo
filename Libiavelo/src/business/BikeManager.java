package business;

import java.util.ArrayList;

import dao.BikeDataAccess;
import dao.derby.BikeDerbyDataAccess;
import model.Bike;

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
