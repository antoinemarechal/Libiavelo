package model;

public class Estate {
	
	private Integer id;
	
	private String description, streetName, streetNumber;

	private Locality locality;
	
	// =================================================================================================
	// CONSTRUCTORS
	// =================================================================================================
	public Estate(Integer id, String description, String streetName, String streetNumber, Locality locality) {
		this.setId(id);
		this.setDescription(description);
		this.setStreetName(streetName);
		this.setStreetNumber(streetNumber);
		this.setLocality(locality);
	}

	// =================================================================================================
	// GETTERS
	// =================================================================================================
	public Integer getId() {
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

	// =================================================================================================
	// SETTERS
	// =================================================================================================
	public void setId(Integer id) {
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
