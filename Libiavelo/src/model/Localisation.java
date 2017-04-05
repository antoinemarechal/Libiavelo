package model;

public class Localisation {
	private boolean available;
	
	private Bike bike;
	private Premises premises;
	
	/*************************************************************************************************
	 CONSTRUCTORS
	 *************************************************************************************************/
	public Localisation(boolean available, Bike bike, Premises premises) {
		this.setAvailable(available);
		this.setBike(bike);
		this.setPremises(premises);
	}
	
	/*************************************************************************************************
	 CONSTRUCTORS
	 *************************************************************************************************/
	public boolean isAvailable() {
		return available;
	}
	
	public Bike getBike() {
		return bike;
	}
	
	public Premises getPremises() {
		return premises;
	}
	
	/*************************************************************************************************
	 CONSTRUCTORS
	 *************************************************************************************************/
	public void setAvailable(boolean available) {
		this.available = available;
	}
	
	public void setBike(Bike bike) {
		this.bike = bike;
	}
	
	public void setPremises(Premises premises) {
		this.premises = premises;
	}
	
	
}
