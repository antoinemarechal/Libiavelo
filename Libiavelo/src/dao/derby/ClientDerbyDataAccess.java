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
import model.Client;

public class ClientDerbyDataAccess implements ClientDataAccess {
	
	/*************************************************************************************************
	 CREATE
	 *************************************************************************************************/
	public void addClient(Client client) {
		Connection connexion = (Connection)  (ConnectionSingleton.getInstance());
		
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

			while(queryResult.next()) {
				String clientSurname = queryResult.getString("NomDemandeur");
				String clientFirstNames[] = new String[5];
				clientFirstNames[1] = queryResult.getString("Prenom1");
				clientFirstNames[2] = queryResult.getString("Prenom2");
				clientFirstNames[3] = queryResult.getString("Prenom3");
				clientFirstNames[4] = queryResult.getString("Prenom4");
				clientFirstNames[5] = queryResult.getString("Prenom5");
				Integer nationalNumber = queryResult.getInt("NumeroNational");
				String streetName = queryResult.getString("NomRue");
				String streetNumber = queryResult.getString("Numero");
				String homeNumber = queryResult.getString("NumeroTel");
				String phoneNumber = queryResult.getString("Gsm ");
				Date subscriptionDate = queryResult.getDate("DateInscription");
				Boolean subscriptionValidated = queryResult.getBoolean("InscriptionValidee");
				Double depositAmount = queryResult.getDouble("MontantCaution ");
				
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
