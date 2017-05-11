package model;

public abstract class Estate {
	private Integer id;
	
	private String description;

	/*************************************************************************************************
	 GETTERS
	 *************************************************************************************************/
	public int getId() {
		return id;
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

	public void setDescription(String description) {
		this.description = description;
	}
}
