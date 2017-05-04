package controller;


import business.ClientManager;
import business.HouseholdMemberManager;
import model.Client;
import model.HouseholdMember;

public class ApplicationController {
	ClientManager clientManager;
	HouseholdMemberManager householdMemberManager;
	
	public void addClient(Client client) {
		clientManager = new ClientManager();
		clientManager.addClient(client);
	}
	
	public void addHouseholdMember(HouseholdMember householdMember, Client client) {
		householdMemberManager = new HouseholdMemberManager();
		householdMemberManager.addHouseholdMember(householdMember, client);
	}
	
	
}
