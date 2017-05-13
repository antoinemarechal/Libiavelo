package dao.derby;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.ConnectionSingleton;
import dao.LocalityDataAccess;
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
			PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Localite  VALUES (?,?) ");
			preparedStatement.setInt(1, locality.getPostalCode());
			preparedStatement.setString(2, locality.getCityName());
			preparedStatement.executeUpdate();
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
		return null;
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
