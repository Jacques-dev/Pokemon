package MVC;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import abstractClass.Capacity;
import abstractClass.Pokemon;
import abstractClass.Type;
import pokedex.Attacks;
import pokedex.PokedexApparences;
import pokedex.PokedexStats;

@SuppressWarnings("serial")
public class Model implements Serializable{
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



	public void printTeam(String x) {
		
		System.out.println("--TEAM "+x+"--");
		StringBuilder str = new StringBuilder();
		for (Pokemon p : team) {
			for (Capacity c : p.getCapacities()) {
				str.append(c.getName());
			}
			System.out.println(p.getName()+" : [" + str.toString() + "]");
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
	
	public Pokemon getPokemon() {
		for (Pokemon p : team) {
			return p;
		}
		throw new IllegalStateException("There is no pokemon in this team");
	}


	
	
}
