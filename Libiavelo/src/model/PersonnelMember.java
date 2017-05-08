package model;

import model.enumerations.WorkType;

public class PersonnelMember extends Person {
	private Integer id;
	
	private WorkType function;
	
	/*************************************************************************************************
	 CONSTRUCTORS
	 *************************************************************************************************/	
	public PersonnelMember(WorkType function) {
		this.setFunction(function);
	}
	
	/*************************************************************************************************
	 GETTERS
	 *************************************************************************************************/
	public int getId() {
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
	
	public void setID(int id) {
		this.id = id;
	}
}
