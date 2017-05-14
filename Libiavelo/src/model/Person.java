package model;

import exception.InvalidNumberException;
import exception.NoDataException;

public abstract class Person {
	private String nationalNumber;
	
	private String surname;
	private String[] firstNames;
	
	/*************************************************************************************************
	 GETTERS
	 *************************************************************************************************/
	public String getSurname() {
		return surname;
	}
	public String[] getFirstNames() {
		return firstNames;
	}
	public String getNationalNumber() {
		return nationalNumber;
	}
	
	/*************************************************************************************************
	 SETTERS
	 *************************************************************************************************/
	public void setSurname(String surname) throws NoDataException {
		if (surname.length() == 0)
			throw new NoDataException();
		else
			this.surname = surname;
	}
	
	public void setFirstNames(String[] firstNames) {
		this.firstNames = firstNames;
	}
	
	public void setNationalNumber(String nationalNumber) throws InvalidNumberException {
//		if (nationalNumber.length() != 10) 
//			throw new InvalidNumberException(0);
//		else
			this.nationalNumber = nationalNumber;
	}
}
