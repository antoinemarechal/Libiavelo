package business;

import java.util.ArrayList;

import dao.derby.AddressDerbyDataAccess;
import model.Address;
import model.Client;
import model.Estate;

public class AddressManager {
	AddressDerbyDataAccess addressDataAccess;
	
	public AddressManager() {
		addressDataAccess = new AddressDerbyDataAccess();
	}
	
	/*************************************************************************************************
	 CREATE
	 *************************************************************************************************/
	public void addAddress(Address address) {
		addressDataAccess.addAddress(address);
	}
	public void addEstateAddress(Estate estate, Address address) {
		addressDataAccess.addEstateAddress(estate, address);
	}
	public void addClientAddress(Client client, Address address) {
		addressDataAccess.addClientAddress(client, address);
	}
	
	/*************************************************************************************************
	 READ
	 *************************************************************************************************/
	public ArrayList<Address> getAllAddresses() {
		return addressDataAccess.getAllAddresses();
	}
	
	public Address getClientAddress(Client client) {
		return addressDataAccess.getClientAddress(client);
	}
	
	public Address getEstateAddress(Estate estate) {
		return addressDataAccess.getEstateAddress(estate);
	}
	
	/*************************************************************************************************
	 UPDATE
	 *************************************************************************************************/
	public void updateClientAddress(Client client, Address address) {
		addressDataAccess.updateClientAddress(client, address);
	}
	
	public void updateEstateAddress(Estate estate, Address address) {
		addressDataAccess.updateEstateAddress(estate, address);
	}
	
	/*************************************************************************************************
	 DELETE
	 *************************************************************************************************/
	public void removeAddress(Client client, Address address) {
		addressDataAccess.removeAddress(client, address);
	}
}
