package dao;

import java.util.ArrayList;

import model.PersonnelMember;

public interface PersonnelMemberDataAccess {

	// ===============================================================================================
	// CREATE
	// ===============================================================================================
	public void addPersonnelMember(PersonnelMember personnelMember);
	
	// ===============================================================================================
	// READ
	// ===============================================================================================
	public PersonnelMember getPersonnelMember(String matricule, String password);
	public ArrayList<PersonnelMember> getAllPersonnelMembers();
	
	// ===============================================================================================
	// UPDATE
	// ===============================================================================================
	public void updatePersonnelMember(PersonnelMember personnelMember);
	
	// ===============================================================================================
	// DELETE
	// ===============================================================================================
	public void removePersonnelMember(PersonnelMember personnelMember);	
}
