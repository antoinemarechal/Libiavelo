package dao;

import java.util.ArrayList;

import model.Subscription;

public interface SubscriptionDataAccess {
	/*************************************************************************************************
	 CREATE
	 *************************************************************************************************/
	public void addSubscription(Subscription subsription);
	
	/*************************************************************************************************
	 READ
	 *************************************************************************************************/
	public Subscription getSubscription(Subscription subscription);
	public ArrayList<Subscription> getAllSubscriptions();
	
	/*************************************************************************************************
	 UPDATE
	 *************************************************************************************************/
	public void updateSubscription(Subscription subscription);
	
	/*************************************************************************************************
	 DELETE
	 *************************************************************************************************/
	public void removeSubscription(Subscription subscription);
}
