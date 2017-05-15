package business;

import java.util.ArrayList;

import dao.BikeStationDataAccess;
import dao.derby.BikeStationDerbyDataAccess;
import exception.DataAccessConnectionException;
import exception.DataAccessOperationException;
import exception.InvalidNumberException;
import exception.NoDataException;
import model.BikeStation;

public class BikeStationManager {
	
	private BikeStationDataAccess bikeStationDataAccess;
	
	public BikeStationManager() {
		bikeStationDataAccess = new BikeStationDerbyDataAccess();
	}
	
	// ===============================================================================================
	// CREATE
	// ===============================================================================================
	public void addBikeStation(BikeStation bikeStation) throws DataAccessConnectionException, DataAccessOperationException {
		bikeStationDataAccess.addBikeStation(bikeStation);
	}
	
	// ===============================================================================================
	// READ
	// ===============================================================================================
	public BikeStation getBikeStation(int bikeStationID) throws DataAccessConnectionException, DataAccessOperationException, InvalidNumberException, NoDataException {
		return bikeStationDataAccess.getBikeStation(bikeStationID);
	}
	
	public ArrayList<BikeStation> getAllBikeStations() throws DataAccessConnectionException, DataAccessOperationException, InvalidNumberException, NoDataException {
		return bikeStationDataAccess.getAllBikeStations();
	}
	
	// ===============================================================================================
	// UPDATE
	// ===============================================================================================
	public void updateBikeStation(BikeStation bikeStation) throws DataAccessConnectionException, DataAccessOperationException {
		bikeStationDataAccess.updateBikeStation(bikeStation);
	}
	
	// ===============================================================================================
	// DELETE
	// ===============================================================================================
	public void removeBikeStation() throws DataAccessConnectionException, DataAccessOperationException {
		bikeStationDataAccess.removeBikeStation();
	}
}
