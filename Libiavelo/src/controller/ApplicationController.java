package controller;


import java.util.ArrayList;

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
	
	public PersonnelMember getPersonnelMember(String matricule)
	{
		return new PersonnelMemberManager().getPersonnelMember(matricule);
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
