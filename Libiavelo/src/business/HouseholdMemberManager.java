package business;

import java.util.ArrayList;

import dao.HouseholdMemberDataAccess;
import dao.derby.HouseholdMemberDerbyDataAccess;
import model.Client;
import model.HouseholdMember;

public class HouseholdMemberManager {
	HouseholdMemberDataAccess householdMemberDataAccess;
	
	public HouseholdMemberManager () {
		householdMemberDataAccess = new HouseholdMemberDerbyDataAccess();
	}
	
	/*************************************************************************************************
	 CREATE
	 *************************************************************************************************/
	public void addHouseholdMember(HouseholdMember householdMember, Client client) {
		householdMemberDataAccess.addHouseholdMember(householdMember, client);
	}
	
	/*************************************************************************************************
	 READ
	 *************************************************************************************************/
	public HouseholdMember getHouseholdMember(int clientID) {
		return householdMemberDataAccess.getHouseholdMember(clientID);
	}
	
	public ArrayList<HouseholdMember> getAllHouseholdMembers() {
		return householdMemberDataAccess.getAllHouseholdMembers();
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
