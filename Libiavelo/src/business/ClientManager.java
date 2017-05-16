package business;

import java.util.ArrayList;

import dao.ClientDataAccess;
import dao.derby.ClientDerbyDataAccess;
import exception.DataAccessConnectionException;
import exception.DataAccessOperationException;
import exception.DataLengthException;
import exception.InvalidNumberException;
import exception.NoDataException;
import model.Client;

public class ClientManager {
	
	private ClientDataAccess clientDataAccess;
	
	public ClientManager() {
		clientDataAccess = new ClientDerbyDataAccess();
	}
	
	// ===============================================================================================
	// CREATE
	// ===============================================================================================
	public void addClient(Client client) throws DataAccessConnectionException, DataAccessOperationException {
		clientDataAccess.addClient(client);
	}
	
	// ===============================================================================================
	// READ
	// ===============================================================================================
	public Client getClient(int clientID) throws DataAccessConnectionException, DataAccessOperationException, InvalidNumberException, NoDataException, DataLengthException {
		return clientDataAccess.getClient(clientID);	
	}
	
	public ArrayList<Client> getAllClients() throws DataAccessConnectionException, DataAccessOperationException, InvalidNumberException, NoDataException, DataLengthException {
		return clientDataAccess.getAllClients();
	}
	
	// ===============================================================================================
	// UPDATE
	// ===============================================================================================
	public void updateClient(Client client) throws DataAccessConnectionException, DataAccessOperationException {
		clientDataAccess.updateClient(client);
	}
	
	// ===============================================================================================
	// DELETE
	// ===============================================================================================
	public void removeClient(Client client) throws DataAccessConnectionException, DataAccessOperationException {
		clientDataAccess.removeClient(client);
	}
}
