package MVC;

import java.util.ArrayList;

public class LeagueDUT extends AbstractLeague {

	public LeagueDUT() {
		this.members = setMembre();
		this.champion = setChampion();
	}
	
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
