package business;

import java.util.ArrayList;

import model.Subscription;
import model.SubscriptionType;
import dao.SubscriptionDataAccess;
import dao.SubscriptionTypeDataAccess;
import dao.derby.SubscriptionDerbyDataAccess;
import dao.derby.SubscriptionTypeDerbyDataAccess;

public class SubscriptionTypeManager {
	
	private SubscriptionTypeDataAccess subscriptionTypeDataAccess;
	
	public SubscriptionTypeManager() {
		subscriptionTypeDataAccess = new SubscriptionTypeDerbyDataAccess();
	}
	
	// ===============================================================================================
	// CREATE
	// ===============================================================================================
	public void addSubscriptionType(SubscriptionType subscriptionType) {
		subscriptionTypeDataAccess.addSubscription(subscriptionType);
	}
	
	// ===============================================================================================
	// READ
	// ===============================================================================================
	public SubscriptionType getSubscription(SubscriptionType subscriptionType) {
		return subscriptionTypeDataAccess.getSubscriptionType(subscriptionType);
	}
	
	public ArrayList<Subscription> getAllSubscriptions() {
		return subscriptionTypeDataAccess.getAllSubscriptionTypes();
	}
	
	// ===============================================================================================
	// UPDATE
	// ===============================================================================================
	public void updateSubscription(SubscriptionType subscriptionType) {
		subscriptionTypeDataAccess.updateSubscriptionType(subscriptionType);
	}
	
	// ===============================================================================================
	// DELETE
	// ===============================================================================================
	public void removeSubscription(SubscriptionType subscriptionType) {
		subscriptionTypeDataAccess.removeSubscriptionType(subscriptionType);
	}
}
