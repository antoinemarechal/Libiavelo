package dao.derby;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import dao.ClientDataAccess;
import dao.ConnectionSingleton;
import exception.InvalidNumberException;
import exception.NoDataException;
import model.Address;
import model.Client;

public class ClientDerbyDataAccess implements ClientDataAccess {
	
	/*************************************************************************************************
	 CREATE
	 *************************************************************************************************/
	public void addClient(Client client) {
		Connection connexion = (Connection)  ( ConnectionSingleton.getInstance());
		
		try {
			PreparedStatement preparedStatement = connexion.prepareStatement("Insert into Client values (10,'TEN'),(20,'TWENTY'),(30,'THIRTY') ");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*************************************************************************************************
	 READ
	 *************************************************************************************************/
	public Client getClient(int clientID) {
		Client client = null;
		Connection connexion = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connexion.prepareStatement("select * from Client where NumeroClient is ?");
			preparedStatement.setInt(1,clientID);
			ResultSet queryResult = preparedStatement.executeQuery();

			String surname = queryResult.getString(1);
			String firstNames[] = new String[5];
			firstNames[1] = queryResult.getString(1);
			firstNames[2] = queryResult.getString(2);
			firstNames[3] = queryResult.getString(3);
			firstNames[4] = queryResult.getString(4);
			firstNames[5] = queryResult.getString(5);
			int nationalNumber = queryResult.getInt(6);
			String street = queryResult.getString(7);
			int streetNumber = queryResult.getInt(8);
			int homNumber = queryResult.getInt(9);
			int phoneNumber = queryResult.getInt(10);
			Date subscriptionDate = queryResult.getDate(11);
			boolean subscritpionValidated = queryResult.getBoolean(12);
			
			client = new Client(nationalNumber);
			client.setSurname(surname);
			client.setFirstNames(firstNames);
			// use label
			// add while pour rows dans les cas ou result set.size > 1
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoDataException e) {
			// not supposed to happen
			e.printStackTrace();
		} catch (InvalidNumberException e) {
			// not supposed to happen
			e.printStackTrace();
		}
		
		return client;
	}
	public ArrayList<Client> getAllClients() {
		return null;
	}
	
	/*************************************************************************************************
	 UPDATE
	 *************************************************************************************************/
	public void updateClient(Client client) {
	}
	
	/*************************************************************************************************
	 DELETE
	 *************************************************************************************************/
	public void removeClient(int clientID) {
	}
}
