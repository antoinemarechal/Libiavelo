package model;

import exception.InvalidNumberException;

public class BikeStation extends Estate {
	
	private Integer lowerBikeSoftLimit, lowerBikeHardLimit;
	private Integer upperBikeSoftLimit, upperBikeHardLimit;
	
	// =================================================================================================
	// CONSTRUCTORS 
	// =================================================================================================
	public BikeStation(Integer id, Locality locality, String streetName, String streetNumber, String description, Integer lowerBikeSoftLimit, Integer lowerBikeHardLimit, Integer upperBikeSoftLimit, Integer upperBikeHardLimit) throws InvalidNumberException {
		super(id, description, streetName, streetNumber, locality);
		
		this.setLowerBikeSoftLimit(lowerBikeSoftLimit);
		this.setLowerBikeHardLimit(lowerBikeHardLimit);
		this.setUpperBikeSoftLimit(upperBikeSoftLimit);
		this.setUpperBikeHardLimit(upperBikeHardLimit);
	}
	
	// =================================================================================================
	// GETTERS 
	// =================================================================================================
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
	
	// =================================================================================================
	// SETTERS 
	// =================================================================================================
	public void setLowerBikeSoftLimit(Integer lowerBikeSoftLimit) throws InvalidNumberException {
		if (lowerBikeSoftLimit < 0)
			throw new InvalidNumberException("Limite basse de vélos", lowerBikeSoftLimit);
		else
			this.lowerBikeSoftLimit = lowerBikeSoftLimit;
	}
	
	public void setLowerBikeHardLimit(Integer lowerBikeHardLimit) throws InvalidNumberException {
		if (lowerBikeHardLimit < 0)
			throw new InvalidNumberException("Limite basse extrême de vélos", lowerBikeHardLimit);
		else
			this.lowerBikeHardLimit = lowerBikeHardLimit;
	}
	
	public void setUpperBikeSoftLimit(Integer upperBikeSoftLimit) throws InvalidNumberException {
		if (upperBikeSoftLimit < 0)
			throw new InvalidNumberException("Limite haute de vélos", upperBikeSoftLimit);
		else
			this.upperBikeSoftLimit = upperBikeSoftLimit;
	}
	
	public void setUpperBikeHardLimit(Integer upperBikeHardLimit) throws InvalidNumberException {
		if (upperBikeHardLimit < 0)
			throw new InvalidNumberException("Limite haute extrême de vélos", upperBikeHardLimit);	
		else
			this.upperBikeHardLimit = upperBikeHardLimit;
	}	
}
