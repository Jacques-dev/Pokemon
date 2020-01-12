package controlers;

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
abstract class AbstractModel implements Serializable {
	protected ArrayList<Pokemon> team;
	protected PokedexApparences pa;
	protected PokedexStats ps;
	protected Attacks a;
	protected boolean turn;
	private static int SIZE = 6;

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

	public void cleanTeam() {
		for (Pokemon p : team) {
			p.setLife(999);
		}
	}

	public boolean cantFight() {
		if (team.size() <= 0) {
			return true;
		}
		return false;
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

	public boolean getTurn() {
		return turn;
	}

	public void setTeam(ArrayList<Pokemon> t) {
		this.team = t;
	}

	/**
	 * Display all the pokemons contained in a model to choose one
	 * 
	 * @return Pokemon chosen by the user
	 */
	abstract Pokemon getPokemon();

	abstract void setTeam(int teamsize);
}
