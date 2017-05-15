package dao;

import java.util.ArrayList;

import exception.DataAccessConnectionException;
import exception.DataAccessOperationException;
import model.Subscription;
import model.SubscriptionType;

public interface SubscriptionTypeDataAccess {

	// ===============================================================================================
	// CREATE
	// ===============================================================================================
	public void addSubscription(SubscriptionType subscriptionType) throws DataAccessConnectionException, DataAccessOperationException;

	// ===============================================================================================
	// READ
	// ===============================================================================================
	public SubscriptionType getSubscriptionType(SubscriptionType subscriptionType) throws DataAccessConnectionException, DataAccessOperationException; 
	public ArrayList<Subscription> getAllSubscriptionTypes() throws DataAccessConnectionException, DataAccessOperationException;

	// ===============================================================================================
	// UPDATE
	// ===============================================================================================
	public void updateSubscriptionType(SubscriptionType subscriptionType) throws DataAccessConnectionException, DataAccessOperationException; 

	// ===============================================================================================
	// DELETE
	// ===============================================================================================
	public void removeSubscriptionType(SubscriptionType subscriptionType) throws DataAccessConnectionException, DataAccessOperationException;
}
