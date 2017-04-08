package model;

import exception.InvalidNumberException;

public class BikeStation extends Estate {
	private int lowerBikeSoftLimit, lowerBikeHardLimit;
	private int upperBikeSoftLimit, upperBikeHardLimit;
	
	/*************************************************************************************************
	 CONSTRUCTORS
	 *************************************************************************************************/	
	public BikeStation(int lowerBikeSoftLimit, int lowerBikeHardLimit, int upperBikeSoftLimit, int upperBikeHardLimit) throws InvalidNumberException {
		super.setId(Estate.generateNextId());
		this.setLowerBikeSoftLimit(lowerBikeSoftLimit);
		this.setLowerBikeHardLimit(lowerBikeHardLimit);
		this.setUpperBikeSoftLimit(upperBikeSoftLimit);
		this.setUpperBikeHardLimit(upperBikeHardLimit);
	}
	
	/*************************************************************************************************
	 GETTERS
	 *************************************************************************************************/
	public int getLowerBikeSoftLimit() {
		return lowerBikeSoftLimit;
	}
	public int getLowerBikeHardLimit() {
		return lowerBikeHardLimit;
	}
	public int getUpperBikeSoftLimit() {
		return upperBikeSoftLimit;
	}
	public int getUpperBikeHardLimit() {
		return upperBikeHardLimit;
	}
	
	/*************************************************************************************************
	 SETTERS
	 *************************************************************************************************/
	public void setLowerBikeSoftLimit(int lowerBikeSoftLimit) throws InvalidNumberException {
		if (lowerBikeSoftLimit < 0)
			throw new InvalidNumberException(lowerBikeSoftLimit);
		else
			this.lowerBikeSoftLimit = lowerBikeSoftLimit;
	}
	
	public void setLowerBikeHardLimit(int lowerBikeHardLimit) throws InvalidNumberException {
		if (lowerBikeHardLimit < 0)
			throw new InvalidNumberException(lowerBikeHardLimit);
		else
			this.lowerBikeHardLimit = lowerBikeHardLimit;
	}
	
	public void setUpperBikeSoftLimit(int upperBikeSoftLimit) throws InvalidNumberException {
		if (upperBikeSoftLimit < 0)
			throw new InvalidNumberException(upperBikeSoftLimit);
		else
			this.upperBikeSoftLimit = upperBikeSoftLimit;
	}
	
	public void setUpperBikeHardLimit(int upperBikeHardLimit) throws InvalidNumberException {
		if (upperBikeHardLimit < 0)
			throw new InvalidNumberException(upperBikeHardLimit);	
		else
			this.upperBikeHardLimit = upperBikeHardLimit;
	}	
}
