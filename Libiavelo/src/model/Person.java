package model;

import java.util.Date;

import exception.InvalidNumberException;
import exception.EmptyStringException;

public abstract class Person {
	private int nationalNumber;
	
	private String surname;
	private String[] firstNames;
	private Date birthDate;
	
	/*************************************************************************************************
	 GETTERS
	 *************************************************************************************************/
	public String getSurname() {
		return surname;
	}
	public String[] getFirstNames() {
		return firstNames;
	}
	public int getNationalNumber() {
		return nationalNumber;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	
	/*************************************************************************************************
	 SETTERS
	 *************************************************************************************************/
	public void setSurname(String surname) throws EmptyStringException {
		if (surname.length() == 0)
			throw new EmptyStringException(surname);
		else
			this.surname = surname;
	}
	
	public void setFirstNames(String[] firstNames) {
		this.firstNames = firstNames;
	}
	
	// visibilité pack
	void setNationalNumber(int nationalNumber) throws InvalidNumberException {
		if (nationalNumber < 0) 
			throw new InvalidNumberException(nationalNumber);
		else
			this.nationalNumber = nationalNumber;
	}
	
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
}
