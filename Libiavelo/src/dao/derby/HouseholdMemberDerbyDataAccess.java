package dao.derby;

import java.util.ArrayList;

import dao.HouseholdMemberDataAccess;
import model.Client;
import model.HouseholdMember;

public class HouseholdMemberDerbyDataAccess implements HouseholdMemberDataAccess {
	public HouseholdMemberDerbyDataAccess() {
	}
	/*************************************************************************************************
	 CREATE
	 *************************************************************************************************/
	public void addHouseholdMember(HouseholdMember householdMember, Client client) {
	}
	
	/*************************************************************************************************
	 READ
	 *************************************************************************************************/
	public HouseholdMember getHouseholdMember(int clientID) {
		return null;
	}
	public ArrayList<HouseholdMember> getAllHouseholdMembers() {
		return null;
	}
	
	/*************************************************************************************************
	 UPDATE
	 *************************************************************************************************/
	public void updateHouseholdMemebr(HouseholdMember householdMember) {
	}
	
	/*************************************************************************************************
	 DELETE
	 *************************************************************************************************/
	public void removeHouseholdMember(HouseholdMember householdMember) {
	}
}
