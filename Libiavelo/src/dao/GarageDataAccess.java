package dao;

import java.util.ArrayList;

import exception.DataAccessConnectionException;
import exception.DataAccessOperationException;
import exception.InvalidNumberException;
import exception.NoDataException;
import model.Garage;

public interface GarageDataAccess {
	
	// ===============================================================================================
	// CREATE
	// ===============================================================================================
	public void addGarage(Garage Garage) throws DataAccessConnectionException, DataAccessOperationException;
	
	// ===============================================================================================
	// READ
	// ===============================================================================================
	public Garage getGarage(int garageID) throws DataAccessConnectionException, DataAccessOperationException, NoDataException, InvalidNumberException;
	public ArrayList<Garage> getAllGarages() throws DataAccessConnectionException, DataAccessOperationException, NoDataException, InvalidNumberException;
	
	// ===============================================================================================
	// UPDATE
	// ===============================================================================================
	public void updateGarage(Garage garage) throws DataAccessConnectionException, DataAccessOperationException;
	
	// ===============================================================================================
	// DELETE
	// ===============================================================================================
	public void removeGarage(Garage garage) throws DataAccessConnectionException, DataAccessOperationException;
}
