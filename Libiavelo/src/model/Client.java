package model;

import java.util.ArrayList;
import java.util.Date;

public class Client extends Person {
	private static int newClientNumber = 1;
	
	private int clientNumber;
	private boolean subsriptionValidated;
	private double depositAmount;
	
	private String homeNumber, phoneNumber;
	private Date subscriptionDate;
	private ArrayList<HouseholdMember> household;
	
	private Address address;
	
	/*************************************************************************************************
	 GETTERS
	 *************************************************************************************************/
	public int getClientNumber() {
		return clientNumber;
	}

	public int getNationalNumber() {
		return super.getNationalNumber();
	}

	public String getHomeNumber() {
		return homeNumber;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getSurname() {
		return super.getSurname();
	}

	public String[] getFirstNames() {
		return super.getFirstNames();
	}

	public double getDepositAmount() {
		return depositAmount;
	}
	
	public Address getAddress() {
		return address;
	}

	public Date getSubscriptionDate() {
		return subscriptionDate;
	}

	public ArrayList<HouseholdMember> getHousehold() {
		return household;
	}
	
	public boolean isSubsriptionValidated() {
		return subsriptionValidated;
	}
	
	/*************************************************************************************************
	 SETTERS
	 *************************************************************************************************/

	// illogique car pas supposer être modifié, à supprimer ?
	public void setClientNumber(int clientNumber) {
		this.clientNumber = clientNumber;
	}
	
	// illogique car pas supposer être modifié, à supprimer ?
	public void setNationalNumber(int nationalNumber) {
		super.setNationalNumber(nationalNumber);
	}

	// int or not int ?
	public void setHomeNumber(String homeNumber) {
		this.homeNumber = homeNumber;
	}
	
	// int or not int ?
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setSurname(String surname) {
		super.setSurname(surname);
	}

	public void setFirstNames(String[] firstNames) {
		super.setFirstNames(firstNames);
	}

	public void setSubsriptionValidated(boolean subsriptionValidated) {
		this.subsriptionValidated = subsriptionValidated;
	}

	// exception si depositAmoint<0 ? ou pas pour remboursement ?
	public void setDepositAmount(double depositAmount) {
		this.depositAmount = depositAmount;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	public void setSubscriptionDate(Date subscriptionDate) {
		this.subscriptionDate = subscriptionDate;
	}
	
	/***********************************************************************************************
	 * CONSTRUCTORS
	 ***********************************************************************************************/
	
	public Client (int nationalNumber) {
		this.clientNumber = newClientNumber;
		newClientNumber++;
		this.setNationalNumber(nationalNumber);
	}
	
	public Client( int nationalNumber,String homeNumber, String phoneNumber, String clientSurname, String[] clientFirstNames, boolean subsriptionValidation, double depositAmount, Address address) {
		clientNumber = newClientNumber;
		newClientNumber++;
		
		this.setNationalNumber(nationalNumber);
		this.setHomeNumber(homeNumber);
		this.setPhoneNumber(phoneNumber);
		this.setSurname(clientSurname);
		this.setFirstNames(clientFirstNames);
		this.setSubsriptionValidated(subsriptionValidation);
		this.setDepositAmount(depositAmount);
		this.setAddress(address);
		}	
	
	/***********************************************************************************************
	 * OTHERS
	 ***********************************************************************************************/
	
	public void addHouseholdMember(HouseholdMember householdMember) {
		household.add(householdMember);
	}
}