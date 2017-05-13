package model;

import java.util.Date;

import exception.InvalidNumberException;
import exception.NoDataException;

public class HouseholdMember extends Person {
	private Date birthDate;
	
	/*************************************************************************************************
	 CONSTRUCTORS
	 *************************************************************************************************/
	public HouseholdMember(String nationalNumber) throws InvalidNumberException {
		super.setNationalNumber(nationalNumber);
	}
	
	public HouseholdMember(Date birthDate, String[] firstNames, String nationalNumber, String surname) throws InvalidNumberException, NoDataException{
		this.setBirthDate(birthDate);
		super.setFirstNames(firstNames);
		super.setNationalNumber(nationalNumber);
		super.setSurname(surname);
	}
	
	public Date getBirthDate() {
		return birthDate;
	}
	
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
}
