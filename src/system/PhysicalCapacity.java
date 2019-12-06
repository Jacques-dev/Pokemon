package system;

import java.util.Objects;

import types.Normal;

public class PhysicalCapacity implements Capacity {
	
	private final String name;
	private final int power;
	private final int precision;
	private final Type type;
	public static final PhysicalCapacity TACKLE = new PhysicalCapacity("Tackle", 15, 100, new Normal());
	
	public PhysicalCapacity(String name, int power, int precision, Type type) {
		super();
		if (power <15 || power > 300 || !((power%5) == 0)) {
			throw new IllegalArgumentException("Power field is not correct");
		}
		if (precision < 0 || precision > 100) {
			throw new IllegalArgumentException("Precision field is not correct");
		}
		this.power = power;
		this.precision = precision;
		this.name = Objects.requireNonNull(name);
		this.type = type;	
	}

	@Override
	public String toString() {
		return "PhysicalCapacity [name=" + name + ", power=" + power + ", precision=" + precision + ", type=" + type
				+ "]";
	}

	public String getName() {
		return name;
	}

	public int getPower() {
		return power;
	}

	public int getPrecision() {
		return precision;
	}

	public Object getType() {
		return type;
	}	
	
}
