package model;

public class SubscriptionType {
	private Integer id;
	private Double cost;
	
	private String description;	
	/*************************************************************************************************
	 CONSTRUCTORS
	 *************************************************************************************************/
	public SubscriptionType(int subscriptionDuration, String description) {
		this.cost = subscriptionDuration * 10.95; //TODO de-troll me
		this.description = description;
	}
	
	/*************************************************************************************************
	 GETTERS
	 *************************************************************************************************/
	public int getId() {
		return id;
	}
	public double getTotalCost() {
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
	public void setTotalCost(double cost) {
		this.cost = cost;
	}	
	
	public void setDescritption(String description) {
		this.description = description;
	}
}
