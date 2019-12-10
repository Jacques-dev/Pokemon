package capacities;

import abstractClass.Capacity;
import abstractClass.Type;
import capacityType.CapacityType;
import types.Fire;

public class FlareBlitz extends Capacity{
	private final static String name = "Flare Blitz";
	private final static int power = 120;
	private final static int precision = 100;
	private final static Type type = new Fire();
	
	public FlareBlitz() {
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
