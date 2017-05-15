package business;

import java.util.ArrayList;

import model.Subscription;
import model.SubscriptionType;
import dao.SubscriptionTypeDataAccess;
import dao.derby.SubscriptionTypeDerbyDataAccess;
import exception.DataAccessConnectionException;
import exception.DataAccessOperationException;

public class SubscriptionTypeManager {
	
	private SubscriptionTypeDataAccess subscriptionTypeDataAccess;
	
	public SubscriptionTypeManager() {
		subscriptionTypeDataAccess = new SubscriptionTypeDerbyDataAccess();
	}
	
	// ===============================================================================================
	// CREATE
	// ===============================================================================================
	public void addSubscriptionType(SubscriptionType subscriptionType) throws DataAccessConnectionException, DataAccessOperationException {
		subscriptionTypeDataAccess.addSubscription(subscriptionType);
	}
	
	// ===============================================================================================
	// READ
	// ===============================================================================================
	public SubscriptionType getSubscription(SubscriptionType subscriptionType) throws DataAccessConnectionException, DataAccessOperationException {
		return subscriptionTypeDataAccess.getSubscriptionType(subscriptionType);
	}
	
	public ArrayList<Subscription> getAllSubscriptions() throws DataAccessConnectionException, DataAccessOperationException {
		return subscriptionTypeDataAccess.getAllSubscriptionTypes();
	}
	
	// ===============================================================================================
	// UPDATE
	// ===============================================================================================
	public void updateSubscription(SubscriptionType subscriptionType) throws DataAccessConnectionException, DataAccessOperationException {
		subscriptionTypeDataAccess.updateSubscriptionType(subscriptionType);
	}
	
	// ===============================================================================================
	// DELETE
	// ===============================================================================================
	public void removeSubscription(SubscriptionType subscriptionType) throws DataAccessConnectionException, DataAccessOperationException {
		subscriptionTypeDataAccess.removeSubscriptionType(subscriptionType);
	}
}
