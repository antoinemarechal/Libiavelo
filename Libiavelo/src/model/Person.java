package model;

import java.util.Date;

public abstract class Person {
	private int nationalNumber;
	
	private String surname;
	private String[] firstNames;
	private Date birthDate;
		
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
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public void setFirstNames(String[] firstNames) {
		this.firstNames = firstNames;
	}
	public void setNationalNumber(int nationalNumber) {
		this.nationalNumber = nationalNumber;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
	
}
