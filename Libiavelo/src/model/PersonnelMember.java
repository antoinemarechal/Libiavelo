package model;

public class PersonnelMember extends Person {
	private int id;
	private static int idGenerator = 0;
	
	private WorkType function;
	
	/*************************************************************************************************
	 CONSTRUCTORS
	 *************************************************************************************************/
	public PersonnelMember(int id) {
		id = idGenerator;
		idGenerator++;
	}
	
	public PersonnelMember(int id, WorkType function) {
		id = idGenerator;
		idGenerator++;
		this.setFunction(function);
	}
	
	/*************************************************************************************************
	 GETTERS
	 *************************************************************************************************/
	public int getId() {
		return id;
	}
	
	public WorkType getFunction() {
		return function;
	}
	
	/*************************************************************************************************
	 SETTERS
	 *************************************************************************************************/
	public void setFunction(WorkType function) {
		this.function = function;
	}
	
}
