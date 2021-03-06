package business;

import java.util.ArrayList;

import dao.HouseholdMemberDataAccess;
import dao.derby.HouseholdMemberDerbyDataAccess;
import exception.DataAccessConnectionException;
import exception.DataAccessOperationException;
import exception.DataLengthException;
import exception.InvalidNumberException;
import exception.NoDataException;
import model.Client;
import model.HouseholdMember;

public class HouseholdMemberManager {
	
	private HouseholdMemberDataAccess householdMemberDataAccess;
	
	public HouseholdMemberManager () {
		householdMemberDataAccess = new HouseholdMemberDerbyDataAccess();
	}
	
	// ===============================================================================================
	// CREATE
	// ===============================================================================================
	public void addHouseholdMember(HouseholdMember householdMember, Client client) throws DataAccessConnectionException, DataAccessOperationException {
		householdMemberDataAccess.addHouseholdMember(householdMember, client);
	}
	
	// ===============================================================================================
	// READ
	// ===============================================================================================
	public HouseholdMember getHouseholdMember(String nationalNumber) throws DataAccessConnectionException, DataAccessOperationException, InvalidNumberException, NoDataException, DataLengthException {
		return householdMemberDataAccess.getHouseholdMember(nationalNumber);
	}
	
	public ArrayList<HouseholdMember> getAllHouseholdMembers(int clientID) throws DataAccessConnectionException, DataAccessOperationException, InvalidNumberException, NoDataException, DataLengthException {
		return householdMemberDataAccess.getAllHouseholdMembers(clientID);
	}
	
	// ===============================================================================================
	// UPDATE
	// ===============================================================================================
	public void updateHouseholdMemebr(Client client, HouseholdMember householdMember) throws DataAccessConnectionException, DataAccessOperationException {
		householdMemberDataAccess.updateHouseholdMember(client, householdMember);
	}
	
	// ===============================================================================================
	// DELETE
	// ===============================================================================================
	public void removeHouseholdMember(HouseholdMember householdMember) throws DataAccessConnectionException, DataAccessOperationException {
		householdMemberDataAccess.removeHouseholdMember(householdMember);
	}
}
