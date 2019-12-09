package pokemons;

import java.util.ArrayList;

import abstractClass.Capacity;
import abstractClass.Pokemon;
import capacities.Bite;

public class Rattata extends Pokemon{
	@SuppressWarnings("serial")
	private final static ArrayList<Capacity> capacities = new ArrayList<Capacity>() {{ 
		add(new Bite());
		
	}};
	
	public Rattata(String name) {
		super(
			name, //name
			capacities, //list of capacities
			50, //exp
			30, //life
			56, //damages
			35, //protections
			specialAttack, //specialAttack name
			specialDefense, //specialDefense name
			75 //speed
		);
	}
}
