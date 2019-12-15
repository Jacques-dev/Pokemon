package main;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import View.Menus;
import abstractClass.Capacity;
import abstractClass.Pokemon;
import lab.TimeControl;
import pokedex.Attacks;
import pokedex.PokedexApparences;
import pokedex.PokedexStats;

@SuppressWarnings("serial")
public class Data implements Serializable{
	private final static Map<Pokemon,ArrayList<Capacity>> team = new HashMap<Pokemon,ArrayList<Capacity>>();
	private static PokedexApparences pa = null;
	private static PokedexStats ps = null;
	private static Attacks a = null;
	private final static int teamSize = 6;
	
	@SuppressWarnings("resource")
	public static void start() {
		try {
			pa = new PokedexApparences();
			ps = new PokedexStats();
			a = new Attacks();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		Menus.start();
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		switch (str) {
		case "1":
			Menus.pokemonSelection();
			TimeControl.wait(3);
			setTeam();
			break;
		case "2":
			reloadTeam();
			break;
		case "3":
			Menus.printRules();
			break;
		case "0":
			System.exit(0);
		}
	}

	@SuppressWarnings("resource")
	static void setTeam() {
		
		ArrayList<Capacity> capacities = new ArrayList<Capacity>();
		
		Scanner sc = new Scanner(System.in);
		int counter = 0;
		while (counter != teamSize) {
			
			
			
			//Pokemon set
			ps.openPokedex();
			System.out.println("\nI choose : ");
			String str = sc.nextLine();
			Pokemon p = null;
			if (str.equals("0")) {
				return;
			}
			if (ps.checkPokemon(str)) {
				p = ps.add(str);
			}
			
			
				
				
			//Capacity set
			for (int i = 0 ; i != 1 ; i++) {
			
				sc = new Scanner(System.in);
				a.openPokedex(p.getTypes());
				System.out.println("\n" + p.getName() + " - capacities : ");
				str = sc.nextLine();
				Capacity c = null;
				if (a.checkAttack(str)) {
					c = a.setCapacity(str);
				}
				capacities.add(c);
			}
			
			team.put(p,capacities);
				
			capacities = new ArrayList<Capacity>();
			
			counter++;
			
		}
		
	}
	
	private static void reloadTeam() {
		
		
	}
	
	static void printMyTeam() {
		
		
		System.out.println("\n\n\n\n\n\n\n--YOUR TEAM--");
		
		for (Map.Entry<Pokemon,ArrayList<Capacity>> team : team.entrySet()){
			StringBuilder str = new StringBuilder();
			for (Capacity c : team.getValue()) {
				str.append(c.getName()+" ");
			}
		    System.out.println(team.getKey().getName() + " : [" + str.toString() + "]");
		    
		}
	}
	
}
