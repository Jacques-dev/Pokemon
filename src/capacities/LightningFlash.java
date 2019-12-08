package capacities;

import abstractClass.Capacity;
import abstractClass.Type;
import capacityType.SpecialCapacity;
import types.Electric;

public class LightningFlash extends Capacity{
	private final static String name = "LightningFlash";
	private final static int power = 100;
	private final static int precision = 50;
	private final static Type type = new Electric();
	
	public LightningFlash() {
		super(new Electric(), 100, 50, new SpecialCapacity(name,power,precision,type));
	}

	@Override
	public String toString() {
		return "LightningFlash [name=" + name + ", power=" + power + ", precision=" + precision + ", type=" + type
				+ "]";
	}
}
