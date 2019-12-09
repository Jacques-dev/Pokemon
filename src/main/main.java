package main;

import java.io.IOException;

import pokedex.Pokedex;

public class main {

	public static void main(String[] args) {
//		Type normal = new Normal();
//		PhysicalCapacity p = PhysicalCapacity.TACKLE;
//		System.out.println(p.getType());
//		System.out.println(p.getPower());
		
		
		Pokedex t = null;
		try {
			t = new Pokedex();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		t.checkPokemon("pikachu");
	}

}
