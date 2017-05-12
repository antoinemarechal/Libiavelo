package model.enumerations;

public enum WorkType {
	SECRETARY(1),
	BIKE_CHECKER(2),
	BIKE_TRANSPORTER(3);

	public static WorkType getFromId(int id) {
		for(WorkType wt : WorkType.values())
		{
			if(wt.ordinal() == id)
				return wt;
		}
		
		return null;
	}
	
	private int id; // not used ?
	private WorkType(int id)
	{
		this.id = id;
	}
}
