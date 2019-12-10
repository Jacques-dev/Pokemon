package capacities;

import abstractClass.Capacity;
import abstractClass.Type;
import capacityType.CapacityType;
import types.Grass;

public class VineWhip extends Capacity{
	private final static String name = "VineWhip";
	private final static int power = 45;
	private final static int precision = 100;
	private final static Type type = new Grass();
	
	public VineWhip() {
		super(type, power, precision, CapacityType.Physical);
	}

	@Override
	public String toString() {
		return name + "[power=" + power + ", precision=" + precision + ", type=" + type
				+ "]";
	}

	@Override
	public boolean hasStatus() {
		return false;
	}
}