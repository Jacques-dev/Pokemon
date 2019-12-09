package pokemons;

import java.util.ArrayList;
import java.util.List;

import abstractClass.Capacity;
import abstractClass.Pokemon;
import abstractClass.Type;
import capacities.LightningFlash;
import capacities.ThunderShock;

public class Pikachu extends Pokemon{
	@SuppressWarnings("serial")
	private final static ArrayList<Capacity> capacities = new ArrayList<Capacity>() {{ 
		add(new ThunderShock());
		
	}};
	
	public Pikachu(String name) {
		super(
			name, //name
			capacities, //list of capacities
			50, //exp
			35, //life
			55, //damages
			30, //protections
			specialAttack, //specialAttack name
			specialDefense, //specialDefense name
			90 //speed
		);
	}
	
}
