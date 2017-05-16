package business;

import java.util.ArrayList;

import dao.TransportationOrderDataAccess;
import dao.derby.TransportationOrderDerbyDataAccess;
import exception.DataAccessConnectionException;
import exception.DataAccessOperationException;
import exception.InvalidNumberException;
import exception.NoDataException;
import model.TransportationOrder;

public class TransportationOrderManager {
	
	private TransportationOrderDataAccess transportationOrderDataAccess;
	
	public TransportationOrderManager() {
		transportationOrderDataAccess = new TransportationOrderDerbyDataAccess();
	}
	
	// ===============================================================================================
	// CREATE
	// ===============================================================================================
	public void addTransportationOrder(TransportationOrder transportationOrder) throws DataAccessConnectionException, DataAccessOperationException {
		transportationOrderDataAccess.addTransportationOrder(transportationOrder);
	}
	
	// ===============================================================================================
	// READ
	// ===============================================================================================
	public TransportationOrder getTransportationOrder(int clientID) throws DataAccessConnectionException, DataAccessOperationException, NoDataException, InvalidNumberException {
		return transportationOrderDataAccess.getTransportationOrder(clientID);
	}
	
	public ArrayList<TransportationOrder> getAllTransportationOrders() throws DataAccessConnectionException, DataAccessOperationException, NoDataException, InvalidNumberException {
		return transportationOrderDataAccess.getAllTransportationOrders();
	}
	
	// ===============================================================================================
	// UPDATE
	// ===============================================================================================
	public void updateClient(TransportationOrder transportationOrder) throws DataAccessConnectionException, DataAccessOperationException {
		transportationOrderDataAccess.updateClient(transportationOrder);
	}
	
	// ===============================================================================================
	// DELETE
	// ===============================================================================================
	public void removeTransportationOrder() throws DataAccessConnectionException, DataAccessOperationException {
		transportationOrderDataAccess.removeTransportationOrder();
	}
}
