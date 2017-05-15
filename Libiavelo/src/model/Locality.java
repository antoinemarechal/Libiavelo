package model;

import exception.InvalidNumberException;
import exception.NoDataException;

public class Locality {
	
	private Integer id;
	private Integer	postalCode;
	private String cityName;
	
	// =================================================================================================
	// CONSTRUCTORS
	// =================================================================================================
	public Locality(String cityName, Integer postalCode) throws NoDataException, InvalidNumberException {
		this.setCityName(cityName);
		this.setPostalCode(postalCode);
	}
	
	public Locality(Integer id, String cityName, Integer postalCode) throws NoDataException, InvalidNumberException {
		this.setId(id);
		this.setCityName(cityName);
		this.setPostalCode(postalCode);
	}

	// =================================================================================================
	// GETTERS
	// =================================================================================================
	public Integer getId() {
		return id;
	}
	
	public Integer getPostalCode() {
		return postalCode;
	}

	public String getCityName() {
		return cityName;
	}

	// =================================================================================================
	// SETTERS
	// =================================================================================================
	public void setId(Integer id) {
		this.id = id;
	}
	
	public void setPostalCode(Integer postalCode) throws  InvalidNumberException {
		if ((1000 <= postalCode) && (postalCode <= 9999))
			this.postalCode = postalCode;
		else
			throw new InvalidNumberException("Code postal", postalCode);
	}

	public void setCityName(String cityName) throws NoDataException {
		if (cityName.length() == 0)
			throw new NoDataException("Ville");
		else
			this.cityName = cityName;
	}
	
	// =================================================================================================
	// OTHERS
	// =================================================================================================
	@Override
	public String toString() 
	{
		return cityName + ", " + postalCode;
	}
}
