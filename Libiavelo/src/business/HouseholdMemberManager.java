package business;

import java.util.ArrayList;

import dao.HouseholdMemberDataAccess;
import dao.derby.HouseholdMemberDerbyDataAccess;
import model.HouseholdMember;

public class HouseholdMemberManager {
	HouseholdMemberDataAccess householdMemberDataAccess;
	
	public HouseholdMemberManager () {
		householdMemberDataAccess = new HouseholdMemberDerbyDataAccess();
	}
	
	/*************************************************************************************************
	 CREATE
	 *************************************************************************************************/
	public void addHouseholdMember(HouseholdMember householdMember, Integer clientID) {
		householdMemberDataAccess.addHouseholdMember(householdMember, clientID);
	}
	
	/*************************************************************************************************
	 READ
	 *************************************************************************************************/
	public HouseholdMember getHouseholdMember(String nationalNumber) {
		return householdMemberDataAccess.getHouseholdMember(nationalNumber);
	}
	
	public ArrayList<HouseholdMember> getAllHouseholdMembers(int clientID) {
		return householdMemberDataAccess.getAllHouseholdMembers(clientID);
	}
	
	/*************************************************************************************************
	 UPDATE
	 *************************************************************************************************/
	public void updateHouseholdMemebr(HouseholdMember householdMember) {
		householdMemberDataAccess.updateHouseholdMemebr(householdMember);
	}
	
	/*************************************************************************************************
	 DELETE
	 *************************************************************************************************/
	public void removeHouseholdMember(HouseholdMember householdMember) {
		householdMemberDataAccess.removeHouseholdMember(householdMember);
	}
}
