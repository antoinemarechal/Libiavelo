package dao;

import java.util.ArrayList;

import model.Subscription;
import model.SubscriptionType;

public interface SubscriptionTypeDataAccess {

	// ===============================================================================================
	// CREATE
	// ===============================================================================================
	public void addSubscription(SubscriptionType subscriptionType);

	// ===============================================================================================
	// READ
	// ===============================================================================================
	public SubscriptionType getSubscriptionType(SubscriptionType subscriptionType); 
	public ArrayList<Subscription> getAllSubscriptionTypes();

	// ===============================================================================================
	// UPDATE
	// ===============================================================================================
	public void updateSubscriptionType(SubscriptionType subscriptionType); 

	// ===============================================================================================
	// DELETE
	// ===============================================================================================
	public void removeSubscriptionType(SubscriptionType subscriptionType);
}
