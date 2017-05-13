package dao;

import java.util.ArrayList;

import model.Client;
import model.Estate;
import model.Locality;

public interface LocalityDataAccess {
	/*************************************************************************************************
	 CREATE
	 *************************************************************************************************/
	public void addLocality(Locality locality);
	public void addEstateLocality(Estate estate, Locality locality);
	public void addClientLocality(Client client, Locality locality);
	
	/*************************************************************************************************
	 READ
	 *************************************************************************************************/
	public ArrayList<Locality> getAllLocalities();
	public Locality getClientLocality(Client client);
	public Locality getEstateLocality(Estate estate);
	
	/*************************************************************************************************
	 UPDATE
	 *************************************************************************************************/
	public void updateClientLocality(Client client, Locality locality);
	public void updateEstateLocality(Estate estate, Locality locality);
	
	/*************************************************************************************************
	 DELETE
	 *************************************************************************************************/
	public void removeLocality(Client client, Locality locality);
}
