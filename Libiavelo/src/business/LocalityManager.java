package business;

import java.util.ArrayList;

import dao.LocalityDataAccess;
import dao.derby.LocalityDerbyDataAccess;
import exception.DataAccessConnectionException;
import exception.DataAccessOperationException;
import exception.InvalidNumberException;
import exception.NoDataException;
import model.Locality;

public class LocalityManager {
	
	private LocalityDataAccess localityDataAccess;
	
	public LocalityManager() {
		localityDataAccess = new LocalityDerbyDataAccess();
	}
	
	// ===============================================================================================
	// CREATE
	// ===============================================================================================
	public void addLocality(Locality locality) throws DataAccessConnectionException, DataAccessOperationException {
		localityDataAccess.addLocality(locality);
	}
	
	// ===============================================================================================
	// READ
	// ===============================================================================================
	public Locality getLocality(int localityCode) throws DataAccessConnectionException, DataAccessOperationException, NoDataException, InvalidNumberException {
		return localityDataAccess.getLocality(localityCode);
	}
	
	public ArrayList<Locality> getAllLocalities() throws DataAccessConnectionException, DataAccessOperationException, NoDataException, InvalidNumberException {
		return localityDataAccess.getAllLocalities();
	}
	
	// ===============================================================================================
	// UPDATE
	// ===============================================================================================
	public void updateLocality(Locality locality) throws DataAccessConnectionException, DataAccessOperationException {
		localityDataAccess.updateLocality(locality);
	}
	
	// ===============================================================================================
	// DELETE
	// ===============================================================================================
	public void removeLocality(Locality locality) throws DataAccessConnectionException, DataAccessOperationException {
		localityDataAccess.removeLocality(locality);
	}
}
