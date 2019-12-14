package main;

import java.io.IOException;

import View.Menus;
import pokedex.Attacks;
import pokedex.PokedexApparences;
import pokedex.PokedexStats;

public class Test {

	public static void main(String[] args) {
		
		PokedexApparences pa = null;
		PokedexStats ps = null;
		Attacks a = null;
		try {
			pa = new PokedexApparences();
			ps = new PokedexStats();
			a = new Attacks();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
//		pa.checkPokemon("Pikachu");
		ps.checkPokemon("Pikachu");
		
//		a.checkAttack("pound");
		
		
//		Menus.start();
//		Menus.pokemonSelection();
		
		
	}

}
