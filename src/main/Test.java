package main;

import java.io.IOException;

import View.Menus;
import capacities.Capacities;
import pokedex.PokedexApparences;
import pokedex.PokedexStats;

public class Test {

	public static void main(String[] args) {
		
		PokedexApparences pa = null;
		PokedexStats ps = null;
		try {
			pa = new PokedexApparences();
			ps = new PokedexStats();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		pa.checkPokemon("Pikachu");
		ps.checkPokemon("Pikachu");
		
		
//		Menus.start();
//		Menus.pokemonSelection();
		
		Capacities.openCapacities();
	}

}
