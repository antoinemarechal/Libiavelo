package model.enumerations;

public enum BikeState {
	WORKING,
	DAMMAGED,
	DESTROYED;
	
	public static BikeState getFromId(int id) {
		for(BikeState bs : BikeState.values())
		{
			if(bs.ordinal() == id)
				return bs;
		}
		
		return null;
	}
}
