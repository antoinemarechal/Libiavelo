package model;

public class Garage extends Premises{

	/*************************************************************************************************
	 CONSTRUCTORS
	 *************************************************************************************************/
	public Garage() {
		super.setId(Premises.generateNextId());
	}
	
	public Garage(String description) {
		super.setId(Premises.generateNextId());
		super.setDescription(description);
	}
}
