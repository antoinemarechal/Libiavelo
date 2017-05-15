package business;

import java.util.ArrayList;

import dao.LocalisationDataAccess;
import dao.derby.LocalisationDerbyDataAccess;
import model.Localisation;

public class LocalisationManager {
	
	private LocalisationDataAccess localisationDataAccess;
	
	public LocalisationManager() {
		localisationDataAccess = new LocalisationDerbyDataAccess();
	}
	
	// ===============================================================================================
	// CREATE
	// ===============================================================================================
	public void addLocalisation(Localisation localisation) {
		localisationDataAccess.addLocalisation(localisation);
	}
	
	// ===============================================================================================
	// READ
	// ===============================================================================================
	public Localisation getLocalisation(int bikeID) {
		return localisationDataAccess.getLocalisation(bikeID);
	}
	
	public ArrayList<Localisation> getAllLocalisations() {
		return localisationDataAccess.getAllLocalisations();
	}
	
	// ===============================================================================================
	// UPDATE
	// ===============================================================================================
	public void updateLocalisation(Localisation localisation) {
		localisationDataAccess.updateLocalisation(localisation);
	}
	
	// ===============================================================================================
	// DELETE
	// ===============================================================================================
	public void removeLocalisation(Localisation localisation) {
		localisationDataAccess.removeLocalisation(localisation);
	}
}
