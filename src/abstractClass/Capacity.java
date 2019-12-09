package abstractClass;

import java.util.Objects;

import capacityType.CapacityType;
import interfaces.I_Capacities;

public abstract class Capacity implements I_Capacities{
	private final Type type; //exemple : new Electric()
	private final int power; //15 - 300
	private final int precision; //0 - 100
	private final CapacityType captype; //exemple : Special
	
	public Capacity(Type type, int power, int precision, CapacityType captype) {
		if (power < 15 || power > 300 || !(power%5 == 0)) {
			throw new IllegalArgumentException("Power field is not correct");
		}
		if (precision < 0 || precision > 100) {
			throw new IllegalArgumentException("Precision field is not correct");
		}
		this.power = power;
		this.precision = precision;
		this.type = Objects.requireNonNull(type);
		this.captype = Objects.requireNonNull(captype);}
		
	@Override
	public String toString() {
		return "Capacity [type=" + type + ", power=" + power + ", precision=" + precision + ", captype=" + captype
				+ "]";
	}

}
