package model.enumerations;

public enum WorkType {
	SECRETARY,
	WORKSHOP_CHIEF,
	WORKSHOP_MANAGER,
	REPAIRER,
	ADMINISTRATOR;

	public static WorkType getFromId(int id) {
		for(WorkType wt : WorkType.values())
		{
			if(wt.ordinal() == id)
				return wt;
		}
		
		return null;
	}
}
