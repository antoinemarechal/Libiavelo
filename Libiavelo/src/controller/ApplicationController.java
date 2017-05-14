package controller;

import java.sql.Date;
import java.util.ArrayList;

import business.BikeManager;
import business.ClientManager;
import business.HouseholdMemberManager;
import business.LocalityManager;
import business.PersonnelMemberManager;
import model.Client;
import model.HouseholdMember;
import model.Locality;
import model.PersonnelMember;
import model.enumerations.BikeState;

public class ApplicationController {
	ClientManager clientManager;
	HouseholdMemberManager householdMemberManager;
	LocalityManager localityManager;
	BikeManager bikeManager;
	
	public void addClient(Client client) {
		clientManager = new ClientManager();
		clientManager.addClient(client);
	}
	
	public void updateClient(Client client) {
		new ClientManager().updateClient(client);
	}
	
	public void addHouseholdMember(HouseholdMember householdMember, Integer clientID) {
		householdMemberManager = new HouseholdMemberManager();
		householdMemberManager.addHouseholdMember(householdMember, clientID);
	}
	
	public void addLocality(Locality locality) {
		localityManager = new LocalityManager();
		localityManager.addLocality(locality);
	}
	
	public ArrayList<ArrayList<Object>> getSearch1Data(Date date, Boolean isExceptionnal, Boolean isAvailable) {
		bikeManager = new BikeManager();
		return bikeManager.getSearch1Data(date, isExceptionnal, isAvailable);
	}
	
	public ArrayList<ArrayList<Object>> getSearch2Data(Date startDate, Date endDate, BikeState state) {
		bikeManager = new BikeManager();
		return bikeManager.getSearch2Data(startDate, endDate, state);
	}
	
	public ArrayList<ArrayList<Object>> getSearch3Data(Boolean isValid, Date dateThreshold, Float minimumAmount) {
		bikeManager = new BikeManager();
		return bikeManager.getSearch3Data(isValid, dateThreshold, minimumAmount);
	}
	
	public PersonnelMember getPersonnelMember(String matricule, String password)
	{
		return new PersonnelMemberManager().getPersonnelMember(matricule);//FIXME:
	}

	public ArrayList<Client> getAllClients() 
	{
		return new ClientManager().getAllClients();
	}

	public void removeClient(Client client) 
	{
		new ClientManager().removeClient(client.getClientNumber());		
	}

	public ArrayList<Locality> getAllLocalities() 
	{
		return new LocalityManager().getAllLocalities();
	}
	
}
