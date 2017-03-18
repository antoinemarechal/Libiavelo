package model;

import exception.InvalidNumberException;

public class Address {
	private int number, postalCode;
	
	private String street, city;
	
	public Address(String street, String city, int number, int postalCode) throws InvalidNumberException {
		this.setStreet(street);
		this.setCity(city);
		this.setNumber(number);
		this.setPostalCode(postalCode);
	}

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

	public void setStreet(String street) {
		this.street = street;
	}

	public void setCity(String city) {
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
