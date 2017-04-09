package dao;

import java.util.ArrayList;

import model.Address;
import model.Client;
import model.Estate;

public interface AddressDataAccess {
	/*************************************************************************************************
	 CREATE
	 *************************************************************************************************/
	public void addAddress(Address address);
	public void addEstateAddress(Estate estate, Address address);
	public void addClientAddress(Client client, Address address);
	
	/*************************************************************************************************
	 READ
	 *************************************************************************************************/
	public ArrayList<Address> getAllAddresses();
	public Address getClientAddress(Client client);
	public Address getEstateAddress(Estate estate);
	
	/*************************************************************************************************
	 UPDATE
	 *************************************************************************************************/
	public void updateClientAddress(Client client, Address address);
	public void updateEstateAddress(Estate estate, Address address);
	
	/*************************************************************************************************
	 DELETE
	 *************************************************************************************************/
	public void removeAddress(Client client, Address address);
}
