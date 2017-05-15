package model;

public class Localisation {
	
	private Boolean available;
	private Bike bike;
	private Estate premises;
	
	// =================================================================================================
	// CONSTRUCTORS
	// =================================================================================================
	public Localisation(Boolean available, Bike bike, Estate premises) {
		this.setAvailable(available);
		this.setBike(bike);
		this.setPremises(premises);
	}
	
	// =================================================================================================
	// GETTERS
	// =================================================================================================
	public boolean isAvailable() {
		return available;
	}
	
	public Bike getBike() {
		return bike;
	}
	
	public Estate getPremises() {
		return premises;
	}
	
	// =================================================================================================
	// SETTERS
	// =================================================================================================
	public void setAvailable(boolean available) {
		this.available = available;
	}
	
	public void setBike(Bike bike) {
		this.bike = bike;
	}
	
	public void setPremises(Estate premises) {
		this.premises = premises;
	}	
}
