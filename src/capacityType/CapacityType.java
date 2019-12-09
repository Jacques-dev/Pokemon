package capacityType;

public enum CapacityType {
	Physical(false),
	
	Special(false),
	
	Status(false);
	
	private final boolean type;
	
	private CapacityType(boolean type) {
		this.type = type;
	}
	
	public boolean whatCapacityType() {
		return type;
	}
}
