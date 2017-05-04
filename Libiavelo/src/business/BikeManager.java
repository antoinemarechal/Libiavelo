package business;

import java.util.ArrayList;

import dao.derby.BikeDerbyDataAccess;
import model.Bike;
import model.Client;

public class BikeManager {
	BikeDerbyDataAccess bikeDataAccess;
	
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
	public Client getBike(int bikeID ){
		return bikeDataAccess.getBike(bikeID);
	}
	
	public ArrayList<Client> getAllBikes() {
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
