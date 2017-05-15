package model.enumerations;

public enum BikeState {
	WORKING("Bon"),
	DAMMAGED("Endommagé"),
	DESTROYED("Déclassé");
	
	private String label;
	
	private BikeState(String label)
	{
		this.label = label;
	}
	
	public static BikeState getFromId(int id) {
		for(BikeState bs : BikeState.values())
		{
			if(bs.ordinal() == id)
				return bs;
		}
		
		return null;
	}
	
	@Override
	public String toString() 
	{
		return label;
	}
}
