package controller;

import java.util.Date;
import java.util.ArrayList;

import exception.DataAccessOperationException;
import exception.DataAccessConnectionException;
import exception.DataLengthException;
import exception.InvalidDateException;
import exception.InvalidNumberException;
import exception.NoDataException;
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
	
	public void addClient(Client client) throws DataAccessConnectionException, DataAccessOperationException {
		new ClientManager().addClient(client);
	}
	
	public void updateClient(Client client) throws DataAccessConnectionException, DataAccessOperationException {
		new ClientManager().updateClient(client);
	}
	
	public void addHouseholdMember(HouseholdMember householdMember, Client client) throws DataAccessConnectionException, DataAccessOperationException {
		new HouseholdMemberManager().addHouseholdMember(householdMember, client);
	}
	
	public void addLocality(Locality locality) throws DataAccessConnectionException, DataAccessOperationException {
		new LocalityManager().addLocality(locality);
	}
	
	public ArrayList<ArrayList<Object>> getSearch1Data(Date date, Boolean isExceptionnal, Boolean isAvailable) throws DataAccessConnectionException, DataAccessOperationException {
		return new BikeManager().getSearch1Data(date, isExceptionnal, isAvailable);
	}
	
	public ArrayList<ArrayList<Object>> getSearch2Data(Date startDate, Date endDate, BikeState state) throws DataAccessConnectionException, DataAccessOperationException {
		return new BikeManager().getSearch2Data(startDate, endDate, state);
	}
	
	public ArrayList<ArrayList<Object>> getSearch3Data(Boolean isValid, Date dateThreshold, Float minimumAmount) throws DataAccessConnectionException, DataAccessOperationException {
		return new BikeManager().getSearch3Data(isValid, dateThreshold, minimumAmount);
	}
	
	public PersonnelMember getPersonnelMember(String matricule, String password) throws DataAccessConnectionException, DataAccessOperationException, NoDataException, DataLengthException
	{
		return new PersonnelMemberManager().getPersonnelMember(matricule, password);
	}

	public ArrayList<Client> getAllClients() throws DataAccessConnectionException, DataAccessOperationException, InvalidNumberException, NoDataException, DataLengthException
	{
		return new ClientManager().getAllClients();
	}

	public void removeClient(Client client)  throws DataAccessConnectionException, DataAccessOperationException
	{
		new ClientManager().removeClient(client);		
	}

	public ArrayList<Locality> getAllLocalities()  throws DataAccessConnectionException, DataAccessOperationException, NoDataException, InvalidNumberException
	{
		return new LocalityManager().getAllLocalities();
	}

	public ArrayList<Repair> getAllRepairs()  throws DataAccessConnectionException, DataAccessOperationException, NoDataException, DataLengthException, InvalidDateException, InvalidNumberException
	{
		return new RepairManager().getAllRepairs();
	}

	public ArrayList<PersonnelMember> getAllPersonnelMembers() throws DataAccessConnectionException, DataAccessOperationException, NoDataException, DataLengthException
	{
		return new PersonnelMemberManager().getAllPersonnelMembers();
	}

	public ArrayList<Garage> getAllGarages()  throws DataAccessConnectionException, DataAccessOperationException, NoDataException, InvalidNumberException
	{
		return new GarageManager().getAllGarages();
	}

	public ArrayList<Bike> getAllBikes()  throws DataAccessConnectionException, DataAccessOperationException
	{
		return new BikeManager().getAllBikes();
	}

	public void addRepair(Repair repair)  throws DataAccessConnectionException, DataAccessOperationException
	{
		new RepairManager().addRepair(repair);	
	}

	public void updateRepair(Repair repair)  throws DataAccessConnectionException, DataAccessOperationException
	{
		new RepairManager().updateRepair(repair);
	}

	public void updateBike(Bike bike)  throws DataAccessConnectionException, DataAccessOperationException
	{
		new BikeManager().updateBike(bike);
	}
	
}
