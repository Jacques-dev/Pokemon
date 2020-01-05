package abstractClass;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

@SuppressWarnings("serial")
public abstract class Type implements Serializable{
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
		return name;
	}
	
	/**
	 * 
	 * @return return all the types that this one is weak against
	 */
	public ArrayList<Type> getWeakness() {
		return weakness;
	}

	/**
	 * 
	 * @return return all the types that this one is strong against
	 */
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
