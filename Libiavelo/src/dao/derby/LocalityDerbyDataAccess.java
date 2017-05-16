package dao.derby;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dao.ConnectionSingleton;
import dao.LocalityDataAccess;
import exception.DataAccessConnectionException;
import exception.DataAccessOperationException;
import exception.InvalidNumberException;
import exception.NoDataException;
import model.Locality;

public class LocalityDerbyDataAccess implements LocalityDataAccess {
		
	// ===============================================================================================
	// CREATE
	// ===============================================================================================
	@Override
	public void addLocality(Locality locality) throws DataAccessConnectionException, DataAccessOperationException {
		Connection connection = ConnectionSingleton.getInstance();
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Localite(CodePostal, Libelle) VALUES (?,?) ", Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setInt(1, locality.getPostalCode());
			preparedStatement.setString(2, locality.getCityName());
			preparedStatement.executeUpdate();
						
			ResultSet queryResults = preparedStatement.getGeneratedKeys();
			queryResults.next();

			locality.setId(queryResults.getInt(1));	
		} 
		catch (SQLException e) {
			throw new DataAccessOperationException(getClass().getName() + ".addLocality(Locality)", e.getMessage());
		}
	}
	
	// ===============================================================================================
	// READ
	// ===============================================================================================
	@Override
	public Locality getLocality(int localityID) throws DataAccessConnectionException, DataAccessOperationException, NoDataException, InvalidNumberException {
		Connection connexion = ConnectionSingleton.getInstance();
		
		Locality locality = null;
		
		try {
			PreparedStatement preparedStatement = connexion.prepareStatement("SELECT * FROM Localite WHERE Code = ?");
			preparedStatement.setInt(1, localityID);
			
			ResultSet queryResult = preparedStatement.executeQuery();
			
			if(queryResult.next())			
				locality = new Locality(queryResult.getInt("Code"), queryResult.getString("Libelle"), queryResult.getInt("CodePostal"));
		} 
		catch (SQLException e) {
			throw new DataAccessOperationException(getClass().getName() + ".getLocality(int)", e.getMessage());
		}
		
		return locality;
	}
	
	@Override
	public ArrayList<Locality> getAllLocalities() throws DataAccessConnectionException, DataAccessOperationException, NoDataException, InvalidNumberException {
		Connection connexion = ConnectionSingleton.getInstance();
		
		ArrayList<Locality> localities = new ArrayList<Locality>();
		Locality locality = null;
		
		try {
			PreparedStatement preparedStatement = connexion.prepareStatement("SELECT * FROM Localite");
			ResultSet queryResult = preparedStatement.executeQuery();
			
			while(queryResult.next()) {
				locality = new Locality(queryResult.getInt("Code"), queryResult.getString("Libelle"), queryResult.getInt("CodePostal"));

				localities.add(locality);
			}
		} 
		catch (SQLException e) {
			throw new DataAccessOperationException(getClass().getName() + ".getAllLocalities()", e.getMessage());
		}
		
		return localities;
	}
	
	// ===============================================================================================
	// UPDATE
	// ===============================================================================================
	@Override
	public void updateLocality(Locality locality) throws DataAccessConnectionException, DataAccessOperationException {
		
	}

	// ===============================================================================================
	// DELETE
	// ===============================================================================================
	@Override
	public void removeLocality(Locality locality) throws DataAccessConnectionException, DataAccessOperationException {
		
	}
}
