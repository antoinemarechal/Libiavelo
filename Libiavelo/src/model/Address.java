package model;

import exception.InvalidNumberException;
import exception.NoDataException;

public class Address {
	private int number, postalCode;
	
	private String street, city;
	
	/*************************************************************************************************
	 CONSTRUCTORS
	 *************************************************************************************************/
	public Address(String street, String city, int number, int postalCode) throws InvalidNumberException, NoDataException {
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
	public void setStreet(String street) throws NoDataException {
		if (street.length() == 0)
			throw new NoDataException();
		else
			this.street = street;
	}

	public void setCity(String city) throws NoDataException {
		if (city.length() == 0)
			throw new NoDataException();
		else
			this.city = city;
	}

	public void setNumber(int number) throws InvalidNumberException{
		if (number < 1)
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