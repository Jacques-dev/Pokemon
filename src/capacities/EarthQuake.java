package capacities;

import abstractClass.Capacity;
import abstractClass.Type;
import capacityType.CapacityType;
import types.Ground;

public class EarthQuake extends Capacity{
	private final static String name = "Earthquake";
	private final static int power = 100;
	private final static int precision = 100;
	private final static Type type = new Ground();
	
	public EarthQuake() {
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
