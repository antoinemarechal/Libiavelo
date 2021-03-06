package model;

import java.util.Date;

import exception.NoDataException;
import exception.InvalidDateException;

public class Repair {
		
	private Bike bike;
	
	private Date startDate;
	private Date endDate;
	
	private String description;
	private String note;
	
	private Garage garage;
	private PersonnelMember verifier;
	
	// =================================================================================================
	// CONSTRUCTORS
	// =================================================================================================
	public Repair(Bike bike, Date startDate, Garage garage, PersonnelMember verifier, String description) throws NoDataException {
		this.setBike(bike);
		this.setStartDate(startDate);
		this.setGarage(garage);
		this.setVerifier(verifier);
		this.setDescription(description);
	}
	
	// =================================================================================================
	// GETTERS
	// =================================================================================================
	public Bike getBike() {
		return bike;
	}
	
	public Date getRepairStartDate() {
		return startDate;
	}
	
	public Date getRepairEndDate() {
		return endDate;
	}
	
	public String getDescription() {
		return description;
	}
	
	public String getNotes() {
		return note;
	}
	
	public Garage getGarage() {
		return garage;
	}
	
	public PersonnelMember getVerifier() {
		return verifier;
	}
	
	// =================================================================================================
	// SETTERS
	// =================================================================================================
	public void setBike(Bike bike) {
		this.bike = bike;
	}
	
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	public void setEndDate(Date endDate) throws InvalidDateException {
		if (this.startDate.after(endDate))
			throw new InvalidDateException("Date de fin des r�parations", endDate, "Date de d�but des r�parations", startDate);
		else
			this.endDate = endDate;
	}
	
	public void setDescription(String description) throws NoDataException {
		if (description.length() == 0) 
			throw new NoDataException("Description du probl�me");
		else
			this.description = description;
	}
	
	public void setNotes(String note) {
		this.note = note;
	}
	
	public void setGarage(Garage garage) {
		this.garage = garage;
	}
	
	public void setVerifier(PersonnelMember verifier) {
		this.verifier = verifier;
	}
}
