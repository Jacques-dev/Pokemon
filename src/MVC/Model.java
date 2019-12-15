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
	private Map<Pokemon,ArrayList<Capacity>> team;
	private final PokedexApparences pa;
	private final PokedexStats ps;
	private final Attacks a;
	private final static int SIZE = 6;
	
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



	public void printTeam(String x) {
		
		System.out.println("--TEAM "+x+"--");
		
		for (Map.Entry<Pokemon,ArrayList<Capacity>> team : team.entrySet()){
			StringBuilder str = new StringBuilder();
			for (Capacity c : team.getValue()) {
				str.append(c.getName()+" ");
			}
		    System.out.println(team.getKey().getName() + " : [" + str.toString() + "]");
		    
		}
	}
	
//	@Override
//	public boolean equals(Object o) {
//		if (!(o instanceof Model)) {return false;}
//		Model x = (Model) o;
//		return pa.equals(x.pa) 
//				&& ps.equals(x.ps) 
//				&& a.equals(x.a) 
//				&& SIZE == x.SIZE;
//	}
//	
//	@Override
//	public int hashCode() {
//		return Objects.hash(team,pa,ps,a,SIZE);
//	}
	
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
	
	public Map<Pokemon, ArrayList<Capacity>> getTeam() {
		return team;
	}
	
	public void setTeam(Map<Pokemon, ArrayList<Capacity>> t) {
		this.team = t;
	}
	
	public Pokemon getPokemon() {
		for (HashMap.Entry<Pokemon, ArrayList<Capacity>> team : team.entrySet()) {
			System.out.println("BORDEEEEEEEEEEEEEEEL\n"+team.getKey());
			return team.getKey();
		}
		return null;
	}
	
	public ArrayList<Capacity> getCapacities() {
		for (HashMap.Entry<Pokemon, ArrayList<Capacity>> team : team.entrySet()) {
			return team.getValue();
		}
		return null;
	}


	
	
}
