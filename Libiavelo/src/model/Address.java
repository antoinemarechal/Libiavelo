package model;

import exception.InvalidNumberException;
import exception.EmptyStringException;

public class Address {
	private int number, postalCode;
	
	private String street, city;
	
	/*************************************************************************************************
	 CONSTRUCTORS
	 *************************************************************************************************/
	public Address(String street, String city, int number, int postalCode) throws InvalidNumberException, EmptyStringException {
		this.setStreet(street);
		this.setCity(city);
		this.setNumber(number);
		this.setPostalCode(postalCode);
	}

	/*************************************************************************************************
	 GETTERS
	 *************************************************************************************************/
	public String getStreet() {
		return street;
	}

	public String getCity() {
		return city;
	}

	public int getNumber() {
		return number;
	}

	public int getPostalCode() {
		return postalCode;
	}

	/*************************************************************************************************
	 SETTERS
	 *************************************************************************************************/
	public void setStreet(String street) throws EmptyStringException {
		if (street.length() == 0)
			throw new EmptyStringException(street);
		else
			this.street = street;
	}

	public void setCity(String city) throws EmptyStringException {
		if (city.length() == 0)
			throw new EmptyStringException(city);
		else
			this.city = city;
	}

	public void setNumber(int number) throws InvalidNumberException{
		if (number < 0)
			throw new InvalidNumberException(number);
		else
			this.number = number;
	}

	public void setPostalCode(int postalCode) throws InvalidNumberException {
		if (number < 0)
			throw new InvalidNumberException(number);
		else
			this.postalCode = postalCode;
	}
}