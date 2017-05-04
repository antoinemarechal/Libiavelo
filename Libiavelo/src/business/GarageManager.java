package business;

import java.util.ArrayList;

import dao.derby.GarageDerbyDataAccess;
import model.Garage;

public class GarageManager {
	GarageDerbyDataAccess garageDataAccess;
	
	public GarageManager() {
		garageDataAccess = new GarageDerbyDataAccess();
	}
	
	/*************************************************************************************************
	 CREATE
	 *************************************************************************************************/
	public void addGarage(Garage Garage) {
		garageDataAccess.addGarage(Garage);
	}
	
	/*************************************************************************************************
	 READ
	 *************************************************************************************************/
	public Garage getGarage(int garageID) {
		return garageDataAccess.getGarage(garageID);
	}
	
	public ArrayList<Garage> getAllGarages() {
		return garageDataAccess.getAllGarages();
	}
	
	/*************************************************************************************************
	 UPDATE
	 *************************************************************************************************/
	public void updateGarage(Garage garage) {
		garageDataAccess.updateGarage(garage);
	}
	
	/*************************************************************************************************
	 DELETE
	 *************************************************************************************************/
	public void removeGarage(Garage garage) {
		garageDataAccess.removeGarage(garage);
	}
}
