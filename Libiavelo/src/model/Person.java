package model;

import exception.NoDataException;
import exception.DataLengthException;

public class Person {
		
	private String surname;
	private String[] firstNames;
	
	// =================================================================================================
	// CONSTRUCTORS
	// =================================================================================================
	public Person(String surname, String[] firstNames) throws NoDataException, DataLengthException {
		this.setSurname(surname);
		this.setFirstNames(firstNames);
	}
	
	// =================================================================================================
	// GETTERS 
	// =================================================================================================
	public String getSurname() {
		return surname;
	}
	
	public String[] getFirstNames() {
		return firstNames;
	}
	
	// =================================================================================================
	// SETTERS 
	// =================================================================================================
	public void setSurname(String surname) throws NoDataException, DataLengthException {
		if (surname.length() == 0)
			throw new NoDataException("Nom");
		else if(surname.length() > 30)
			throw new DataLengthException("Nom", 30);
		else
			this.surname = surname;
	}
	
	public void setFirstNames(String[] firstNames) {
		this.firstNames = firstNames;
	}
}
