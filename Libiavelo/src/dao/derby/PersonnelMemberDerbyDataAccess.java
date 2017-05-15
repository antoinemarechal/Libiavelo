package dao.derby;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.ConnectionSingleton;
import dao.PersonnelMemberDataAccess;
import exception.NoDataException;
import model.PersonnelMember;
import model.enumerations.WorkType;

public class PersonnelMemberDerbyDataAccess implements PersonnelMemberDataAccess {
	public PersonnelMemberDerbyDataAccess() {
	}
	/*************************************************************************************************
	 CREATE
	 *************************************************************************************************/
	public void addPersonnelMember(PersonnelMember personnelMember) {
	}
	
	/*************************************************************************************************
	 READ
	 *************************************************************************************************/
	public PersonnelMember getPersonnelMember(String matricule) {
		PreparedStatement statement;
		try {
			statement = ConnectionSingleton.getInstance().prepareStatement("SELECT * FROM Personnel WHERE Matricule = ?");
			statement.setString(1, matricule);
		
			ResultSet results = statement.executeQuery();
			
			if(results.next())
			{
				PersonnelMember member = new PersonnelMember();
				member.setID(results.getString("Matricule"));
				try {
					member.setSurname(results.getString("Nom"));
				} catch (NoDataException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				member.setFirstNames(new String[] {results.getString("Prenom1"),
						results.getString("Prenom2"),
						results.getString("Prenom3"),
						results.getString("Prenom4"),
						results.getString("Prenom5")});	
				member.setFunction(WorkType.getFromId(results.getInt("CodeFonction")));
				
				return member;
			}
			else
			{
				//TODO not found exception ?
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public ArrayList<PersonnelMember> getAllPersonnelMembers() {
		return null;
	}
	
	/*************************************************************************************************
	 UPDATE
	 *************************************************************************************************/
	public void updatePersonnelMember(PersonnelMember clipersonnelMemberent) {
	}
	
	/*************************************************************************************************
	 DELETE
	 *************************************************************************************************/
	public void removePersonnelMember() {
	}
}
