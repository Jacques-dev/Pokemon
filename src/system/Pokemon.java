package system;

import java.util.List;

public abstract class Pokemon implements Interface {
	
	private final List<Capacity> capacities;
	private final int exp;
	private final int life;
	private final int damages;
	private final int protections;
	private final String specialAttack;
	private final String specialDefense;
	private final int speed;
	
	public Pokemon(List<Capacity> capacities, int exp, int life, int damages, int protections, String specialAttack,
			String specialDefense, int speed) {
		this.capacities = capacities;
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
		return "Pokemon [capacities=" + capacities + ", exp=" + exp + ", life=" + life + ", damages=" + damages
				+ ", protections=" + protections + ", specialAttack=" + specialAttack + ", specialDefense="
				+ specialDefense + ", speed=" + speed + "]";
	}
	
	
}
