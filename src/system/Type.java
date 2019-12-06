package system;

import java.util.ArrayList;
import java.util.Objects;

public abstract class Type {
	private final String name;
	private final ArrayList<Type> weakness;
	private final ArrayList<Type> strength;
	
	public Type(String name, ArrayList<Type> weakness, ArrayList<Type> strength) {
		this.name = name;
		this.weakness = weakness;
		this.strength = strength;
	}
	
	public Type(String name, ArrayList<Type> weakness) {
		this(name,weakness, new ArrayList<Type>());
	}

	@Override
	public String toString() {
		return "Type = " + name;
	}
	
	public ArrayList<Type> getWeakness() {
		return weakness;
	}

	public ArrayList<Type> getStrength() {
		return strength;
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Type)) {return false;}
		Type x = (Type) o;
		return name.equals(x.name) && weakness.equals(x.weakness) && strength.equals(x.strength);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(name,weakness, strength);
	}
}
