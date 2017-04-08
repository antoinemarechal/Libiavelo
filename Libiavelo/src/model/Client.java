package model;

import java.util.ArrayList;
import java.util.Date;

import exception.InvalidNumberException;
import exception.NoDataException;

public class Client extends Person {	
	private int clientNumber;
	private boolean subsriptionValidated;
	private double depositAmount;
	
	private String homeNumber, phoneNumber;
	private Date lastHouseholdRenewal;
	private ArrayList<HouseholdMember> household;
	
	private Address address;
	private Subscription subscription;
	
	/*************************************************************************************************
	 CONSTRUCTORS
	 *************************************************************************************************/
	public Client(int nationalNumber) throws InvalidNumberException {
		this.setNationalNumber(nationalNumber);
	}
	
	public Client(int nationalNumber, String homeNumber, String phoneNumber, String clientSurname, String[] clientFirstNames, boolean subsriptionValidation, double depositAmount, Address address, Date lastHouseholdRenewal, Date demand, Date expiry) throws InvalidNumberException, NoDataException {
		this.setNationalNumber(nationalNumber);
		this.setHomeNumber(homeNumber);
		this.setPhoneNumber(phoneNumber);
		this.setSurname(clientSurname);
		this.setFirstNames(clientFirstNames);
		this.setSubsriptionValidated(subsriptionValidation);
		this.setDepositAmount(depositAmount);
		this.setAddress(address);
		this.setLatestHouseholdRenewal(lastHouseholdRenewal);
		
		int subscriptioDuration = 12; // TODO : de-troll me
		String description = "az";
		this.setSubscription(new Subscription(1, demand, expiry, subscriptioDuration, description));
		}

	/*************************************************************************************************
	 GETTERS
	 *************************************************************************************************/
	public int getClientNumber() {
		return clientNumber;
	}

	public String getHomeNumber() {
		return homeNumber;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public double getDepositAmount() {
		return depositAmount;
	}
	
	public Address getAddress() {
		return address;
	}

	public Subscription getSubscription() {
		return subscription;
	}

	public ArrayList<HouseholdMember> getHousehold() {
		return household;
	}
	
	public boolean isSubsriptionValidated() {
		return subsriptionValidated;
	}
	
	public Date getLatestHouseholdRenewal() {
		return lastHouseholdRenewal;
	}
	
	/*************************************************************************************************
	 SETTERS
	 *************************************************************************************************/
	// int or not int ?
	public void setHomeNumber(String homeNumber) {
		this.homeNumber = homeNumber;
	}
	
	// int or not int ?
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setSubsriptionValidated(boolean subsriptionValidated) {
		this.subsriptionValidated = subsriptionValidated;
	}

	// exception si depositAmount<0 ? ou pas pour remboursement ?
	public void setDepositAmount(double depositAmount) {
		this.depositAmount = depositAmount;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	public void setSubscription(Subscription subscription) {
		this.subscription = subscription;
	}
	
	private void setLatestHouseholdRenewal(Date lastHouseholdRenewal) {
		this.lastHouseholdRenewal = lastHouseholdRenewal;
		
	}
	/***********************************************************************************************
	 OTHERS
	 ***********************************************************************************************/
	public void addHouseholdMember(HouseholdMember householdMember) {
		household.add(householdMember);
	}
	
	public void removeHouseholdMember(HouseholdMember householdMember) {
		household.remove(householdMember);
	}
	
}