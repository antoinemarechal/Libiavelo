package dao.derby;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.ClientDataAccess;
import dao.ConnectionSingleton;
import exception.InvalidNumberException;
import exception.NoDataException;
import model.Client;

public class ClientDerbyDataAccess implements ClientDataAccess {
	
	/*************************************************************************************************
	 CREATE
	 *************************************************************************************************/
	public void addClient(Client client) {
		Connection connection = (Connection)  (ConnectionSingleton.getInstance());
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Client VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ");
			preparedStatement.setString(1, client.getSurname());
			
			String[] firstNames = client.getFirstNames();
			preparedStatement.setString(2, firstNames[0]);
			if (firstNames[1] != "")
				preparedStatement.setString(3, firstNames[1]);
			if (firstNames[2] != "")
				preparedStatement.setString(4, firstNames[2]);
			if (firstNames[3] != "")
				preparedStatement.setString(5, firstNames[3]);
			if (firstNames[4] != "")
				preparedStatement.setString(6, firstNames[4]);		
			
			preparedStatement.setString(7, client.getNationalNumber());
			preparedStatement.setString(8, client.getStreetName());
			preparedStatement.setString(9, client.getStreetNumber());
			
			if (client.getHomeNumber() != null)
				preparedStatement.setString(10, client.getHomeNumber());
			if (client.getPhoneNumber() != null)
				preparedStatement.setString(11, client.getPhoneNumber());
			
			preparedStatement.setDate(12, new Date(client.getSubscriptionDate().getTime())); // java.sql.date créé via le long récupéré de la java.util.Date subscription
			preparedStatement.setBoolean(13, client.isSubsriptionValidated());
			preparedStatement.setInt(14, client.getDepositAmount());
			preparedStatement.setInt(15, client.getLocality());
			
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/*************************************************************************************************
	 READ
	 *************************************************************************************************/
	public Client getClient(int clientID) {
		Client client = null;
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Client WHERE NumeroClient IS ?");
			preparedStatement.setInt(1,clientID);
			ResultSet queryResult = preparedStatement.executeQuery();

			while(queryResult.next()) {
				String clientSurname = queryResult.getString("NomDemandeur");
				String clientFirstNames[] = new String[5];
				clientFirstNames[1] = queryResult.getString("Prenom1");
				clientFirstNames[2] = queryResult.getString("Prenom2");
				clientFirstNames[3] = queryResult.getString("Prenom3");
				clientFirstNames[4] = queryResult.getString("Prenom4");
				clientFirstNames[5] = queryResult.getString("Prenom5");
				String nationalNumber = queryResult.getString("NumeroNational");
				String streetName = queryResult.getString("NomRue");
				String streetNumber = queryResult.getString("Numero");
				String homeNumber = queryResult.getString("NumeroTel");
				String phoneNumber = queryResult.getString("Gsm ");
				Date subscriptionDate = queryResult.getDate("DateInscription");
				Boolean subscriptionValidated = queryResult.getBoolean("InscriptionValidee");
				Integer depositAmount = queryResult.getInt("MontantCaution ");
				
				client = new Client(nationalNumber, homeNumber, phoneNumber, clientSurname, clientFirstNames, subscriptionValidated, depositAmount, streetNumber, streetName, subscriptionDate);
			}
								
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
		ArrayList<Client> clients = new ArrayList<Client>();
		Client client = null;
		Connection connexion = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connexion.prepareStatement("SELECT * FROM Client");
			ResultSet queryResult = preparedStatement.executeQuery();
			while(queryResult.next()) {
				String clientSurname = queryResult.getString("NomDemandeur");
				String clientFirstNames[] = new String[5];
				clientFirstNames[1] = queryResult.getString("Prenom1");
				clientFirstNames[2] = queryResult.getString("Prenom2");
				clientFirstNames[3] = queryResult.getString("Prenom3");
				clientFirstNames[4] = queryResult.getString("Prenom4");
				clientFirstNames[5] = queryResult.getString("Prenom5");
				String nationalNumber = queryResult.getString("NumeroNational");
				String streetName = queryResult.getString("NomRue");
				String streetNumber = queryResult.getString("Numero");
				String homeNumber = queryResult.getString("NumeroTel");
				String phoneNumber = queryResult.getString("Gsm ");
				Date subscriptionDate = queryResult.getDate("DateInscription");
				Boolean subscriptionValidated = queryResult.getBoolean("InscriptionValidee");
				Integer depositAmount = queryResult.getInt("MontantCaution ");
				
				client = new Client(nationalNumber, homeNumber, phoneNumber, clientSurname, clientFirstNames, subscriptionValidated, depositAmount, streetNumber, streetName, subscriptionDate);
				clients.add(client);
			}
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
		
		return clients;
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
