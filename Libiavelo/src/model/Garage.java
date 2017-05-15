package model;

public class Garage extends Estate{

	/*************************************************************************************************
	 CONSTRUCTORS
	 *************************************************************************************************/
	public Garage() {
		super();
	}
	
	public Garage(String description, String streetName, String streetNumber, Locality locality) {
		super();
		super.setDescription(description);
		super.setStreetName(streetName);
		super.setStreetNumber(streetNumber);
		super.setLocality(locality);
	}
	
	@Override
	public String toString() 
	{
		return this.getDescription() + " (" + this.getLocality() + ")";
	}
}
