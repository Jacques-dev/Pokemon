package controlers;

import java.util.ArrayList;

public class ClassicLeague extends AbstractLeague{

	/**
	 * ClassicLeague constructor
	 *@return a randomly generated ClassicLeague 
	 */	
	public ClassicLeague() {
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
		for (int i = 0; i<4; i++) {
			AIModel m = new AIModel(5);
			members.add(m);
		}
		return members;
	}

	@Override
	public String toString() {
		return "ClassicLeague [members=" + members + ", champion=" + champion + "]";
	}
	
	

}
