package pokemons;

import java.util.ArrayList;

import abstractClass.Capacity;
import abstractClass.Pokemon;
import capacities.FutureSight;

public class Hypno extends Pokemon{
	@SuppressWarnings("serial")
	private final static ArrayList<Capacity> capacities = new ArrayList<Capacity>() {{ 
		add(new FutureSight());
		
	}};
	
	public Hypno(String name) {
		super(
			name, //name
			capacities, //list of capacities
			50, //exp
			85, //life
			73, //damages
			70, //protections
			specialAttack, //specialAttack name
			specialDefense, //specialDefense name
			67 //speed
		);
	}
}
