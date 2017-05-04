package business;

import java.util.ArrayList;

import dao.derby.SubscriptionDerbyDataAccess;
import model.Subscription;

public class SubscriptionManager {
	SubscriptionDerbyDataAccess subscriptionDataAccess;
	
	public SubscriptionManager() {
		subscriptionDataAccess = new SubscriptionDerbyDataAccess();
	}
	/*************************************************************************************************
	 CREATE
	 *************************************************************************************************/
	public void addSubscription(Subscription subsription) {
		subscriptionDataAccess.addSubscription(subsription);
	}
	
	/*************************************************************************************************
	 READ
	 *************************************************************************************************/
	public Subscription getSubscription(Subscription subscription) {
		return subscriptionDataAccess.getSubscription(subscription);
	}
	
	public ArrayList<Subscription> getAllSubscriptions() {
		return subscriptionDataAccess.getAllSubscriptions();
	}
	
	/*************************************************************************************************
	 UPDATE
	 *************************************************************************************************/
	public void updateSubscription(Subscription subscription) {
		subscriptionDataAccess.updateSubscription(subscription);
	}
	
	/*************************************************************************************************
	 DELETE
	 *************************************************************************************************/
	public void removeSubscription(Subscription subscription) {
		subscriptionDataAccess.removeSubscription(subscription);
	}
}
