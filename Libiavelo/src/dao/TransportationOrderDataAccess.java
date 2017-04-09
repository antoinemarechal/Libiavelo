package dao;

import java.util.ArrayList;

import model.TransportationOrder;

public interface TransportationOrderDataAccess {
	/*************************************************************************************************
	 CREATE
	 *************************************************************************************************/
	public void addTransportationOrder(TransportationOrder transportationOrder);
	
	/*************************************************************************************************
	 READ
	 *************************************************************************************************/
	public TransportationOrder getClient(int clientID);
	public ArrayList<TransportationOrder> getAllTransportationOrders();
	
	/*************************************************************************************************
	 UPDATE
	 *************************************************************************************************/
	public void updateClient(TransportationOrder transportationOrder);
	
	/*************************************************************************************************
	 DELETE
	 *************************************************************************************************/
	public void removeTransportationOrder();
}
