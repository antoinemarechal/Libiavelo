package model;

import java.util.ArrayList;
import java.util.Date;

import exception.DataLengthException;
import exception.InvalidNumberException;
import exception.NoDataException;

public class Client extends Person {	
	
	private String nationalNumber;
	
	private Integer clientNumber;
	private Boolean subsriptionValidated;
	private Float depositAmount;
	
	private String streetName, streetNumber;
	private String homeNumber, phoneNumber;
	private Date subscriptionDate;
	
	private ArrayList<HouseholdMember> household = new ArrayList<HouseholdMember>();
	
	private Subscription subscription;
	
	private Locality locality;
	
	// =================================================================================================
	// CONSTRUCTORS
	// =================================================================================================
	public Client(String nationalNumber, String homeNumber, String phoneNumber, String clientSurname, String[] clientFirstNames, Boolean subscriptionValidated, Float depositAmount, String streetNumber, String streetName, Locality locality, Date subscriptionDate) throws InvalidNumberException, NoDataException, DataLengthException {
		super(clientSurname, clientFirstNames);
		
		this.setNationalNumber(nationalNumber);
		this.setHomeNumber(homeNumber);
		this.setPhoneNumber(phoneNumber);
		this.setSubsriptionValidated(subscriptionValidated);
		this.setDepositAmount(depositAmount);
		this.setStreetName(streetName);
		this.setStreetNumber(streetNumber);
		this.setSubscriptionDate(subscriptionDate);
		this.setLocality(locality);
	}

	// =================================================================================================
	// GETTERS
	// =================================================================================================
	public String getNationalNumber() {
		return nationalNumber;
	}
	
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
		
	// =================================================================================================
	// SETTERS
	// =================================================================================================	
	public void setNationalNumber(String nationalNumber) {
		this.nationalNumber = nationalNumber;
	}
	
	public void setHomeNumber(String homeNumber) {
		this.homeNumber = homeNumber;
	}
		
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setSubsriptionValidated(Boolean subsriptionValidated) {
		this.subsriptionValidated = subsriptionValidated;
	}

	public void setDepositAmount(Float depositAmount) throws InvalidNumberException{
		if(depositAmount < 0)
			throw new InvalidNumberException("Caution", depositAmount);
		else
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
	
	public void setClientNumber(Integer clientNumber) {
		this.clientNumber = clientNumber;
	}
	
	public void setLocality(Locality locality) {
		this.locality = locality;
	}
	
	// =================================================================================================
	// OTHERS
	// =================================================================================================
	public void addHouseholdMember(HouseholdMember householdMember) {
		household.add(householdMember);
	}
	
	public void removeHouseholdMember(HouseholdMember householdMember) {
		household.remove(householdMember);
	}

}
