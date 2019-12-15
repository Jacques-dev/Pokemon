package MVC;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;

import abstractClass.Capacity;
import abstractClass.Pokemon;
import pokedex.Attacks;
import pokedex.PokedexApparences;
import pokedex.PokedexStats;

@SuppressWarnings("serial")
public class Model implements Serializable{
	private final Map<Pokemon,ArrayList<Capacity>> team;;
	private final PokedexApparences pa;
	private final PokedexStats ps;
	private final Attacks a;
	private final static int teamSize = 6;
	
	public Model(Map<Pokemon,ArrayList<Capacity>> team, PokedexApparences pa, PokedexStats ps, Attacks a) {
		this.team = team;
		this.pa = pa;
		this.ps = ps;
		this.a = a;
	}

	
	
	@Override
	public String toString() {
		return "team=" + team;
	}



	public void printMyTeam() {
		
		System.out.println("\n\n\n\n\n\n\n--YOUR TEAM--");
		
		for (Map.Entry<Pokemon,ArrayList<Capacity>> team : team.entrySet()){
			StringBuilder str = new StringBuilder();
			for (Capacity c : team.getValue()) {
				str.append(c.getName()+" ");
			}
		    System.out.println(team.getKey().getName() + " : [" + str.toString() + "]");
		    
		}
		
		System.out.println("\n>>>");
	}
	
	public static int getTeamSize() {
		return teamSize;
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
}
