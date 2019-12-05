package system;

import java.awt.image.BufferedImage;
import java.util.List;

public abstract class Pokemon implements Interface {
	
	private final BufferedImage image;
	private final List<Type> types;
	private final String name;
	private final int weight;
	private final int size;
	private final List<Capacity> capacities;
	private final int exp;
	private final int life;
	private final int damages;
	private final int protections;
	private final String specialAttack;
	private final String specialDefense;
	private final int speed;
	
	public Pokemon(BufferedImage image, List<Type> types, String name, int weight, int size, List<Capacity> capacities,
			int exp, int life, int damages, int protections, String specialAttack, String specialDefense, int speed) {
		this.image = image;
		this.types = types;
		this.name = name;
		this.weight = weight;
		this.size = size;
		this.capacities = capacities;
		this.exp = exp;
		this.life = life;
		this.damages = damages;
		this.protections = protections;
		this.specialAttack = specialAttack;
		this.specialDefense = specialDefense;
		this.speed = speed;
	}
	
	
}
