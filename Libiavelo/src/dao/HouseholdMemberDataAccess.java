package dao;

import java.util.ArrayList;

import exception.DataAccessConnectionException;
import exception.DataAccessOperationException;
import exception.DataLengthException;
import exception.InvalidNumberException;
import exception.NoDataException;
import model.Client;
import model.HouseholdMember;

public interface HouseholdMemberDataAccess {
	
	// ===============================================================================================
	// CREATE
	// ===============================================================================================
	public void addHouseholdMember(HouseholdMember householdMember, Client client) throws DataAccessConnectionException, DataAccessOperationException;
	
	// ===============================================================================================
	// READ
	// ===============================================================================================
	public HouseholdMember getHouseholdMember(String nationalNumber) throws DataAccessConnectionException, DataAccessOperationException, InvalidNumberException, NoDataException, DataLengthException;
	public ArrayList<HouseholdMember> getAllHouseholdMembers(int clientID) throws DataAccessConnectionException, DataAccessOperationException, InvalidNumberException, NoDataException, DataLengthException;
	
	// ===============================================================================================
	// UPDATE
	// ===============================================================================================
	public void updateHouseholdMember(Client client, HouseholdMember householdMember) throws DataAccessConnectionException, DataAccessOperationException;
	public void updateHousehold(Client client) throws DataAccessConnectionException, DataAccessOperationException;
	// ===============================================================================================
	// DELETE
	// ===============================================================================================
	public void removeHouseholdMember(HouseholdMember householdMember) throws DataAccessConnectionException, DataAccessOperationException;
}
