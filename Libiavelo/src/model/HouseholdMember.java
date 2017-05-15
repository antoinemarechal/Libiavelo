package model;

import java.util.Date;

import exception.DataLengthException;
import exception.InvalidNumberException;
import exception.NoDataException;

public class HouseholdMember extends Person {
	
	private String nationalNumber;
	
	private Date birthDate;
	
	// =================================================================================================
	// CONSTRUCTORS
	// =================================================================================================
	public HouseholdMember(String nationalNumber, String surname, String[] firstNames, Date birthDate) throws InvalidNumberException, NoDataException, DataLengthException{
		super(surname, firstNames);
		
		this.setNationalNumber(nationalNumber);
		this.setBirthDate(birthDate);
	}
	
	// =================================================================================================
	// GETTERS
	// =================================================================================================
	public String getNationalNumber() {
		return nationalNumber;
	}
	
	public Date getBirthDate() {
		return birthDate;
	}
	
	// =================================================================================================
	// SETTERS
	// =================================================================================================
	public void setNationalNumber(String nationalNumber) {
		this.nationalNumber = nationalNumber;
	}
	
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
}
