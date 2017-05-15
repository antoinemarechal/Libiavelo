package business;

import java.util.ArrayList;

import dao.PersonnelMemberDataAccess;
import dao.derby.PersonnelMemberDerbyDataAccess;
import exception.DataAccessConnectionException;
import exception.DataAccessOperationException;
import exception.DataLengthException;
import exception.NoDataException;
import model.PersonnelMember;

public class PersonnelMemberManager {
	
	private PersonnelMemberDataAccess personnelMemberDataAccess;
	
	public PersonnelMemberManager() {
		personnelMemberDataAccess = new PersonnelMemberDerbyDataAccess();
	}
	
	// ===============================================================================================
	// CREATE
	// ===============================================================================================
	public void addPersonnelMember(PersonnelMember personnelMember) throws DataAccessConnectionException, DataAccessOperationException {
		personnelMemberDataAccess.addPersonnelMember(personnelMember);
	}
	
	// ===============================================================================================
	// READ
	// ===============================================================================================
	public PersonnelMember getPersonnelMember(String matricule, String password) throws DataAccessConnectionException, DataAccessOperationException, NoDataException, DataLengthException {
		return personnelMemberDataAccess.getPersonnelMember(matricule, password);
	}
	
	public ArrayList<PersonnelMember> getAllPersonnelMembers() throws DataAccessConnectionException, DataAccessOperationException, NoDataException, DataLengthException {
		return personnelMemberDataAccess.getAllPersonnelMembers();
	}
	
	// ===============================================================================================
	// UPDATE
	// ===============================================================================================
	public void updatePersonnelMember(PersonnelMember personnelMember) throws DataAccessConnectionException, DataAccessOperationException {
		personnelMemberDataAccess.updatePersonnelMember(personnelMember);
	}
	
	// ===============================================================================================
	// DELETE
	// ===============================================================================================
	public void removePersonnelMember(PersonnelMember personnelMember) throws DataAccessConnectionException, DataAccessOperationException {
		personnelMemberDataAccess.removePersonnelMember(personnelMember);
	}
}
