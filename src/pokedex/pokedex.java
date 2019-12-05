package pokedex;

import java.util.Map;
import java.util.Map.Entry;

import system.Pokemon;

public class pokedex {
	private final Map<Integer,Pokemon> pokedex;

	public pokedex(Map<Integer, Pokemon> pokedex) {
		this.pokedex = pokedex;
	}
//Bisous wtf
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		for (Entry<Integer, Pokemon> x : pokedex.entrySet()) {
			str.append(x.getValue().toString());
			str.append("\n");
		}
		return str.toString();
	}
	
	
}
