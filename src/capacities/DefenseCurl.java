package capacities;

import abstractClass.Capacity;
import abstractClass.Type;
import capacityType.CapacityType;
import types.Normal;

public class DefenseCurl extends Capacity{
	private final static String name = "DefenseCurl";
	private final static int power = 0;
	private final static int precision = 0;
	private final static Type type = new Normal();
	
	public DefenseCurl() {
		super(type, power, precision, CapacityType.Special);
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