package MVC;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import abstractClass.Capacity;
import abstractClass.Pokemon;
import pokedex.Attacks;
import pokedex.PokedexApparences;
import pokedex.PokedexStats;

@SuppressWarnings("serial")
public class Model implements Serializable{
	private final static Map<Pokemon,ArrayList<Capacity>> team = new HashMap<Pokemon,ArrayList<Capacity>>();
	private static PokedexApparences pa = null;
	private static PokedexStats ps = null;
	private static Attacks a = null;
	private final static int teamSize = 6;
	
	public static void start() {
		try {
			pa = new PokedexApparences();
			ps = new PokedexStats();
			a = new Attacks();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		Controler.start();
		
	}

	@SuppressWarnings("resource")
	static void setTeam() {
		
		ArrayList<Capacity> capacities = new ArrayList<Capacity>();
		
		Scanner sc = new Scanner(System.in);
		int counter = 0;
		while (counter != teamSize) {
			
			
			
			//Pokemon set
			ps.openPokedex();
			System.out.println("\nMy pokemon : ");
			String str = sc.nextLine();
			Pokemon p = null;
			if (str.equals("0")) {
				return;
			}
			if (ps.checkPokemon(str)) {
				p = ps.add(str);
			}
			
			
				
				
			//Capacity set
			for (int i = 0 ; i != 4 ; i++) {
			
				sc = new Scanner(System.in);
				a.openPokedex(p.getTypes());
				System.out.println("\n" + p.getName() + " - capacities : ");
				str = sc.nextLine();
				Capacity c = null;
				if (str.equals("0")) {
					break;
				}
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
	
	static void reloadTeam() {
		
		
	}
	
	public static void printMyTeam() {
		
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
