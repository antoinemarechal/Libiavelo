package dao;

import java.util.ArrayList;

import exception.DataAccessConnectionException;
import exception.DataAccessOperationException;
import exception.InvalidNumberException;
import exception.NoDataException;
import model.Locality;

public interface LocalityDataAccess {
	
	// ===============================================================================================
	// CREATE
	// ===============================================================================================
	public void addLocality(Locality locality) throws DataAccessConnectionException, DataAccessOperationException;
	
	// ===============================================================================================
	// READ
	// ===============================================================================================
	public Locality getLocality(int localityCode) throws DataAccessConnectionException, DataAccessOperationException, NoDataException, InvalidNumberException;
	public ArrayList<Locality> getAllLocalities() throws DataAccessConnectionException, DataAccessOperationException, NoDataException, InvalidNumberException;
		
	// ===============================================================================================
	// UPDATE
	// ===============================================================================================
	public void updateLocality(Locality locality) throws DataAccessConnectionException, DataAccessOperationException;
	
	// ===============================================================================================
	// DELETE
	// ===============================================================================================
	public void removeLocality(Locality locality) throws DataAccessConnectionException, DataAccessOperationException;
}
