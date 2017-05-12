package dao.derby;

import java.util.ArrayList;

import dao.TransportationOrderDataAccess;
import model.TransportationOrder;

public class TransportationOrderDerbyDataAccess implements TransportationOrderDataAccess {
	public TransportationOrderDerbyDataAccess() { // FIXME : DO dis + mettre la requête du join dans la table "principale" de la requête
	}
	/*************************************************************************************************
	 CREATE
	 *************************************************************************************************/
	public void addTransportationOrder(TransportationOrder transportationOrder) {
	}
	
	/*************************************************************************************************
	 READ
	 *************************************************************************************************/
	public TransportationOrder getClient(int clientID) {
		return null;
	}
	public ArrayList<TransportationOrder> getAllTransportationOrders() {
		return null;
	}
	
	/*************************************************************************************************
	 UPDATE
	 *************************************************************************************************/
	public void updateClient(TransportationOrder transportationOrder) {
	}
	
	/*************************************************************************************************
	 DELETE
	 *************************************************************************************************/
	public void removeTransportationOrder() {
		
	}

}
