package model;

public class Garage extends Estate {

	// =================================================================================================
	// CONSTRUCTORS
	// =================================================================================================
	public Garage(Integer id, String description, String streetName, String streetNumber, Locality locality) {
		super(id, description, streetName, streetNumber, locality);
	}
	
	// =================================================================================================
	// OTHERS
	// =================================================================================================
	@Override
	public String toString() 
	{
		return this.getDescription() + " (" + this.getLocality() + ")";
	}
}
