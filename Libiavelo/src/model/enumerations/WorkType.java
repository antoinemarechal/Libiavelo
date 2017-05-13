package model.enumerations;

public enum WorkType {
	SECRETARY,
	BIKE_CHECKER,
	BIKE_TRANSPORTER;

	public static WorkType getFromId(int id) {
		for(WorkType wt : WorkType.values())
		{
			if(wt.ordinal() == id)
				return wt;
		}
		
		return null;
	}
}
