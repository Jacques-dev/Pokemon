package capacities;

import abstractClass.Capacity;
import abstractClass.Type;
import capacityType.CapacityType;
import types.Electric;

public class ThunderShock  extends Capacity{
	private final static String name = "ThunderShock";
	private final static int power = 40;
	private final static int precision = 100;
	private final static Type type = new Electric();
	
	public ThunderShock () {
		super(type, power, precision, CapacityType.Special);
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
