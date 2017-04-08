package model;

import java.util.Date;

import exception.InvalidNumberException;
import exception.NoDataException;

public class HouseholdMember extends Person {
	/*************************************************************************************************
	 CONSTRUCTORS
	 *************************************************************************************************/
	public HouseholdMember(int nationalNumber) throws InvalidNumberException {
		super.setNationalNumber(nationalNumber);
	}
	
	public HouseholdMember(Date birthDate, String[] firstNames, int nationalNumber, String clientSurname) throws InvalidNumberException, NoDataException{
		super.setBirthDate(birthDate);
		super.setFirstNames(firstNames);
		super.setNationalNumber(nationalNumber);
		super.setSurname(clientSurname);
	}
}
