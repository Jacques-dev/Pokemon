package abstractClass;

import java.util.List;

import interfaces.CapacityInterface;

public abstract class Pokemon {
	
	private final String name;
	private final List<CapacityInterface> capacityInterfaces;
	private final int exp;
	private final int life;
	private final int damages;
	private final int protections;
	private final String specialAttack;
	private final String specialDefense;
	private final int speed;
	
	public Pokemon(String name, List<CapacityInterface> capacityInterfaces, int exp, int life, int damages, int protections, String specialAttack,
			String specialDefense, int speed) {
		this.name = name;
		this.capacityInterfaces = capacityInterfaces;
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
		return "Pokemon [name=" + name + ", capacities=" + capacityInterfaces + ", exp=" + exp + ", life=" + life + ", damages=" + damages
				+ ", protections=" + protections + ", specialAttack=" + specialAttack + ", specialDefense="
				+ specialDefense + ", speed=" + speed + "]";
	}
	
	
}
