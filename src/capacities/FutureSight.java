package capacities;

import abstractClass.Capacity;
import abstractClass.Type;
import capacityType.CapacityType;
import types.Psychic;

public class FutureSight extends Capacity{
	private final static String name = "FutureSight";
	private final static int power = 120;
	private final static int precision = 100;
	private final static Type type = new Psychic();
	
	public FutureSight() {
		super(type, power, precision, CapacityType.Special);
	}

	@Override
	public String toString() {
		return "[name=" + name + ", power=" + power + ", precision=" + precision + ", type=" + type
				+ "]";
	}
	
	@Override
	public boolean hasStatus() {
		return false;
	}
}

