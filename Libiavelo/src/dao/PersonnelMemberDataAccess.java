package dao;

import java.util.ArrayList;

import model.PersonnelMember;

public interface PersonnelMemberDataAccess {
	/*************************************************************************************************
	 CREATE
	 *************************************************************************************************/
	public void addPersonnelMember(PersonnelMember personnelMember);
	
	/*************************************************************************************************
	 READ
	 *************************************************************************************************/
	public PersonnelMember getPersonnelMember(String matricule);
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
