package dao;

import java.util.ArrayList;

import exception.DataAccessConnectionException;
import exception.DataAccessOperationException;
import exception.DataLengthException;
import exception.NoDataException;
import model.PersonnelMember;

public interface PersonnelMemberDataAccess {

	// ===============================================================================================
	// CREATE
	// ===============================================================================================
	public void addPersonnelMember(PersonnelMember personnelMember) throws DataAccessConnectionException, DataAccessOperationException;
	
	// ===============================================================================================
	// READ
	// ===============================================================================================
	public PersonnelMember getPersonnelMember(String matricule) throws DataAccessConnectionException, DataAccessOperationException, NoDataException, DataLengthException; 
	public PersonnelMember getPersonnelMember(String matricule, String password) throws DataAccessConnectionException, DataAccessOperationException, NoDataException, DataLengthException;
	public ArrayList<PersonnelMember> getAllPersonnelMembers() throws DataAccessConnectionException, DataAccessOperationException, NoDataException, DataLengthException;
	
	// ===============================================================================================
	// UPDATE
	// ===============================================================================================
	public void updatePersonnelMember(PersonnelMember personnelMember) throws DataAccessConnectionException, DataAccessOperationException;
	
	// ===============================================================================================
	// DELETE
	// ===============================================================================================
	public void removePersonnelMember(PersonnelMember personnelMember) throws DataAccessConnectionException, DataAccessOperationException;

}
