package dao.derby;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.ConnectionSingleton;
import dao.PersonnelMemberDataAccess;
import exception.DataLengthException;
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
				String surname = results.getString("Nom");
				String[] firstNames = new String[] {
						results.getString("Prenom1"),
						results.getString("Prenom2"),
						results.getString("Prenom3"),
						results.getString("Prenom4"),
						results.getString("Prenom5")
					};	
				WorkType function = WorkType.getFromId(results.getInt("CodeFonction"));
				
				return new PersonnelMember(matricule, surname, firstNames, function);
			}
			else
			{
				//TODO not found exception ?
			}
			
		} catch (SQLException | NoDataException | DataLengthException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public ArrayList<PersonnelMember> getAllPersonnelMembers() {
		ArrayList<PersonnelMember> members = new ArrayList<PersonnelMember>();
		
		PreparedStatement statement;
		try {
			statement = ConnectionSingleton.getInstance().prepareStatement("SELECT * FROM Personnel");
					
			ResultSet results = statement.executeQuery();
			
			while(results.next())
			{
				String matricule = results.getString("Matricule");
				String surname = results.getString("Nom");
				String[] firstNames = new String[] {
						results.getString("Prenom1"),
						results.getString("Prenom2"),
						results.getString("Prenom3"),
						results.getString("Prenom4"),
						results.getString("Prenom5")
					};	
				WorkType function = WorkType.getFromId(results.getInt("CodeFonction"));
				
				members.add(new PersonnelMember(matricule, surname, firstNames, function));
			}
				
			return members;
			
		} catch (SQLException | NoDataException | DataLengthException e) 
		{
			e.printStackTrace();
		}
		
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
