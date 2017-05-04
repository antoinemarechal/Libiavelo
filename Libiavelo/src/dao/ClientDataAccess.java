package dao;

import java.util.ArrayList;

import model.Client;

public interface ClientDataAccess {
	/*************************************************************************************************
	 CREATE
	 *************************************************************************************************/
	public void addClient(Client client);
	
	/*************************************************************************************************
	 READ
	 *************************************************************************************************/
	public Client getClient(int clientID);
	public ArrayList<Client> getAllClients();
	
	/*************************************************************************************************
	 UPDATE
	 *************************************************************************************************/
	public void updateClient(Client client);
	
	/*************************************************************************************************
	 DELETE
	 *************************************************************************************************/
	public void removeClient(int clientID);
}
