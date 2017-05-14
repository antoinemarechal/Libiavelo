package model;

public abstract class Estate {
	private Integer id;
	
	private String description, streetName, streetNumber;

	private Locality locality;
	
	/*************************************************************************************************
	 GETTERS
	 *************************************************************************************************/
	public int getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}
	
	public String getStreetName() {
		return streetName;
	}
	
	public String getStreetNumber() {
		return streetNumber;
	}
	
	public Locality getLocality() {
		return locality;
	}
	
	/*************************************************************************************************
	 SETTERS
	 *************************************************************************************************/
	public void setId(int id) {
		this.id = id;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	
	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}
	
	public void setLocality(Locality locality) {
		this.locality = locality;
	}
}
