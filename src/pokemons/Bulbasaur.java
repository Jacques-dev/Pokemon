package pokemons;

import java.util.ArrayList;

import abstractClass.Capacity;
import abstractClass.Pokemon;
import capacities.DoubleEdge;
import capacities.VineWhip;

public class Bulbasaur extends Pokemon{
	@SuppressWarnings("serial")
	private final static ArrayList<Capacity> capacities = new ArrayList<Capacity>() {{ 
		add(new VineWhip());
		add(new DoubleEdge());
		
	}};
	
	public Bulbasaur(String name) {
		super(
			name, //name
			capacities, //list of capacities
			50, //exp
			45, //life
			49, //damages
			49, //protections
			65, //specialAttack name
			65, //specialDefense name
			45 //speed
		);
	}
}
