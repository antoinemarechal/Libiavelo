package model;

public class SubscriptionType {
	
	private Integer id;
	private Double annualCost;
	private String description;	
	
	// =================================================================================================
	// CONSTRUCTORS
	// =================================================================================================
	public SubscriptionType(Integer id, String description, Double annualCost) {
		this.setId(id);
		this.setDescription(description);
		this.setAnnualCost(annualCost);
	}
	
	// =================================================================================================
	// GETTERS
	// =================================================================================================
	public Integer getId() {
		return id;
	}
	
	public Double getAnnualCost() {
		return annualCost;
	}
	
	public String getDescription() {
		return description;
	}
	
	// =================================================================================================
	// SETTERS
	// =================================================================================================
	public void setId(Integer id) {
		this.id = id;
	}
	
	public void setAnnualCost(Double cost) {
		this.annualCost = cost;
	}	
	
	public void setDescription(String description) {
		this.description = description;
	}
}
