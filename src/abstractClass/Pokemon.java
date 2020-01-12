package abstractClass;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

import MVC.View;

@SuppressWarnings("serial")
public class Pokemon  implements Serializable, Comparable<Pokemon>{
	
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

	/**
	 * 
	 * @param caps is a list of capacities
	 * @return a new set of capacities for the pokemon
	 */
	public void setCapacities(ArrayList<Capacity> caps) {
		this.capacities = caps;
	}
	
	/**
	 * 
	 * @return the capacities of this pokemon
	 */
	public ArrayList<Capacity> getCapacities() {
		return capacities;
	}

	/**
	 * 
	 * @return the index number of this pokemon from the pokedex
	 */
	public int getNumber() {
		return number;
	}
	
	/**
	 * 
	 * @return the name of this pokemon
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @return the types that this pokemon is composed of
	 */
	public List<Type> getTypes() {
		return types;
	}

	/**
	 * 
	 * @param c is a new capacity that this pokemon will add to his list
	 */
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
	
	/**
	 * 
	 * @return the experience of this pokemon
	 */
	public int getPokemonLevel() {
		return exp;
	}
	
	/**
	 * 
	 * @param x is the experience that the pokemon has won
	 */
	public void levelUp(int x) {
		exp+=x;
	}
	
	/**
	 * 
	 * @return the speed of this pokemon
	 */
	public int getSpeed() {
		return speed;
	}

	/**
	 * 
	 * @return the actual life of this pokemon
	 */
	public int getLife() {
		return life;
	}

	/**
	 * 
	 * @param x is the life that this pokemon will get after being hit by an other pokemon
	 */
	public void setLife(int x) {
		life = life - x;
	}

	/**
	 * 
	 * @return the experience of this pokemon
	 */
	public double getLevel() {
		return exp;
	}

	/**
	 * 
	 * @return the damages that this pokemon is dealing
	 */
	public double getDamages() {
		return damages;
	}

	/**
	 * 
	 * @return the damages that this pokemon handle
	 */
	public int getDefenses() {
		return defenses;
	}
	
	@Override
	public int compareTo(Pokemon o) {
		int s1 = this.getSpeed();
		int s2 = o.getSpeed();
		if (s1 >= s2) {
			return 1;
		}
		return -1;
	}

}
