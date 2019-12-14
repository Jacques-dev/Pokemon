package abstractClass;

import java.util.ArrayList;
import java.util.List;

public class Pokemon {
	
	private final String name;
	private final List<Type> types;
	private final int life;
	private final int damages;
	private final int defenses;
	private final int specialAttack;
	private final int specialDefense;
	private final int speed;
	
	private List<Capacity> capacities = new ArrayList<Capacity>();
	private int exp = 0;
	
	
	
	public Pokemon(String name, List<Type> types, int life, int damages, int defenses, int specialAttack,
			int specialDefense, int speed) {
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

	public String getName() {
		return name;
	}
}
