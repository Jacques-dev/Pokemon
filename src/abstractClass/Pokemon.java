package abstractClass;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@SuppressWarnings("serial")
public class Pokemon  implements Serializable{
	
	private final int number;
	private final String name;
	private final List<Type> types;
	private int life;
	private final int damages;
	private final int defenses;
	private final int specialAttack;
	private final int specialDefense;
	private final int speed;
	private ArrayList<Capacity> capacities = new ArrayList<Capacity>();
	private int exp = 100;
	
	
	
	public Pokemon(int number, String name, List<Type> types, int life, int damages, int defenses, int specialAttack,
			int specialDefense, int speed) {
		this.number = number;
		this.name = name;
		this.types = types;
		this.life = life;
		this.damages = damages;
		this.defenses = defenses;
		this.specialAttack = specialAttack;
		this.specialDefense = specialDefense;
		this.speed = speed;
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("number : "+number+"\n");
		str.append("name : "+name+"\n");
		str.append("types : "+types+"\n");
		str.append("life : "+life+"\n");
		str.append("damages : "+damages+"\n");
		str.append("defenses : "+defenses+"\n");
		str.append("specialAttack : "+specialAttack+"\n");
		str.append("specialDefense : "+specialDefense+"\n");
		str.append("speed : "+speed+"\n");
		return str.toString();
	}

	public void setCapacities(ArrayList<Capacity> caps) {
		this.capacities = caps;
	}
	
	public ArrayList<Capacity> getCapacities() {
		return capacities;
	}

	public int getNumber() {
		return number;
	}
	
	public String getName() {
		return name;
	}

	public List<Type> getTypes() {
		return types;
	}

	public void learn(Capacity c) {
		capacities.add(c);
	}
	
	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Pokemon)) {return false;}
		Pokemon x = (Pokemon) o;
		return name.equals(x.name) 
				&& number == x.number
				&& life == x.life
				&& damages == x.damages
				&& defenses == x.defenses
				&& specialAttack == x.specialAttack
				&& specialDefense == x.specialDefense
				&& speed == x.speed;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(name,types,life,damages,defenses,specialAttack,specialDefense,speed,capacities,exp);
	}
	
	public int getPokemonLevel() {
		return exp;
	}
	
	public void levelUp(int x) {
		exp+=x;
	}
	
	public int getSpeed() {
		return speed;
	}

	public int getLife() {
		return life;
	}

	public void setLife(int x) {
		life = life - x;
	}

	public double getLevel() {
		return exp;
	}

	public double getDamages() {
		return damages;
	}

	public int getDefenses() {
		return defenses;
	}

}
