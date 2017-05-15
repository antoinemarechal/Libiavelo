package business;

import java.util.ArrayList;

import dao.LocalisationDataAccess;
import dao.derby.LocalisationDerbyDataAccess;
import exception.DataAccessConnectionException;
import exception.DataAccessOperationException;
import exception.InvalidNumberException;
import exception.NoDataException;
import model.Localisation;

public class LocalisationManager {
	
	private LocalisationDataAccess localisationDataAccess;
	
	public LocalisationManager() {
		localisationDataAccess = new LocalisationDerbyDataAccess();
	}
	
	// ===============================================================================================
	// CREATE
	// ===============================================================================================
	public void addLocalisation(Localisation localisation) throws DataAccessConnectionException, DataAccessOperationException {
		localisationDataAccess.addLocalisation(localisation);
	}
	
	// ===============================================================================================
	// READ
	// ===============================================================================================
	public Localisation getLocalisation(int bikeID) throws DataAccessConnectionException, DataAccessOperationException, InvalidNumberException, NoDataException {
		return localisationDataAccess.getLocalisation(bikeID);
	}
	
	public ArrayList<Localisation> getAllLocalisations() throws DataAccessConnectionException, DataAccessOperationException, InvalidNumberException, NoDataException {
		return localisationDataAccess.getAllLocalisations();
	}
	
	// ===============================================================================================
	// UPDATE
	// ===============================================================================================
	public void updateLocalisation(Localisation localisation) throws DataAccessConnectionException, DataAccessOperationException {
		localisationDataAccess.updateLocalisation(localisation);
	}
	
	// ===============================================================================================
	// DELETE
	// ===============================================================================================
	public void removeLocalisation(Localisation localisation) throws DataAccessConnectionException, DataAccessOperationException {
		localisationDataAccess.removeLocalisation(localisation);
	}
}
