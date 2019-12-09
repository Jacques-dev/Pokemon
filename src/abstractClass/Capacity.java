package abstractClass;

import capacityType.CapacityType;
import interfaces.I_Capacities;

public abstract class Capacity implements I_Capacities{
	private final Type type; //exemple : new Electric()
	private final int power; //15 - 300
	private final int precision; //0 - 100
	private final CapacityType captype; //exemple : Special
	
	public Capacity(Type type, int power, int precision, CapacityType captype) {
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
