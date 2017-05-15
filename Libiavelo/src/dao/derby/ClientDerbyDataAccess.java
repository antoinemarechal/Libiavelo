package dao.derby;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dao.ClientDataAccess;
import dao.ConnectionSingleton;
import exception.DataAccessConnectionException;
import exception.DataAccessOperationException;
import exception.DataLengthException;
import exception.InvalidNumberException;
import exception.NoDataException;
import model.Client;
import model.Locality;

public class ClientDerbyDataAccess implements ClientDataAccess {
	
	// ===============================================================================================
	// CREATE
	// ===============================================================================================
	@Override
	public void addClient(Client client) throws DataAccessConnectionException, DataAccessOperationException {
		Connection connection = (Connection)  (ConnectionSingleton.getInstance());
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Client VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
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
			
			preparedStatement.setDate(12, new Date(client.getSubscriptionDate().getTime()));
			preparedStatement.setBoolean(13, client.isSubsriptionValidated());
			preparedStatement.setFloat(14, client.getDepositAmount());

			preparedStatement.setInt(15, client.getLocality().getId());
			
			preparedStatement.executeUpdate();
			
			ResultSet queryResults = preparedStatement.getGeneratedKeys();
			queryResults.next();
			
			client.setClientNumber(queryResults.getInt("1"));
			
		} catch (SQLException e) {
			throw new DataAccessOperationException(getClass().getName() + ".addClient(Client)", e.getMessage());
		}
	}
	
	// ===============================================================================================
	// READ
	// ===============================================================================================
	@Override
	public Client getClient(int clientID) throws DataAccessConnectionException, DataAccessOperationException, InvalidNumberException, NoDataException, DataLengthException {
		Connection connection = ConnectionSingleton.getInstance();
		
		Client client = null;
		
		LocalityDerbyDataAccess localityDerbyDataAccess = new LocalityDerbyDataAccess();
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Client WHERE NumeroClient = ?");
			preparedStatement.setInt(1, clientID);
			
			ResultSet queryResult = preparedStatement.executeQuery();

			if(queryResult.next()) {
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

				Float depositAmount = queryResult.getFloat("MontantCaution ");

				Locality locality = localityDerbyDataAccess.getLocality(queryResult.getInt("CodeLocalite"));
				
				client = new Client(nationalNumber, homeNumber, phoneNumber, clientSurname, clientFirstNames, subscriptionValidated, depositAmount, streetNumber, streetName, locality, subscriptionDate);
			}
		} 
		catch (SQLException e) {
			throw new DataAccessOperationException(getClass().getName() + ".getClient(int)", e.getMessage());
		} 
		
		return client;
	}
	
	@Override
	public ArrayList<Client> getAllClients() throws DataAccessConnectionException, DataAccessOperationException, InvalidNumberException, NoDataException, DataLengthException {
		Connection connexion = ConnectionSingleton.getInstance();
		
		ArrayList<Client> clients = new ArrayList<Client>();
		Client client = null;
		
		LocalityDerbyDataAccess localityDerbyDataAccess = new LocalityDerbyDataAccess();
		
		try {
			PreparedStatement preparedStatement = connexion.prepareStatement("SELECT * FROM Client");
			ResultSet queryResult = preparedStatement.executeQuery();
			
			while(queryResult.next()) {
				String clientSurname = queryResult.getString("NomDemandeur");
				String clientFirstNames[] = new String[5];
				clientFirstNames[0] = queryResult.getString("Prenom1");
				clientFirstNames[1] = queryResult.getString("Prenom2");
				clientFirstNames[2] = queryResult.getString("Prenom3");
				clientFirstNames[3] = queryResult.getString("Prenom4");
				clientFirstNames[4] = queryResult.getString("Prenom5");
				String nationalNumber = queryResult.getString("NumeroNational");
				String streetName = queryResult.getString("NomRue");
				String streetNumber = queryResult.getString("Numero");
				String homeNumber = queryResult.getString("NumeroTel");
				String phoneNumber = queryResult.getString("Gsm");
				Date subscriptionDate = queryResult.getDate("DateInscription");
				Boolean subscriptionValidated = queryResult.getBoolean("InscriptionValidee");

				Float depositAmount = queryResult.getFloat("MontantCaution");
				Locality locality = localityDerbyDataAccess.getLocality(queryResult.getInt("CodeLocalite"));
				
				client = new Client(nationalNumber, homeNumber, phoneNumber, clientSurname, clientFirstNames, subscriptionValidated, depositAmount, streetNumber, streetName, locality, subscriptionDate);
				
				clients.add(client);
			}
		} catch (SQLException e) {
			throw new DataAccessOperationException(getClass().getName() + ".getAllClients()", e.getMessage());
		}
		
		return clients;
	}
	
	// ===============================================================================================
	// UPDATE
	// ===============================================================================================
	@Override
	public void updateClient(Client client) throws DataAccessConnectionException, DataAccessOperationException {
		// FIXME :
	}
	
	// ===============================================================================================
	// DELETE
	// ===============================================================================================
	@Override
	public void removeClient(Client client) throws DataAccessConnectionException, DataAccessOperationException {
		// FIXME :
	}
}
