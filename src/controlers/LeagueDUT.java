package controlers;

import java.util.ArrayList;

public class LeagueDUT extends AbstractLeague {

	/**
	 * LeagueDUT constructor
	 *@return a randomly generated LeagueDUT
	 */	
	public LeagueDUT() {
		this.members = setMembre();
		this.champion = setChampion();
	}
	
	/**
	 * create all the members of the league created randomly
	 *@return an ArrayList<AIModel> representing the league's members
	 */	
	@Override
	ArrayList<AIModel> setMembre() {
		ArrayList<AIModel> members = new ArrayList<>();
		for (int i = 0; i<8; i++) {
			AIModel m = new AIModel(6);
			members.add(m);
		}
		return members;
	}

	@Override
	public String toString() {
		return "ClassicLeague [members=" + members + ", champion=" + champion + "]";
	}

}
