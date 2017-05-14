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

public class ApplicationController {
	ClientManager clientManager;
	HouseholdMemberManager householdMemberManager;
	LocalityManager localityManager;
	BikeManager bikeManager;
	
	public void addClient(Client client) {
		clientManager = new ClientManager();
		clientManager.addClient(client);
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
	
	public PersonnelMember getPersonnelMember(String matricule)
	{
		return new PersonnelMemberManager().getPersonnelMember(matricule);
	}
	
}
