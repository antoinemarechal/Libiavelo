package model;

public class SubscriptionType {
	private int id;
	private double cost;
	
	private String description;	
	/*************************************************************************************************
	 CONSTRUCTORS
	 *************************************************************************************************/
	
	/*************************************************************************************************
	 GETTERS
	 *************************************************************************************************/
	public int getId() {
		return id;
	}
	public double getYearlyCost() {
		return cost;
	}
	
	public String getDescription() {
		return description;
	}
	/*************************************************************************************************
	 SETTERS
	 *************************************************************************************************/
	public void setId(int id) {
		this.id = id;
	}
	public void setYearlyCost(double cost) {
		this.cost = cost;
	}	
	
	public void setDescritption(String description) {
		this.description = description;
	}
}
