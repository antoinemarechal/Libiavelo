package model;

import java.util.Date;

public class Subscription {
	private Double amountToPay;
	
	private Date demand;
	private Date expiry;

	private SubscriptionType subscriptionType;
	/*************************************************************************************************
	 CONSTRUCTOR
	 *************************************************************************************************/
	public Subscription(double amountToPay, Date demand, Date expiry, int subscriptionDuration, String description) {
		this.setAmountToPay(amountToPay);
		this.setDemand(demand);
		this.setExpiry(expiry);
		this.setSubscriptionType(new SubscriptionType(subscriptionDuration, description));
	}
	
	/*************************************************************************************************
	 GETTERS
	 *************************************************************************************************/	
	public double getAmountToPay() {
		return amountToPay;
	}
	public Date getDemand() {
		return demand;
	}
	public Date getExpiry() {
		return expiry;
	}
	
	public SubscriptionType getSubscriptionType() {
		return subscriptionType;
	}
	
	/*************************************************************************************************
	 SETTERS
	 *************************************************************************************************/
	public void setAmountToPay(double amountToPay) {
		this.amountToPay = amountToPay;
	}
	public void setDemand(Date demand) {
		this.demand = demand;
	}
	public void setExpiry(Date expiry) {
		this.expiry = expiry;
	}

	public void setSubscriptionType(SubscriptionType subscriptionType) {
		this.subscriptionType = subscriptionType;
	}	
}
