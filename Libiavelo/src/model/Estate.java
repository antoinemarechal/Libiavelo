package model;

public abstract class Estate {
	private int id;
	private static int idGenerator = -1;
	
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
	void setId(int id) {
		this.id = id;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	/*************************************************************************************************
	 OTHERS
	 *************************************************************************************************/
	public static int generateNextId() {
		idGenerator++;
		return idGenerator;
	}
}
