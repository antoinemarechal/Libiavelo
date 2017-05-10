package business;

import java.util.ArrayList;

import dao.BikeStationDataAccess;
import dao.derby.BikeStationDerbyDataAccess;
import model.BikeStation;

public class BikeStationManager {
	BikeStationDataAccess bikeStationDataAccess;
	
	public BikeStationManager() {
		bikeStationDataAccess = new BikeStationDerbyDataAccess();
	}
	
	/*************************************************************************************************
	 CREATE
	 *************************************************************************************************/
	public void addBikeStation(BikeStation bikeStation) {
		bikeStationDataAccess.addBikeStation(bikeStation);
	}
	
	/*************************************************************************************************
	 READ
	 *************************************************************************************************/
	public BikeStation getBikeStation(int bikeStationID) {
		return bikeStationDataAccess.getBikeStation(bikeStationID);
	}
	
	public ArrayList<BikeStation> getAllBikeStations() {
		return bikeStationDataAccess.getAllBikeStations();
	}
	
	/*************************************************************************************************
	 UPDATE
	 *************************************************************************************************/
	public void updateBikeStation(BikeStation bikeStation) {
		bikeStationDataAccess.updateBikeStation(bikeStation);
	}
	
	/*************************************************************************************************
	 DELETE
	 *************************************************************************************************/
	public void removeBikeStation() {
		bikeStationDataAccess.removeBikeStation();
	}
}
