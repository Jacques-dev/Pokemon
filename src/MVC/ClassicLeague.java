package MVC;

import java.util.ArrayList;

public class ClassicLeague extends AbstractLeague{

	public ClassicLeague() {
		this.members = setMembre();
		this.champion = setChampion();
	}
	
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
