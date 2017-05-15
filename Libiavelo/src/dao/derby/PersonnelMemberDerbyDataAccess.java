package dao.derby;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.ConnectionSingleton;
import dao.PersonnelMemberDataAccess;
import exception.DataAccessConnectionException;
import exception.DataAccessOperationException;
import exception.DataLengthException;
import exception.NoDataException;
import model.PersonnelMember;
import model.enumerations.WorkType;

public class PersonnelMemberDerbyDataAccess implements PersonnelMemberDataAccess {
	
	// ===============================================================================================
	// CREATE
	// ===============================================================================================
	@Override
	public void addPersonnelMember(PersonnelMember personnelMember) throws DataAccessConnectionException, DataAccessOperationException {
		
	}
	
	// ===============================================================================================
	// READ
	// ===============================================================================================
	@Override
	public PersonnelMember getPersonnelMember(String matricule) throws DataAccessConnectionException, DataAccessOperationException, NoDataException, DataLengthException {
		Connection connection = ConnectionSingleton.getInstance();
		
		PersonnelMember personnelMember = null;
		
		try {
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM Personnel WHERE Matricule = ?");
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
				
				personnelMember = new PersonnelMember(matricule, surname, firstNames, function);
			}	
		} 
		catch (SQLException e) {
			throw new DataAccessOperationException(getClass().getName() + ".getPersonnelMember(String)", e.getMessage());
		}
		
		return personnelMember;
	}
	
	@Override
	public PersonnelMember getPersonnelMember(String matricule, String password) throws DataAccessConnectionException, DataAccessOperationException, NoDataException, DataLengthException {
		Connection connection = ConnectionSingleton.getInstance();
		
		PersonnelMember personnelMember = null;
		
		try {
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM Personnel WHERE Matricule = ? AND MotDePasse = UPPER(?)");
			statement.setString(1, matricule);
			statement.setString(2, password);
			
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
				
				personnelMember = new PersonnelMember(matricule, surname, firstNames, function);
			}	
		} 
		catch (SQLException e) {
			throw new DataAccessOperationException(getClass().getName() + ".getPersonnelMember(String, String)", e.getMessage());
		}
		
		return personnelMember;
	}
	
	@Override
	public ArrayList<PersonnelMember> getAllPersonnelMembers() throws DataAccessConnectionException, DataAccessOperationException, NoDataException, DataLengthException {
		Connection connection = ConnectionSingleton.getInstance();
		
		ArrayList<PersonnelMember> members = new ArrayList<PersonnelMember>();
		
		PreparedStatement statement;
		try {
			statement = connection.prepareStatement("SELECT * FROM Personnel");
					
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
		} 
		catch (SQLException e) {
			throw new DataAccessOperationException(getClass().getName() + ".getAllPersonnelMembers()", e.getMessage());
		}
		
		return members;
	}
	
	// ===============================================================================================
	// UPDATE
	// ===============================================================================================
	@Override
	public void updatePersonnelMember(PersonnelMember clipersonnelMemberent) throws DataAccessConnectionException, DataAccessOperationException {
		
	}
	
	// ===============================================================================================
	// DELETE
	// ===============================================================================================
	@Override
	public void removePersonnelMember(PersonnelMember personnelMember) throws DataAccessConnectionException, DataAccessOperationException {
		
	}
}
