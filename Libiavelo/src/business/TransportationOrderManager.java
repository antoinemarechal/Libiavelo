package business;

import java.util.ArrayList;

import dao.derby.TransportationOrderDerbyDataAccess;
import model.TransportationOrder;

public class TransportationOrderManager {
	TransportationOrderDerbyDataAccess transportationOrderDataAccess;
	
	public TransportationOrderManager() {
		transportationOrderDataAccess = new TransportationOrderDerbyDataAccess();
	}
	
	/*************************************************************************************************
	 CREATE
	 *************************************************************************************************/
	public void addTransportationOrder(TransportationOrder transportationOrder) {
		transportationOrderDataAccess.addTransportationOrder(transportationOrder);
	}
	
	/*************************************************************************************************
	 READ
	 *************************************************************************************************/
	public TransportationOrder getClient(int clientID) {
		return transportationOrderDataAccess.getClient(clientID);
	}
	
	public ArrayList<TransportationOrder> getAllTransportationOrders() {
		return transportationOrderDataAccess.getAllTransportationOrders();
	}
	
	/*************************************************************************************************
	 UPDATE
	 *************************************************************************************************/
	public void updateClient(TransportationOrder transportationOrder) {
		transportationOrderDataAccess.updateClient(transportationOrder);
	}
	
	/*************************************************************************************************
	 DELETE
	 *************************************************************************************************/
	public void removeTransportationOrder() {
		transportationOrderDataAccess.removeTransportationOrder();
	}
}
