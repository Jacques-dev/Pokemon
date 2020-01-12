package MVC;

import java.util.ArrayList;

public abstract class AbstractLeague {

	protected ArrayList<AIModel> members;
	protected AIModel champion;

	abstract ArrayList<AIModel> setMembre();

	protected AIModel setChampion() {
		return new AIModel(6);
	}

	public void challenge(PlayerModel model) {
		for (AIModel m : members) {
			if (!(model.cantFight())) {
				AIVersus v = new AIVersus(model, m);
				v.start();
			}
		}
		if (!(model.cantFight())) {
			AIVersus v = new AIVersus(model, champion);
			v.start();
		}
		if (!(model.cantFight())) {
			System.out.println("YOU WON THE LEAGUE");
		}
		else {
			System.out.println("You lost the league challenge");
		}
	}

}
