package dao;

import java.util.ArrayList;

import exception.DataAccessConnectionException;
import exception.DataAccessOperationException;
import exception.InvalidNumberException;
import exception.NoDataException;
import model.TransportationOrder;

public interface TransportationOrderDataAccess {
	
	// ===============================================================================================
	// CREATE
	// ===============================================================================================
	public void addTransportationOrder(TransportationOrder transportationOrder) throws DataAccessConnectionException, DataAccessOperationException;
	
	// ===============================================================================================
	// READ
	// ===============================================================================================
	public TransportationOrder getTransportationOrder(int clientID) throws DataAccessConnectionException, DataAccessOperationException, NoDataException, InvalidNumberException;
	public ArrayList<TransportationOrder> getAllTransportationOrders() throws DataAccessConnectionException, DataAccessOperationException, NoDataException, InvalidNumberException;
	
	// ===============================================================================================
	// UPDATE
	// ===============================================================================================
	public void updateClient(TransportationOrder transportationOrder) throws DataAccessConnectionException, DataAccessOperationException;
	
	// ===============================================================================================
	// DELETE
	// ===============================================================================================
	public void removeTransportationOrder() throws DataAccessConnectionException, DataAccessOperationException;
}
