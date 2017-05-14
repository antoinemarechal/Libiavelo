package model;

import exception.InvalidNumberException;
import exception.NoDataException;

public class Locality {
	private Integer id;
	
	private Integer	postalCode;
	private String cityName;
	
	/*************************************************************************************************
	 CONSTRUCTORS
	 * @throws NoDataException 
	 * @throws InvalidNumberException 
	 *************************************************************************************************/
	public Locality(String cityName, Integer postalCode) throws NoDataException, InvalidNumberException {
		this.setCityName(cityName);
		this.setPostalCode(postalCode);
	}
	
	public Locality(Integer id, String cityName, Integer postalCode) throws NoDataException, InvalidNumberException {
		this.setCityName(cityName);
		this.setPostalCode(postalCode);
		this.setId(id);
	}

	/*************************************************************************************************
	 GETTERS
	 *************************************************************************************************/
	public Integer getPostalCode() {
		return postalCode;
	}

	public String getCityName() {
		return cityName;
	}
	
	public Integer getId() {
		return id;
	}

	/*************************************************************************************************
	 SETTERS
	 * @throws InvalidNumberException 
	 *************************************************************************************************/
	public void setPostalCode(Integer postalCode) throws  InvalidNumberException {
		if ((1000 < postalCode) && (postalCode < 9999))
			this.postalCode = postalCode;
		else
			throw new InvalidNumberException(postalCode.intValue());
	}

	public void setCityName(String cityName) throws NoDataException {
		if (cityName.length() == 0)
			throw new NoDataException();
		else
			this.cityName = cityName;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	@Override
	public String toString() 
	{
		return cityName + ", " + postalCode;
	}
}
