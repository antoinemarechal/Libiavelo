package model;

import exception.DataLengthException;
import exception.NoDataException;
import model.enumerations.WorkType;

public class PersonnelMember extends Person {
	
	private String id;
	private WorkType function;

	// =================================================================================================
	// CONSTRUCTORS
	// =================================================================================================
	public PersonnelMember(String matricule, String surname, String[] firstNames, WorkType function) throws NoDataException, DataLengthException {
		super(surname, firstNames);
		
		this.setId(matricule);
		this.setFunction(function);
	}

	// =================================================================================================
	// GETTERS
	// =================================================================================================
	public String getId() {
		return id;
	}
	
	public WorkType getFunction() {
		return function;
	}
	
	// =================================================================================================
	// SETTERS
	// =================================================================================================
	public void setId(String id) {
		this.id = id;
	}
	
	public void setFunction(WorkType function) {
		this.function = function;
	}
	
	// =================================================================================================
	// OTHERS
	// =================================================================================================
	@Override
	public String toString() 
	{
		return this.getSurname().toUpperCase() + " " + this.getFirstNames()[0];
	}
}
