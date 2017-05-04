package business;

import java.util.ArrayList;

import dao.derby.PersonnelMemberDerbyDataAccess;
import model.PersonnelMember;

public class PersonnelMemberManager {
	PersonnelMemberDerbyDataAccess personnelMemberDataAccess;
	
	public PersonnelMemberManager() {
		personnelMemberDataAccess = new PersonnelMemberDerbyDataAccess();
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
	public PersonnelMember getPersonnelMember(int personnelMemberID) {
		return personnelMemberDataAccess.getPersonnelMember(personnelMemberID);
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
