package dao.derby;

import java.util.ArrayList;

import model.Address;
import model.Client;
import model.Estate;

public class AddressDerbyDataAccess {
	public AddressDerbyDataAccess() {
		// TODO
	}
	
	/*************************************************************************************************
	 CREATE
	 *************************************************************************************************/
	public void addAddress(Address address) {
	}
	public void addEstateAddress(Estate estate, Address address) {
	}
	public void addClientAddress(Client client, Address address) {
	}
	
	/*************************************************************************************************
	 READ
	 *************************************************************************************************/
	public ArrayList<Address> getAllAddresses() {
		return null;
	}
	public Address getClientAddress(Client client) {
		return null;
	}
	public Address getEstateAddress(Estate estate) {
		return null;
	}
	
	/*************************************************************************************************
	 UPDATE
	 *************************************************************************************************/
	public void updateClientAddress(Client client, Address address) {
	}
	public void updateEstateAddress(Estate estate, Address address) {
	}
	
	/*************************************************************************************************
	 DELETE
	 *************************************************************************************************/
	public void removeAddress(Client client, Address address) {
	}
}