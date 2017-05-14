package model;

import exception.InvalidNumberException;

public class BikeStation extends Estate {
	private Integer lowerBikeSoftLimit, lowerBikeHardLimit;
	private Integer upperBikeSoftLimit, upperBikeHardLimit;
	
	/*************************************************************************************************
	 CONSTRUCTORS
	 *************************************************************************************************/	
	public BikeStation(Integer id, Locality locality, String streetName, String streetNumber, String description, Integer lowerBikeSoftLimit, Integer lowerBikeHardLimit, Integer upperBikeSoftLimit, Integer upperBikeHardLimit) throws InvalidNumberException, NullPointerException{
		super();
		super.setId(id);
		super.setDescription(description);
		super.setLocality(locality);
		super.setStreetName(streetName);
		super.setStreetNumber(streetNumber);
		this.setLowerBikeSoftLimit(lowerBikeSoftLimit);
		this.setLowerBikeHardLimit(lowerBikeHardLimit);
		this.setUpperBikeSoftLimit(upperBikeSoftLimit);
		this.setUpperBikeHardLimit(upperBikeHardLimit);
	}
	
	/*************************************************************************************************
	 GETTERS
	 *************************************************************************************************/
	public Integer getLowerBikeSoftLimit() {
		return lowerBikeSoftLimit;
	}
	public Integer getLowerBikeHardLimit() {
		return lowerBikeHardLimit;
	}
	public Integer getUpperBikeSoftLimit() {
		return upperBikeSoftLimit;
	}
	public Integer getUpperBikeHardLimit() {
		return upperBikeHardLimit;
	}
	
	/*************************************************************************************************
	 SETTERS
	 *************************************************************************************************/
	public void setLowerBikeSoftLimit(Integer lowerBikeSoftLimit) throws InvalidNumberException, NullPointerException {
		if (lowerBikeSoftLimit == null)
			throw new NullPointerException();
		if (lowerBikeSoftLimit < 0)
			throw new InvalidNumberException(lowerBikeSoftLimit);
		else
			this.lowerBikeSoftLimit = lowerBikeSoftLimit;
	}
	
	public void setLowerBikeHardLimit(Integer lowerBikeHardLimit) throws InvalidNumberException, NullPointerException {
		if (lowerBikeHardLimit == null)
			throw new NullPointerException();
		if (lowerBikeHardLimit < 0)
			throw new InvalidNumberException(lowerBikeHardLimit);
		else
			this.lowerBikeHardLimit = lowerBikeHardLimit;
	}
	
	public void setUpperBikeSoftLimit(Integer upperBikeSoftLimit) throws InvalidNumberException, NullPointerException {
		if (upperBikeSoftLimit == null)
			throw new NullPointerException();
		if (upperBikeSoftLimit < 0)
			throw new InvalidNumberException(upperBikeSoftLimit);
		else
			this.upperBikeSoftLimit = upperBikeSoftLimit;
	}
	
	public void setUpperBikeHardLimit(Integer upperBikeHardLimit) throws InvalidNumberException, NullPointerException {
		if (upperBikeHardLimit == null)
			throw new NullPointerException();
		if (upperBikeHardLimit < 0)
			throw new InvalidNumberException(upperBikeHardLimit);	
		else
			this.upperBikeHardLimit = upperBikeHardLimit;
	}	
}
