package main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import abstractClass.Capacity;
import abstractClass.Pokemon;
import pokedex.Attacks;
import pokedex.PokedexApparences;
import pokedex.PokedexStats;

public class Game {

	public static void main(String[] args) {
		
		PokedexApparences pa = null;
		PokedexStats ps = null;
		Attacks a = null;
		List<Pokemon> team = new ArrayList<Pokemon>();
		List<Capacity> capacities = new ArrayList<Capacity>();
		
		
		try {
			pa = new PokedexApparences();
			ps = new PokedexStats();
			a = new Attacks();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		int truc = 0;
		while (truc != 3) {
			//POKEMON PICK
			Scanner sc = new Scanner(System.in);
			System.out.println("Choose your team !");
			ps.openPokedex();
			System.out.println("I want : ");
			String str = sc.nextLine();
			Pokemon p = null;
			if (ps.checkPokemon(str)) {
				p = ps.add(str);
			}
			team.add(p);
			
			//POKEMON ATTACKS PICK
			if (pa.checkPokemon(str) == true) {
				sc = new Scanner(System.in);
				System.out.println("Choose his attacks");
				a.openPokedex(p.getTypes());
				System.out.println("I want : ");
				str = sc.nextLine();
				Capacity c = null;
				if (a.checkAttack(str)) {
					c = a.setCapacity(str);
				}
				p.learn(c);
			}
			
			System.out.println("Your team : ");
			System.out.println(team);
			truc++;
		}

	}

}
