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
		for (Pokemon p : team) {
			StringBuilder str = new StringBuilder();
			for (Capacity c : p.getCapacities()) {
				str.append(c.getName()+"  ");
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
		View.selectYourPokemon(team);
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		switch (str) {
			case "0":
				return team.get(0);
			case "1":
				return team.get(1);
			case "2":
				return team.get(2);
			case "3":
				return team.get(3);
			case "4":
				return team.get(4);
			case "5":
				return team.get(5);
		}
		throw new IllegalStateException("There is no pokemon in this team");
	}


	
	
}
