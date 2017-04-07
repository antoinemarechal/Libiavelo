package controller;

import java.util.Date;

import exception.EmptyStringException;
import exception.InvalidNumberException;
import model.Address;
import model.Client;
import model.HouseholdMember;

public class ConfirmationButtonService {
	
	// prolly à faire non static, c'était plus simple de start comme ça
	public static void addClient(int nationalNumber, String homeNumber, String phoneNumber, String surname, String[] firstNames, boolean subsriptionValidation, double depositAmount, Address address, Date lastHouseholdRenewal, Date demand, Date expiry) throws InvalidNumberException, EmptyStringException {
		
		Client client = new Client(nationalNumber, homeNumber, phoneNumber, surname, firstNames, subsriptionValidation, depositAmount, address, lastHouseholdRenewal, demand, expiry);
	}
	
	// prolly à faire non static, c'était plus simple de start comme ça
	public static void addHouseholdMember(Date birthDate, String[] firstNames, int nationalNumber, String clientSurname) throws InvalidNumberException, EmptyStringException {
		HouseholdMember householdMember = new HouseholdMember(birthDate, firstNames, nationalNumber, clientSurname);
	}
	
	
}
