package dao;

import java.util.ArrayList;

import exception.DataAccessConnectionException;
import exception.DataAccessOperationException;
import exception.DataLengthException;
import exception.InvalidNumberException;
import exception.NoDataException;
import model.HouseholdMember;

public interface HouseholdMemberDataAccess {
	
	// ===============================================================================================
	// CREATE
	// ===============================================================================================
	public void addHouseholdMember(HouseholdMember householdMember, int clientID) throws DataAccessConnectionException, DataAccessOperationException;
	
	// ===============================================================================================
	// READ
	// ===============================================================================================
	public HouseholdMember getHouseholdMember(String nationalNumber) throws DataAccessConnectionException, DataAccessOperationException, InvalidNumberException, NoDataException, DataLengthException;
	public ArrayList<HouseholdMember> getAllHouseholdMembers(int clientID) throws DataAccessConnectionException, DataAccessOperationException, InvalidNumberException, NoDataException, DataLengthException;
	
	// ===============================================================================================
	// UPDATE
	// ===============================================================================================
	public void updateHouseholdMemebr(HouseholdMember householdMember) throws DataAccessConnectionException, DataAccessOperationException;
	
	// ===============================================================================================
	// DELETE
	// ===============================================================================================
	public void removeHouseholdMember(HouseholdMember householdMember) throws DataAccessConnectionException, DataAccessOperationException;
}
