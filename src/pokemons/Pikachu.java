package pokemons;

import java.util.ArrayList;
import java.util.List;

import abstractClass.Capacity;
import abstractClass.Pokemon;
import abstractClass.Type;
import capacities.LightningFlash;
import types.Dark;
import types.Grass;
import types.Psychic;

public class Pikachu extends Pokemon{
	@SuppressWarnings("serial")
	private final static ArrayList<Capacity> list = new ArrayList<Capacity>() {{ 
		add(new LightningFlash());
	}};
	
	public Pikachu() {
		//List<Capacity> capacities, int exp, int life, int damages, int protections, String specialAttack,
		//String specialDefense, int speed
		
		super(list, 50, 100, 100, 25, specialAttack, specialDefense, 100);
	}
 
}
