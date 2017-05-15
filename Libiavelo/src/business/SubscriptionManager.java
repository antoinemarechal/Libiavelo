package business;

import java.util.ArrayList;
import java.util.Date;

import dao.SubscriptionDataAccess;
import dao.derby.SubscriptionDerbyDataAccess;
import exception.DataAccessConnectionException;
import exception.DataAccessOperationException;
import model.Subscription;

public class SubscriptionManager {
	
	private SubscriptionDataAccess subscriptionDataAccess;
	
	public SubscriptionManager() {
		subscriptionDataAccess = new SubscriptionDerbyDataAccess();
	}
	
	// ===============================================================================================
	// CREATE
	// ===============================================================================================
	public void addSubscription(Subscription subsription) throws DataAccessConnectionException, DataAccessOperationException {
		subscriptionDataAccess.addSubscription(subsription);
	}
	
	// ===============================================================================================
	// READ
	// ===============================================================================================
	public Subscription getSubscription(int clientId, Date demand) throws DataAccessConnectionException, DataAccessOperationException {
		return subscriptionDataAccess.getSubscription(clientId, demand);
	}
	
	public ArrayList<Subscription> getAllSubscriptions() throws DataAccessConnectionException, DataAccessOperationException {
		return subscriptionDataAccess.getAllSubscriptions();
	}
	
	// ===============================================================================================
	// UPDATE
	// ===============================================================================================
	public void updateSubscription(Subscription subscription) throws DataAccessConnectionException, DataAccessOperationException {
		subscriptionDataAccess.updateSubscription(subscription);
	}
	
	// ===============================================================================================
	// DELETE
	// ===============================================================================================
	public void removeSubscription(Subscription subscription) throws DataAccessConnectionException, DataAccessOperationException {
		subscriptionDataAccess.removeSubscription(subscription);
	}
}
