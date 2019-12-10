package capacities;

import abstractClass.Capacity;
import abstractClass.Type;
import capacityType.CapacityType;
import types.Dark;

public class Crunch extends Capacity{
	private final static String name = "Crunch";
	private final static int power = 80;
	private final static int precision = 100;
	private final static Type type = new Dark();
	
	public Crunch() {
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
