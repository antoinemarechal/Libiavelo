package model;

public class Bike {
	private int id;
	private static int idGenerator = 0;
	
	private BikeState state;

	/*************************************************************************************************
	 CONSTRUCTORS
	 *************************************************************************************************/
	public Bike() {
		this.id = idGenerator;
		idGenerator++;
		
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
}
