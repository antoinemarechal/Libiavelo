package model;

import java.util.Date;

import exception.EmptyStringException;
import exception.InvalidDateException;

public class Repair {
	private String description;
	private String note;
	
	private Date startDate;
	private Date endDate;
	
	private Garage garage;
	private Bike bike;
	private PersonnelMember verifier;
	
	/*************************************************************************************************
	 CONSTRUCTORS
	 *************************************************************************************************/
	public Repair(Bike bike, Date startDate, Garage garage, PersonnelMember verifier) {
		this.setBike(bike);
		this.setStartDate(startDate);
		this.setGarage(garage);
		this.setVerifier(verifier);
	}
	
	/*************************************************************************************************
	 GETTERS
	 *************************************************************************************************/
	public String getDescription() {
		return description;
	}
	public String getNote() {
		return note;
	}
	public Date getRepairStartDate() {
		return startDate;
	}
	public Date getRepairEndDate() {
		return endDate;
	}
	
	public Bike getBike() {
		return bike;
	}
	
	public Garage getGarage() {
		return garage;
	}
	
	public PersonnelMember getVerifier() {
		return verifier;
	}
	/*************************************************************************************************
	 SETTERS
	 *************************************************************************************************/
	public void setDescription(String description) throws EmptyStringException {
		if (description.length() == 0) 
			throw new EmptyStringException(description);
		else
			this.description = description;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	public void setEndDate(Date endDate) throws InvalidDateException {
		if (this.startDate.after(endDate))
			throw new InvalidDateException(endDate, startDate);
		else
			this.endDate = endDate;
	}
	
	public void setBike(Bike bike) {
		this.bike = bike;
	}
	
	public void setGarage(Garage garage) {
		this.garage = garage;
	}
	
	public void setVerifier(PersonnelMember verifier) {
		this.verifier = verifier;
	}
}