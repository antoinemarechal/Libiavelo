package business;

import java.util.ArrayList;

import dao.PersonnelMemberDataAccess;
import dao.mysql.PersonnelMemberMySQLDataAccess;
import model.PersonnelMember;

public class PersonnelMemberManager {
	PersonnelMemberDataAccess personnelMemberDataAccess;
	
	public PersonnelMemberManager() {
		personnelMemberDataAccess = new PersonnelMemberMySQLDataAccess();
	}
	
	/*************************************************************************************************
	 CREATE
	 *************************************************************************************************/
	public void addPersonnelMember(PersonnelMember personnelMember) {
		personnelMemberDataAccess.addPersonnelMember(personnelMember);
	}
	
	/*************************************************************************************************
	 READ
	 *************************************************************************************************/
	public PersonnelMember getPersonnelMember(String matricule) {
		return personnelMemberDataAccess.getPersonnelMember(matricule);
	}
	
	public ArrayList<PersonnelMember> getAllPersonnelMembers() {
		return personnelMemberDataAccess.getAllPersonnelMembers();
	}
	
	/*************************************************************************************************
	 UPDATE
	 *************************************************************************************************/
	public void updatePersonnelMember(PersonnelMember personnelMember) {
		personnelMemberDataAccess.updatePersonnelMember(personnelMember);
	}
	
	/*************************************************************************************************
	 DELETE
	 *************************************************************************************************/
	public void removePersonnelMember() {
		personnelMemberDataAccess.removePersonnelMember();
	}
}
