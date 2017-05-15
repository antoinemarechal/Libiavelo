package dao;

import java.util.ArrayList;

import exception.DataAccessConnectionException;
import exception.DataAccessOperationException;
import exception.InvalidNumberException;
import exception.NoDataException;
import model.Localisation;

public interface LocalisationDataAccess {
	
	// ===============================================================================================
	// CREATE
	// ===============================================================================================
	public void addLocalisation(Localisation localisation) throws DataAccessConnectionException, DataAccessOperationException;
	
	// ===============================================================================================
	// READ
	// ===============================================================================================
	public Localisation getLocalisation(int bikeID) throws DataAccessConnectionException, DataAccessOperationException, InvalidNumberException, NoDataException;
	public ArrayList<Localisation> getAllLocalisations() throws DataAccessConnectionException, DataAccessOperationException, InvalidNumberException, NoDataException;
	
	// ===============================================================================================
	// UPDATE
	// ===============================================================================================
	public void updateLocalisation(Localisation localisation) throws DataAccessConnectionException, DataAccessOperationException;
	
	// ===============================================================================================
	// DELETE
	// ===============================================================================================
	public void removeLocalisation(Localisation localisation) throws DataAccessConnectionException, DataAccessOperationException;
}
