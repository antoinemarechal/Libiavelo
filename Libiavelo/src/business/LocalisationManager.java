package business;

import java.util.ArrayList;

import dao.LocalisationDataAccess;
import dao.derby.LocalisationDerbyDataAccess;
import model.Localisation;

public class LocalisationManager {
	LocalisationDataAccess localisationDataAccess;
	
	public LocalisationManager() {
		localisationDataAccess = new LocalisationDerbyDataAccess();
	}
	
	/*************************************************************************************************
	 CREATE
	 *************************************************************************************************/
	public void addLocalisation() {
		localisationDataAccess.addLocalisation();
	}
	
	/*************************************************************************************************
	 READ
	 *************************************************************************************************/
	public Localisation getLocalisation(int bikeID) {
		return localisationDataAccess.getLocalisation(bikeID);
	}
	
	public ArrayList<Localisation> getAllLocalisation() {
		return localisationDataAccess.getAllLocalisation();
	}
	
	/*************************************************************************************************
	 UPDATE
	 *************************************************************************************************/
	public void updateLocalisation(Localisation localisation) {
		localisationDataAccess.updateLocalisation(localisation);
	}
	
	/*************************************************************************************************
	 DELETE
	 *************************************************************************************************/
	public void removeLocalisation() {
		localisationDataAccess.removeLocalisation();
	}
}
