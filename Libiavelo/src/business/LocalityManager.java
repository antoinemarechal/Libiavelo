package business;

import java.util.ArrayList;

import dao.LocalityDataAccess;
import dao.derby.LocalityDerbyDataAccess;
import model.Client;
import model.Estate;
import model.Locality;

public class LocalityManager {
	LocalityDataAccess localityDataAccess;
	
	public LocalityManager() {
		localityDataAccess = new LocalityDerbyDataAccess();
	}
	
	/*************************************************************************************************
	 CREATE
	 *************************************************************************************************/
	public void addLocality(Locality locality) {
		localityDataAccess.addLocality(locality);
	}
	public void addEstateLocality(Estate estate, Locality locality) {
		localityDataAccess.addEstateLocality(estate, locality);
	}
	public void addClientLocality(Client client, Locality locality) {
		localityDataAccess.addClientLocality(client, locality);
	}
	
	/*************************************************************************************************
	 READ
	 *************************************************************************************************/
	public ArrayList<Locality> getAllAddresses() {
		return localityDataAccess.getAllLocalities();
	}
	
	public Locality getClientAddress(Client client) {
		return localityDataAccess.getClientLocality(client);
	}
	
	public Locality getEstateAddress(Estate estate) {
		return localityDataAccess.getEstateLocality(estate);
	}
	
	/*************************************************************************************************
	 UPDATE
	 *************************************************************************************************/
	public void updateClientAddress(Client client, Locality locality) {
		localityDataAccess.updateClientLocality(client, locality);
	}
	
	public void updateEstateLocality(Estate estate, Locality locality) {
		localityDataAccess.updateEstateLocality(estate, locality);
	}
	
	/*************************************************************************************************
	 DELETE
	 *************************************************************************************************/
	public void removeLocality(Client client, Locality locality) {
		localityDataAccess.removeLocality(client, locality);
	}
}
