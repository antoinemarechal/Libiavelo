package dao;

import java.util.ArrayList;

import model.PersonnelMember;

public interface PersonnelMemberDataAcces {
	/*************************************************************************************************
	 CREATE
	 *************************************************************************************************/
	public void addPersonnelMember(PersonnelMember personnelMember);
	
	/*************************************************************************************************
	 READ
	 *************************************************************************************************/
	public PersonnelMember getPersonnelMember(int personnelMemberID);
	public ArrayList<PersonnelMember> getAllPersonnelMembers();
	
	/*************************************************************************************************
	 UPDATE
	 *************************************************************************************************/
	public void updatePersonnelMember(PersonnelMember clipersonnelMemberent);
	
	/*************************************************************************************************
	 DELETE
	 *************************************************************************************************/
	public void removePersonnelMember();
}
