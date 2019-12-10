package main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import abstractClass.Capacity;
import abstractClass.Pokemon;
import pokedex.PokedexApparences;
import pokedex.PokedexStats;

public class Game {

	public static void main(String[] args) {
		
		PokedexApparences pa = null;
		PokedexStats ps = null;
		List<Pokemon> team = new ArrayList<Pokemon>();
		List<Capacity> capacities = new ArrayList<Capacity>();
		
		
		try {
			pa = new PokedexApparences();
			ps = new PokedexStats();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		while (true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Choose your team !");
			System.out.println("I want : ");
			String str = sc.nextLine();
			if (pa.checkPokemon(str) == true) {
				System.out.println("Choose his attacks");
			}
			
			System.out.println("Your team : ");
		}

	}

}
