package dao;

import java.util.ArrayList;

import model.Localisation;

public interface LocalisationDataAccess {
	
	// ===============================================================================================
	// CREATE
	// ===============================================================================================
	public void addLocalisation(Localisation localisation);
	
	// ===============================================================================================
	// READ
	// ===============================================================================================
	public Localisation getLocalisation(int bikeID);
	public ArrayList<Localisation> getAllLocalisations();
	
	// ===============================================================================================
	// UPDATE
	// ===============================================================================================
	public void updateLocalisation(Localisation localisation);
	
	// ===============================================================================================
	// DELETE
	// ===============================================================================================
	public void removeLocalisation(Localisation localisation);
}
