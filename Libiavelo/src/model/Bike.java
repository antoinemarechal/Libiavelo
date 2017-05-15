package model;

import model.enumerations.BikeState;

public class Bike {
	private Integer id;
		
	private BikeState state;

	/*************************************************************************************************
	 CONSTRUCTORS
	 *************************************************************************************************/
	public Bike() {		
		state = BikeState.WORKING;
	}
	
	/*************************************************************************************************
	 GETTERS
	 *************************************************************************************************/
	public int getId() {
		return id;
	}

	public BikeState getState() {
		return state;
	}
	
	/*************************************************************************************************
	 SETTERS
	 *************************************************************************************************/
	public void setState(BikeState state) {
		this.state = state;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Override
	public String toString() 
	{
		return "Velo n�" + id;
	}
}
