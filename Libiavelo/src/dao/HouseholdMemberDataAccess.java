package dao;

import java.util.ArrayList;

import model.HouseholdMember;

public interface HouseholdMemberDataAccess {
	/*************************************************************************************************
	 CREATE
	 *************************************************************************************************/
	public void addHouseholdMember(HouseholdMember householdMember, int clientID);
	
	/*************************************************************************************************
	 READ
	 *************************************************************************************************/
	public HouseholdMember getHouseholdMember(int clientID);
	public ArrayList<HouseholdMember> getAllHouseholdMembers();
	
	/*************************************************************************************************
	 UPDATE
	 *************************************************************************************************/
	public void updateHouseholdMemebr(HouseholdMember householdMember);
	
	/*************************************************************************************************
	 DELETE
	 *************************************************************************************************/
	public void removeHouseholdMember(HouseholdMember householdMember);
}
