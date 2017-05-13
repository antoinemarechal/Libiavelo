package dao.derby;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dao.ConnectionSingleton;
import dao.LocalityDataAccess;
import exception.InvalidNumberException;
import exception.NoDataException;
import model.Client;
import model.Estate;
import model.Locality;

public class LocalityDerbyDataAccess implements LocalityDataAccess {
	public LocalityDerbyDataAccess() {
	}
	
	/*************************************************************************************************
	 CREATE
	 *************************************************************************************************/
	public void addLocality(Locality locality) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Localite(CodePostal, Libelle)  VALUES (?,?) ", Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setInt(1, locality.getPostalCode());
			preparedStatement.setString(2, locality.getCityName());
			preparedStatement.executeUpdate();
						
			ResultSet queryResults = preparedStatement.getGeneratedKeys();
			queryResults.next();
			locality.setId(queryResults.getInt("Code"));	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void addEstateLocality(Estate estate, Locality locality) {
	}
	
	public void addClientLocality(Client client, Locality locality) {
	}
	
	/*************************************************************************************************
	 READ
	 *************************************************************************************************/
	public ArrayList<Locality> getAllLocalities() {
		ArrayList<Locality> localities = new ArrayList<Locality>();
		Locality locality;
		Connection connexion = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connexion.prepareStatement("SELECT * FROM Localite");
			ResultSet queryResult = preparedStatement.executeQuery();
			while(queryResult.next()) {
				locality = new Locality(queryResult.getString("CodePostal "), queryResult.getInt("Libelle"));
				localities.add(locality);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoDataException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidNumberException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return localities;
	}
	
	public Locality getClientLocality(Client client) {
		return null;
	}
	
	public Locality getEstateLocality(Estate estate) {
		return null;
	}
	
	/*************************************************************************************************
	 UPDATE
	 *************************************************************************************************/
	public void updateClientLocality(Client client, Locality locality) {
	}
	
	public void updateEstateLocality(Estate estate, Locality locality) {
	}
	
	/*************************************************************************************************
	 DELETE
	 *************************************************************************************************/
	public void removeLocality(Client client, Locality locality) {
	}
}
