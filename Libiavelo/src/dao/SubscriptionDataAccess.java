package dao;

import java.util.ArrayList;
import java.util.Date;

import model.Subscription;

public interface SubscriptionDataAccess {
	
	// ===============================================================================================
	// CREATE
	// ===============================================================================================
	public void addSubscription(Subscription subsription);
	
	// ===============================================================================================
	// READ
	// ===============================================================================================
	public Subscription getSubscription(int clientId, Date demand);
	public ArrayList<Subscription> getAllSubscriptions();
	
	// ===============================================================================================
	// UPDATE
	// ===============================================================================================
	public void updateSubscription(Subscription subscription);
	
	// ===============================================================================================
	// DELETE
	// ===============================================================================================
	public void removeSubscription(Subscription subscription);
}
