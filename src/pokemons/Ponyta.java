package pokemons;

import java.util.ArrayList;

import abstractClass.Capacity;
import abstractClass.Pokemon;
import capacities.FlameWheel;

public class Ponyta extends Pokemon{
	@SuppressWarnings("serial")
	private final static ArrayList<Capacity> capacities = new ArrayList<Capacity>() {{ 
		add(new FlameWheel());
		
	}};
	
	public Ponyta(String name) {
		super(
			name, //name
			capacities, //list of capacities
			50, //exp
			50, //life
			85, //damages
			55, //protections
			65, //specialAttack
			65, //specialDefense
			90 //speed
		);
	}
}
