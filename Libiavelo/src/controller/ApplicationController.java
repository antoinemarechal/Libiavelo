package controller;

import java.sql.Date;
import java.util.ArrayList;

import business.BikeManager;
import business.ClientManager;
import business.GarageManager;
import business.HouseholdMemberManager;
import business.LocalityManager;
import business.PersonnelMemberManager;
import business.RepairManager;
import model.Bike;
import model.Client;
import model.Garage;
import model.HouseholdMember;
import model.Locality;
import model.PersonnelMember;
import model.Repair;
import model.enumerations.BikeState;

public class ApplicationController {
	
	public void addClient(Client client) {
		new ClientManager().addClient(client);
	}
	
	public void updateClient(Client client) {
		new ClientManager().updateClient(client);
	}
	
	public void addHouseholdMember(HouseholdMember householdMember, Integer clientID) {
		new HouseholdMemberManager().addHouseholdMember(householdMember, clientID);
	}
	
	public void addLocality(Locality locality) {
		new LocalityManager().addLocality(locality);
	}
	
	public ArrayList<ArrayList<Object>> getSearch1Data(Date date, Boolean isExceptionnal, Boolean isAvailable) {
		return new BikeManager().getSearch1Data(date, isExceptionnal, isAvailable);
	}
	
	public ArrayList<ArrayList<Object>> getSearch2Data(Date startDate, Date endDate, BikeState state) {
		return new BikeManager().getSearch2Data(startDate, endDate, state);
	}
	
	public ArrayList<ArrayList<Object>> getSearch3Data(Boolean isValid, Date dateThreshold, Float minimumAmount) {
		return new BikeManager().getSearch3Data(isValid, dateThreshold, minimumAmount);
	}
	
	public PersonnelMember getPersonnelMember(String matricule, String password)
	{
		return new PersonnelMemberManager().getPersonnelMember(matricule, password);
	}

	public ArrayList<Client> getAllClients() 
	{
		return new ClientManager().getAllClients();
	}

	public void removeClient(Client client) 
	{
		new ClientManager().removeClient(client);		
	}

	public ArrayList<Locality> getAllLocalities() 
	{
		return new LocalityManager().getAllLocalities();
	}

	public ArrayList<Repair> getAllRepairs() 
	{
		return new RepairManager().getAllRepairs();
	}

	public ArrayList<PersonnelMember> getAllPersonnelMembers() 
	{
		return new PersonnelMemberManager().getAllPersonnelMembers();
	}

	public ArrayList<Garage> getAllGarages() 
	{
		return new GarageManager().getAllGarages();
	}

	public ArrayList<Bike> getAllBikes() 
	{
		return new BikeManager().getAllBikes();
	}

	public void addRepair(Repair repair) 
	{
		new RepairManager().addRepair(repair);	
	}

	public void updateRepair(Repair repair) 
	{
		new RepairManager().updateRepair(repair);
	}

	public void updateBike(Bike bike) 
	{
		new BikeManager().updateBike(bike);
	}
	
}
