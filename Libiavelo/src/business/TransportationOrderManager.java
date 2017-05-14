package business;

import java.util.ArrayList;

import dao.TransportationOrderDataAccess;
import dao.derby.TransportationOrderDerbyDataAccess;
import model.TransportationOrder;

public class TransportationOrderManager {
	TransportationOrderDataAccess transportationOrderDataAccess;
	
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
	public TransportationOrder getTransportationOrder(int clientID) {
		return transportationOrderDataAccess.getTransportationOrder(clientID);
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
