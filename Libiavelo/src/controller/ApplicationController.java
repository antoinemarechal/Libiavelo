package controller;


import business.ClientManager;
import model.Client;
import model.HouseholdMember;

public class ApplicationController {
	
	public void addClient(Client client) {
		ClientManager clientManager = new ClientManager();
		clientManager.addClient(client);
	}
	
	public void addHouseholdMember(HouseholdMember householdMember, Client client) {
	}
	
	
}
