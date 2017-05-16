package model.enumerations;

public enum BikeState {
	WORKING("Bon"),
	DAMMAGED("Endommag�"),
	DESTROYED("D�class�");
	
	private String label;
	
	private BikeState(String label)
	{
		this.label = label;
	}
	
	public int getStateID() {
        return ordinal() + 1;
    }
            
            
	public static BikeState getFromId(int id) {
        int stateID = id -1;
        for(BikeState bs : BikeState.values())
        {
        	if(bs.ordinal() == stateID)
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
