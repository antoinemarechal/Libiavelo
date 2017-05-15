package model;

import model.enumerations.WorkType;

public class PersonnelMember extends Person {
	private String id;
	
	private WorkType function;

	
	/*************************************************************************************************
	 CONSTRUCTORS
	 *************************************************************************************************/	
	public PersonnelMember(WorkType function) {
		this.setFunction(function);
	}
	
	public PersonnelMember() {
		// TODO Auto-generated constructor stub
	}

	/*************************************************************************************************
	 GETTERS
	 *************************************************************************************************/
	public String getId() {
		return id;
	}
	
	public WorkType getFunction() {
		return function;
	}
	
	/*************************************************************************************************
	 SETTERS
	 *************************************************************************************************/
	public void setFunction(WorkType function) {
		this.function = function;
	}
	
	public void setID(String id) {
		this.id = id;
	}
	
	@Override
	public String toString() 
	{
		return this.getSurname().toUpperCase() + " " + this.getFirstNames()[0];
	}
}
