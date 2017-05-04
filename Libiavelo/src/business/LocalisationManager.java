package business;

import java.util.ArrayList;

import dao.derby.LocalisationDerbyDataAccess;
import model.Localisation;

public class LocalisationManager {
	LocalisationDerbyDataAccess localisationDataAccess;
	
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
	public Localisation getLocalisation() {
		return localisationDataAccess.getLocalisation();
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
