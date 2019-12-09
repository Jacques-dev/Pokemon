package pokemons;

import java.util.ArrayList;

import abstractClass.Capacity;
import abstractClass.Pokemon;
import capacities.DefenseCurl;

public class Graveler extends Pokemon{
	@SuppressWarnings("serial")
	private final static ArrayList<Capacity> capacities = new ArrayList<Capacity>() {{ 
		add(new DefenseCurl());
		
	}};
	
	public Graveler(String name) {
		super(
			name, //name
			capacities, //list of capacities
			50, //exp
			55, //life
			95, //damages
			115, //protections
			45, //specialAttack damages
			45, //specialDefense protections
			35 //speed
		);
	}
}
