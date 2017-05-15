package dao;

import java.util.ArrayList;
import java.util.Date;

import exception.DataAccessConnectionException;
import exception.DataAccessOperationException;
import model.Subscription;

public interface SubscriptionDataAccess {
	
	// ===============================================================================================
	// CREATE
	// ===============================================================================================
	public void addSubscription(Subscription subsription) throws DataAccessConnectionException, DataAccessOperationException;
	
	// ===============================================================================================
	// READ
	// ===============================================================================================
	public Subscription getSubscription(int clientId, Date demand) throws DataAccessConnectionException, DataAccessOperationException;
	public ArrayList<Subscription> getAllSubscriptions() throws DataAccessConnectionException, DataAccessOperationException;
	
	// ===============================================================================================
	// UPDATE
	// ===============================================================================================
	public void updateSubscription(Subscription subscription) throws DataAccessConnectionException, DataAccessOperationException;
	
	// ===============================================================================================
	// DELETE
	// ===============================================================================================
	public void removeSubscription(Subscription subscription) throws DataAccessConnectionException, DataAccessOperationException;
}
