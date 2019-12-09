package capacities;

import abstractClass.Capacity;
import abstractClass.Type;
import capacityType.CapacityType;
import types.Normal;

public class DoubleEdge extends Capacity{
	private final static String name = "Double-Edge";
	private final static int power = 120;
	private final static int precision = 100;
	private final static Type type = new Normal();
	
	public DoubleEdge() {
		super(type, power, precision, CapacityType.Physical);
	}

	@Override
	public String toString() {
		return "[name=" + name + ", power=" + power + ", precision=" + precision + ", type=" + type
				+ "]";
	}
	
	@Override
	public boolean hasStatus() {
		return true;
	}
}