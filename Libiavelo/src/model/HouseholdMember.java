package model;

import java.util.Date;

public class HouseholdMember extends Person {

	public HouseholdMember(Date birthDate, String[] firstNames, int nationalNumber, String clientSurname) {
		super.setBirthDate(birthDate);
		super.setFirstNames(firstNames);
		super.setNationalNumber(nationalNumber);
		super.setSurname(clientSurname);
	}
}
