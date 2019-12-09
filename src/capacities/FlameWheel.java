package capacities;

import abstractClass.Capacity;
import abstractClass.Type;
import capacityType.CapacityType;
import types.Fire;

public class FlameWheel extends Capacity{
	private final static String name = "FlameWheel";
	private final static int power = 60;
	private final static int precision = 100;
	private final static Type type = new Fire();
	
	public FlameWheel() {
		super(type, power, precision, CapacityType.Special);
	}

	@Override
	public String toString() {
		return "FlameWheel [name=" + name + ", power=" + power + ", precision=" + precision + ", type=" + type
				+ "]";
	}

	@Override
	public boolean hasStatus() {
		return false;
	}
}
