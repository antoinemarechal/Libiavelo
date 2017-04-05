package model;

import java.util.Date;

public class Subscription {
	private double amountToPay;
	
	private Date demand;
	private Date expiry;

	/*************************************************************************************************
	 CONSTRUCTOR
	 *************************************************************************************************/
	public Subscription(double amountToPay, Date demand, Date expiry) {
		this.setAmountToPay(amountToPay);
		this.setDemand(demand);
		this.setExpiry(expiry);
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

	
}
