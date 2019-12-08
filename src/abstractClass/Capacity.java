package abstractClass;

import interfaces.CapacityInterface;

public abstract class Capacity {
	private final Type type; //exemple : new Electric()
	private final int power; //15 - 300
	private final int precision; //0 - 100
	private final CapacityInterface captype; //exemple : new SpecialCapacity(name,power,precision,type)
	
	public Capacity(Type type, int power, int precision, CapacityInterface captype) {
		this.type = type;
		this.power = power;
		this.precision = precision;
		this.captype = captype;
	}

	@Override
	public String toString() {
		return "Capacity [type=" + type + ", power=" + power + ", precision=" + precision + ", captype=" + captype
				+ "]";
	}
}
