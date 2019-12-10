package capacities;

import abstractClass.Capacity;
import abstractClass.Type;
import capacityType.CapacityType;
import types.Electric;

public class Thunder extends Capacity{
	private final static String name = "Thunder";
	private final static int power = 110;
	private final static int precision = 70;
	private final static Type type = new Electric();
	
	public Thunder() {
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
