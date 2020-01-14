package controlers;

import java.util.ArrayList;

public abstract class AbstractLeague {

	protected ArrayList<AIModel> members;
	protected AIModel champion;

	/**
     * create all the members of a league
     * @return an ArrayList<AIModel> filled with AIModels created randomly
     */
	abstract ArrayList<AIModel> setMembre();

	/**
     * create the champion of the league
     * @return an AIModel created randomly
     */
	protected AIModel setChampion() {
		return new AIModel(6);
	}

	/**
     * initiate a serie of fight between a model and the league members to finish with the champion
     * @param a model
     */
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
