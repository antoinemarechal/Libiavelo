package business;

import java.util.ArrayList;

import dao.ClientDataAccess;
import dao.derby.ClientDerbyDataAccess;
import model.Client;

public class ClientManager {
	ClientDataAccess clientDataAccess;
	
	public ClientManager() {
		clientDataAccess = new ClientDerbyDataAccess();
	}
	
	/*************************************************************************************************
	 CREATE
	 *************************************************************************************************/
	public void addClient(Client client) {
		clientDataAccess.addClient(client);
	}
	
	/*************************************************************************************************
	 READ
	 *************************************************************************************************/
	public Client getClient(int clientID) {
		return clientDataAccess.getClient(clientID);
		
	}
	public ArrayList<Client> getAllClients() {
		return clientDataAccess.getAllClients();
		
	}
	
	/*************************************************************************************************
	 UPDATE
	 *************************************************************************************************/
	public void updateClient(Client client) {
		clientDataAccess.updateClient(client);
	}
	
	/*************************************************************************************************
	 DELETE
	 *************************************************************************************************/
	public void removeClient(int clientID) {
		clientDataAccess.removeClient(clientID);
	}
}
