package abstractClass;

import java.util.List;

public abstract class Pokemon {
	
	private final String name;
	private final List<Capacity> capacities;
	private final int exp;
	private final int life;
	private final int damages;
	private final int protections;
	private final int specialAttack;
	private final int specialDefense;
	private final int speed;
	
	public Pokemon(String name, List<Capacity> capacityInterfaces, int exp, int life, int damages, int protections, int specialAttack,
			int specialDefense, int speed) {
		this.name = name;
		this.capacities = capacityInterfaces;
		this.exp = exp;
		this.life = life;
		this.damages = damages;
		this.protections = protections;
		this.specialAttack = specialAttack;
		this.specialDefense = specialDefense;
		this.speed = speed;
	}

	@Override
	public String toString() {
		return "Pokemon [name=" + name + ", capacities=" + capacities + ", exp=" + exp + ", life=" + life + ", damages=" + damages
				+ ", protections=" + protections + ", specialAttack=" + specialAttack + ", specialDefense="
				+ specialDefense + ", speed=" + speed + "]";
	}
	
	
}
