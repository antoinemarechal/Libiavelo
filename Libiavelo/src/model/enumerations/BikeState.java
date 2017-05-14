package model.enumerations;

public enum BikeState {
	WORKING,
	DAMMAGED,
	DESTROYED;
	
	@Override
	public String toString() {
		switch(this) {
		case DAMMAGED:
			return "DAMMAGED";
		case DESTROYED:
			return "DESTROYED";
		case WORKING:
			return "WORKING";
		default:
				return null;
		}
	}
}
