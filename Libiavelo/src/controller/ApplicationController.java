package controller;


import business.ClientManager;
import business.HouseholdMemberManager;
import business.PersonnelMemberManager;
import model.Client;
import model.HouseholdMember;
import model.PersonnelMember;

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
	
	
	public PersonnelMember getPersonnelMember(String matricule)
	{
		return new PersonnelMemberManager().getPersonnelMember(matricule);
	}
	
}
