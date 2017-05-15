package dao;

import java.util.ArrayList;

import exception.DataAccessConnectionException;
import exception.DataAccessOperationException;
import exception.DataLengthException;
import exception.InvalidNumberException;
import exception.NoDataException;
import model.Client;

public interface ClientDataAccess {
	
	// ===============================================================================================
	// CREATE
	// ===============================================================================================
	public void addClient(Client client) throws DataAccessConnectionException, DataAccessOperationException;
	
	// ===============================================================================================
	// READ
	// ===============================================================================================
	public Client getClient(int clientID) throws DataAccessConnectionException, DataAccessOperationException, InvalidNumberException, NoDataException, DataLengthException;
	public ArrayList<Client> getAllClients() throws DataAccessConnectionException, DataAccessOperationException, InvalidNumberException, NoDataException, DataLengthException;
	
	// ===============================================================================================
	// UPDATE
	// ===============================================================================================
	public void updateClient(Client client) throws DataAccessConnectionException, DataAccessOperationException;
	
	// ===============================================================================================
	// DELETE
	// ===============================================================================================
	public void removeClient(Client client) throws DataAccessConnectionException, DataAccessOperationException;
}
