package business;

import java.util.ArrayList;

import dao.LocalityDataAccess;
import dao.derby.LocalityDerbyDataAccess;
import model.Locality;

public class LocalityManager {
	
	private LocalityDataAccess localityDataAccess;
	
	public LocalityManager() {
		localityDataAccess = new LocalityDerbyDataAccess();
	}
	
	// ===============================================================================================
	// CREATE
	// ===============================================================================================
	public void addLocality(Locality locality) {
		localityDataAccess.addLocality(locality);
	}
	
	// ===============================================================================================
	// READ
	// ===============================================================================================
	public Locality getLocality(int localityCode) {
		return localityDataAccess.getLocality(localityCode);
	}
	
	public ArrayList<Locality> getAllLocalities() {
		return localityDataAccess.getAllLocalities();
	}
	
	// ===============================================================================================
	// UPDATE
	// ===============================================================================================
	public void updateLocality(Locality locality) {
		localityDataAccess.updateLocality(locality);
	}
	
	// ===============================================================================================
	// DELETE
	// ===============================================================================================
	public void removeLocality(Locality locality) {
		localityDataAccess.removeLocality(locality);
	}
}
