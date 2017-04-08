package model;

public class Garage extends Estate{

	/*************************************************************************************************
	 CONSTRUCTORS
	 *************************************************************************************************/
	public Garage() {
		super.setId(Estate.generateNextId());
	}
	
	public Garage(String description) {
		super.setId(Estate.generateNextId());
		super.setDescription(description);
	}
}
