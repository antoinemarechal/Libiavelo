package dao;

import java.util.ArrayList;

import exception.DataAccessConnectionException;
import exception.DataAccessOperationException;
import exception.InvalidNumberException;
import exception.NoDataException;
import model.BikeStation;

public interface BikeStationDataAccess {
	
	// ===============================================================================================
	// CREATE
	// ===============================================================================================
	public void addBikeStation(BikeStation bikeStation) throws DataAccessConnectionException, DataAccessOperationException;
	
	// ===============================================================================================
	// READ
	// ===============================================================================================
	public BikeStation getBikeStation(int bikeStationID) throws DataAccessConnectionException, DataAccessOperationException, InvalidNumberException, NoDataException;
	public ArrayList<BikeStation> getAllBikeStations() throws DataAccessConnectionException, DataAccessOperationException, InvalidNumberException, NoDataException;
	
	// ===============================================================================================
	// UPDATE
	// ===============================================================================================
	public void updateBikeStation(BikeStation bikeStation) throws DataAccessConnectionException, DataAccessOperationException;
	
	// ===============================================================================================
	// DELETE
	// ===============================================================================================
	public void removeBikeStation() throws DataAccessConnectionException, DataAccessOperationException;
}
