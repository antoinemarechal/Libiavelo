package business;

import dao.ClientDBDataAccess;
import model.Client;

public class ClientManager {
	public ClientManager() {
		//TODO
	}
	
	public void addClient(Client client) {
		ClientDBDataAccess clientDBDataAccess = new ClientDBDataAccess();
		clientDBDataAccess.addClient(client);
	}
}
