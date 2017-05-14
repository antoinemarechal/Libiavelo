package dao.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.PersonnelMember;
import model.enumerations.WorkType;
import dao.ConnectionSingleton;
import dao.PersonnelMemberDataAccess;
import exception.NoDataException;

public class PersonnelMemberMySQLDataAccess implements PersonnelMemberDataAccess 
{
	public PersonnelMemberMySQLDataAccess() {
	}

	@Override
	public void addPersonnelMember(PersonnelMember personnelMember) {
		// TODO Auto-generated method stub
		
	}

	@Override
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

	@Override
	public ArrayList<PersonnelMember> getAllPersonnelMembers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updatePersonnelMember(PersonnelMember clipersonnelMemberent) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removePersonnelMember() {
		// TODO Auto-generated method stub
		
	}
}
