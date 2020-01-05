package abstractClass;

import java.io.Serializable;
import java.util.Objects;

import capacityType.CapacityType;
import interfaces.I_Capacities;

@SuppressWarnings("serial")
public class Capacity implements I_Capacities, Serializable{
	private final int number;
	private final String name;
	private final Type type; //exemple : new Electric()
	private final int power; //15 - 300
	private final int pp;
	private final int accuracy; //0 - 100
	private final CapacityType captype; //exemple : Special
	
	public Capacity(int number, String name, Type type, int power, int pp, int accuracy, CapacityType captype) {
//		System.out.println(captype);
//		if (!(captype.equals(CapacityType.Statut))) {
//			if (power < 15 || power > 300 || !(power%5 == 0)) {
//				throw new IllegalArgumentException("Power field is not correct");
//			}
//			if (accuracy < 0 || accuracy > 100) {
//				throw new IllegalArgumentException("Precision field is not correct");
//			}
//		}
		this.number = number;
		this.name = Objects.requireNonNull(name);;
		this.power = power;
		this.pp = pp;
		this.accuracy = accuracy;
		this.type = Objects.requireNonNull(type);
		this.captype = Objects.requireNonNull(captype);}
		
	
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("number :"+number+"\n");
		str.append("name : "+name+"\n");
		str.append("type : "+type+"\n");
		str.append("power : "+power+"\n");
		str.append("pp : "+pp+"\n");
		str.append("accuracy : "+accuracy+"\n");
		str.append("damage_class : "+captype+"\n");
		return str.toString();
	}

	@Override
	public boolean hasStatus() {
		if (captype.equals(CapacityType.Statut)) {
			return true;
		}
		return false;
	}

	public int getNumber() {
		return number;
	}
	
	public String getName() {
		return name;
	}

	public Type getType() {
		return type;
	}
	
	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Capacity)) {return false;}
		Capacity x = (Capacity) o;
		return name.equals(x.name) 
				&& type.equals(x.type) 
				&& power == x.power
				&& pp == x.pp
				&& accuracy == x.accuracy
				&& captype.equals(x.captype);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(name,type,power,pp,accuracy,captype);
	}


	public double getPower() {
		return power;
	}

}
