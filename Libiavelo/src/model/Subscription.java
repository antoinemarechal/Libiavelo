package model;

import java.util.Date;

public class Subscription {
	
	private Float amountToPay;
	
	private Date demand;
	private Date expiry;

	private SubscriptionType subscriptionType;
	
	// =================================================================================================
	// CONSTRUCTORS
	// =================================================================================================
	public Subscription(Float amountToPay, Date demand, Date expiry, SubscriptionType subscriptionType) {
		this.setAmountToPay(amountToPay);
		this.setDemand(demand);
		this.setExpiry(expiry);
		this.setSubscriptionType(subscriptionType);
	}
	
	// =================================================================================================
	// GETTERS
	// =================================================================================================
	public Float getAmountToPay() {
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
	
	// =================================================================================================
	// SETTERS
	// =================================================================================================
	public void setAmountToPay(Float amountToPay) {
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
