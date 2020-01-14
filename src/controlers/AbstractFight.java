package controlers;

import java.util.ArrayList;
import java.util.Scanner;

import abstractClass.Capacity;
import abstractClass.Pokemon;

public abstract class AbstractFight {

	protected AbstractModel model1;
	protected AbstractModel model2;
	protected Pokemon p1;
	protected Pokemon p2;
	protected ArrayList<Capacity> c1;
	protected ArrayList<Capacity> c2;

	/**
     * Return the fastest pokemon between the two model's pokemon
     * @return the fastest pokemon between p1 & p2
     */
	protected Pokemon getFasterPokemon() {
		if (p1.compareTo(p2) == 1) {
			return p1;
		}
		return p2;
	}

	/**
     * Return the model having the fastest pokemon
     * @return the Model having the fastest pokemon
     */
	protected AbstractModel getFasterModel() {
		if (getFasterPokemon() == p1) {
			return model1;
		}
		return model2;
	}

	/**
     * Allow turns to switch between the two models
     */
	protected void changeTurn() {
		if (model1.getTurn()) {
			model1.turn = false;
			model2.turn = true;
			return;
		}
		model1.turn = true;
		model2.turn = false;
	}

	/**
     * Set the attribute "turn" to true for the model having the fastest pokemon
     * This method is used after each model played to permanently check
     * which model has the faster one
     */
	protected void setTurn() {
		if (getFasterModel() == model1) {
			model1.turn = true;
			return;
		}
		model2.turn = true;
	}

	/**
     * Return the model supposed to play 
     * @return the model having the "turn" attribute to true
     */
	protected AbstractModel whichTurn() {
		if (model1.getTurn()) {
			return model1;
		}
		return model2;
	}

	/**
     * Display the pokemon capacities of the playing model if this one is a "PlayerModel"
     * @param the playing model
     */
	abstract void displayCap(AbstractModel model);

	/**
     * return the capacities of the playing model's pokemon
     * @param the playing model
     * @return an ArrayList<Capacity> representing the capacities of the playing model's pokemon
     */
	protected ArrayList<Capacity> getModelCapacities(AbstractModel model) {
		if (model == model1) {
			return c1;
		}
		return c2;
	}

	/**
     * Display the diffecrent actions possible in-fight and return an int representing the
     * user's choice
     * @param the playing model
     * @return an int representing either the index of the capacity selected, or the an int depending
     * on what type of extra-action the user choosed
     */
	abstract int chooseAction(AbstractModel model);

	/**
     * check if one the pokemon between p1 and p2 has been defeated, make the concerned model
     * change pokemon if it can
     */
	protected void checkHP() {
		if (p1.getLife() <= 0) {
			model1.team.remove(p1);
			if (finish()) {
				return;
			}
			change(model1);
		}
		if (p2.getLife() <= 0) {
			model2.team.remove(p2);
			if (finish()) {
				return;
			}
			change(model2);
		}

	}

	/**
     * check if one of the model has lost all of his pokemon
     * @return true if on of the player can't fight, false if not
     */
	protected boolean finish() {
		if (model1.cantFight()) {
			System.out.println("Player 1 can't fight anymore, Player 2 won");
			return true;
		}
		if (model2.cantFight()) {
			System.out.println("Player 2 can't fight anymore, Player 1 won");
			return true;
		}
		return false;
	}

	/**
     * suppress all the pokemon of a model and finish the game
     * @param the playing model
     */
	protected void escape(AbstractModel model) {
		if (model == model1) {
			model1.cleanTeam();
		} else {
			model2.cleanTeam();
		}
		finish();
	}

	/**
     * make a model change his pokemon
     * @param the playing model
     */
	protected void change(AbstractModel model) {
		if (model == model1) {
			p1 = model1.getPokemon();
			c1 = p1.getCapacities();
			return;
		}
		p2 = model2.getPokemon();
		c2 = p2.getCapacities();
	}

	/**
     * allow the pokemon of the playing model to attack the pokemon of the other model
     * @param the capacity chosen by the player, his pokemon and the pokemon attacked
     * @return the attacked pokemon after taking damages from a selected capacity
     */
	public Pokemon action(Capacity c, Pokemon p_attack,Pokemon p_defend) {
		int x = (int) ((((p_attack.getLevel() * 0.4) + 2) * p_attack.getDamages() * c.getPower())
				/ (p_defend.getDefenses() * 50));
		p_defend.setLife(x);

		View.printLife(p_defend, x);

		return p_defend;
	}
	
	/**
     * attack a pokemon
     * @param the playing model and an int representing the index of the chosen capacity
     */
	protected void attack(AbstractModel model, int capNumb) {
		if (model == model1) {
			Capacity c = c1.get(capNumb);
			if (c.getPP() >= 1) {
			p2 = action(c, p1,p2);
			c.lowerPP();
			}
			else {
				System.out.println("No more pp, can't use this capacity !");
			}
			return;
		}
		Capacity c = c2.get(capNumb);
		if (c.getPP() >= 1) {
		p1 = action(c, p2, p1);
		c.lowerPP();
		}
		else {
			System.out.println("No more pp, can't use this capacity !");
		}
		return;
	}

	/**
     * turn method
     * @param the playing model
     * @return true if the game is finished, false if not
     */
	protected boolean act(AbstractModel model) {
		int x = chooseAction(model);
		if (x == 4) {
			escape(model);
		}
		if (x == 5) {
			change(model);
		}
		if (x >= 0 && x < 4) {
			attack(model, x);
		}
		checkHP();
		changeTurn();
		return finish();
	}

	/**
     * Start a fight
     */
	protected void start() {
		while (true) {
			setTurn();
			if (act(whichTurn())) {
				break;
			}
			if(act(whichTurn())) {
				break;
			}
		}
	}
}
