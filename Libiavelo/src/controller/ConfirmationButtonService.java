package controller;

import java.util.Date;

import exception.NoDataException;
import exception.InvalidNumberException;
import model.Address;
import model.Client;
import model.HouseholdMember;

public class ConfirmationButtonService {
	
	// prolly � faire non static, c'�tait plus simple de start comme �a
	public static void addClient(int nationalNumber, String homeNumber, String phoneNumber, String surname, String[] firstNames, boolean subsriptionValidation, double depositAmount, Address address, Date lastHouseholdRenewal, Date demand, Date expiry) throws InvalidNumberException, NoDataException {
		
		Client client = new Client(nationalNumber, homeNumber, phoneNumber, surname, firstNames, subsriptionValidation, depositAmount, address, lastHouseholdRenewal, demand, expiry);
	}
	
	// prolly � faire non static, c'�tait plus simple de start comme �a
	public static void addHouseholdMember(Date birthDate, String[] firstNames, int nationalNumber, String clientSurname) throws InvalidNumberException, NoDataException {
		HouseholdMember householdMember = new HouseholdMember(birthDate, firstNames, nationalNumber, clientSurname);
	}
	
	
}
