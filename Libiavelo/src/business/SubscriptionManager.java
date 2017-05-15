package business;

import java.util.ArrayList;
import java.util.Date;

import dao.SubscriptionDataAccess;
import dao.derby.SubscriptionDerbyDataAccess;
import model.Subscription;

public class SubscriptionManager {
	
	private SubscriptionDataAccess subscriptionDataAccess;
	
	public SubscriptionManager() {
		subscriptionDataAccess = new SubscriptionDerbyDataAccess();
	}
	
	// ===============================================================================================
	// CREATE
	// ===============================================================================================
	public void addSubscription(Subscription subsription) {
		subscriptionDataAccess.addSubscription(subsription);
	}
	
	// ===============================================================================================
	// READ
	// ===============================================================================================
	public Subscription getSubscription(int clientId, Date demand) {
		return subscriptionDataAccess.getSubscription(clientId, demand);
	}
	
	public ArrayList<Subscription> getAllSubscriptions() {
		return subscriptionDataAccess.getAllSubscriptions();
	}
	
	// ===============================================================================================
	// UPDATE
	// ===============================================================================================
	public void updateSubscription(Subscription subscription) {
		subscriptionDataAccess.updateSubscription(subscription);
	}
	
	// ===============================================================================================
	// DELETE
	// ===============================================================================================
	public void removeSubscription(Subscription subscription) {
		subscriptionDataAccess.removeSubscription(subscription);
	}
}
