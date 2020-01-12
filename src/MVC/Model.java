package MVC;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

import abstractClass.Capacity;
import abstractClass.Pokemon;
import abstractClass.Type;
import pokedex.Attacks;
import pokedex.PokedexApparences;
import pokedex.PokedexStats;

@SuppressWarnings("serial")
public class Model implements Serializable {
	private ArrayList<Pokemon> team;
	private final PokedexApparences pa;
	private final PokedexStats ps;
	private final Attacks a;
	private final static int SIZE = 6;

	public Model(ArrayList<Pokemon> team, PokedexApparences pa, PokedexStats ps, Attacks a) {
		this.team = team;
		this.pa = pa;
		this.ps = ps;
		this.a = a;
	}

	@Override
	public String toString() {
		return "team=" + team;
	}

	/**
	 * Display all the pokemons of a model with their capacities
	 * 
	 * @param String "x" representing the team's name
	 */
	public void printTeam(String x) {

		System.out.println("--TEAM " + x + "--");
		for (Pokemon p : team) {
			StringBuilder str = new StringBuilder();
			for (Capacity c : p.getCapacities()) {
				str.append(c.getName() + "  ");
			}
			System.out.println(p.getName() + " : [" + str.toString() + "]");
		}
	}

	public static int getSIZE() {
		return SIZE;
	}

	public int getTeamSize() {
		return team.size();
	}

	public PokedexApparences getPa() {
		return pa;
	}

	public PokedexStats getPs() {
		return ps;
	}

	public Attacks getA() {
		return a;
	}

	public ArrayList<Pokemon> getTeam() {
		return team;
	}

	public void setTeam(ArrayList<Pokemon> t) {
		this.team = t;
	}

	/**
	 * Display all the pokemons contained in a model to choose one
	 * 
	 * @return Pokemon chosen by the user
	 */
	public Pokemon getPokemon() {
		View.selectYourPokemon(team);
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		while (true) {
			try {
				if (Integer.valueOf(str) >= 0 && Integer.valueOf(str) < team.size()) {
					return team.get(Integer.valueOf(str));
				}
				System.out.println("Choose a valid index\n");
				str = sc.nextLine();
			} catch (Exception e) {
				System.out.println("Enter a number\n");
				View.selectYourPokemon(team);
				str = sc.nextLine();
			}
		}
	}

}
