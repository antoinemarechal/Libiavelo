package model;

import java.util.ArrayList;
import java.util.Date;

import exception.InvalidNumberException;
import exception.NoDataException;

public class Client extends Person {	
	private Integer clientNumber;
	private Boolean subsriptionValidated;
	private Float depositAmount;
	
	private String streetName, streetNumber;
	private String homeNumber, phoneNumber;
	private Date subscriptionDate;
	private ArrayList<HouseholdMember> household = new ArrayList<HouseholdMember>();
	
	private Subscription subscription;
	
	private Locality locality;
	
	/*************************************************************************************************
	 CONSTRUCTORS
	 *************************************************************************************************/
	public Client(String nationalNumber) throws InvalidNumberException {
		this.setNationalNumber(nationalNumber);
	}
	
	public Client(String nationalNumber, String homeNumber, String phoneNumber, String clientSurname, String[] clientFirstNames, Boolean subscriptionValidated, Float depositAmount, String streetNumber, String streetName, Date subscriptionDate) throws InvalidNumberException, NoDataException {
		this.setNationalNumber(nationalNumber);
		this.setHomeNumber(homeNumber);
		this.setPhoneNumber(phoneNumber);
		this.setSurname(clientSurname);
		this.setFirstNames(clientFirstNames);
		this.setSubsriptionValidated(subscriptionValidated);
		this.setDepositAmount(depositAmount);
		this.setStreetName(streetName);
		this.setStreetNumber(streetNumber);
		this.setSubscriptionDate(subscriptionDate);
	}

	/*************************************************************************************************
	 GETTERS
	 *************************************************************************************************/
	public Integer getClientNumber() {
		return clientNumber;
	}

	public String getHomeNumber() {
		return homeNumber;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public Float getDepositAmount() {
		return depositAmount;
	}
	
	public String getStreetNumber() {
		return streetNumber;
	}
	
	public String getStreetName() {
		return streetName;
	}

	public Subscription getSubscription() {
		return subscription;
	}

	public ArrayList<HouseholdMember> getHousehold() {
		return household;
	}
	
	public Locality getLocality() {
		return locality;
	}
	
	public Boolean isSubsriptionValidated() {
		return subsriptionValidated;
	}
	
	public Date getSubscriptionDate() {
		return subscriptionDate;
	}
	
	/*************************************************************************************************
	 SETTERS
	 *************************************************************************************************/
	public void setHomeNumber(String homeNumber) {
		this.homeNumber = homeNumber;
	}
	
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setSubsriptionValidated(Boolean subsriptionValidated) {
		this.subsriptionValidated = subsriptionValidated;
	}

	// exception si depositAmount<0 ? ou pas pour remboursement ?
	public void setDepositAmount(Float depositAmount) {
		this.depositAmount = depositAmount;
	}

	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}
	
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	
	public void setSubscription(Subscription subscription) {
		this.subscription = subscription;
	}
	
	private void setSubscriptionDate(Date lastHouseholdRenewal) {
		this.subscriptionDate = lastHouseholdRenewal;
		
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

	public void setLocality(Locality selectedItem) {
		locality = selectedItem;
		
	}	
}