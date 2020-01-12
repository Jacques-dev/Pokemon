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

	protected Pokemon getFasterPokemon() {
		if (p1.compareTo(p2) == 1) {
			return p1;
		}
		return p2;
	}

	protected AbstractModel getFasterModel() {
		if (getFasterPokemon() == p1) {
			return model1;
		}
		return model2;
	}

	protected void changeTurn() {
		if (model1.getTurn()) {
			model1.turn = false;
			model2.turn = true;
			return;
		}
		model1.turn = true;
		model2.turn = false;
	}

	protected void setTurn() {
		if (getFasterModel() == model1) {
			model1.turn = true;
			return;
		}
		model2.turn = true;
	}

	protected AbstractModel whichTurn() {
		if (model1.getTurn()) {
			return model1;
		}
		return model2;
	}

	abstract void displayCap(AbstractModel model);

	protected ArrayList<Capacity> getModelCapacities(AbstractModel model) {
		if (model == model1) {
			return c1;
		}
		return c2;
	}

	abstract int chooseAction(AbstractModel model);

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

	protected void escape(AbstractModel model) {
		if (model == model1) {
			model1.cleanTeam();
		} else {
			model2.cleanTeam();
		}
		finish();
	}

	protected void change(AbstractModel model) {
		if (model == model1) {
			p1 = model1.getPokemon();
			c1 = p1.getCapacities();
			return;
		}
		p2 = model2.getPokemon();
		c2 = p2.getCapacities();
	}

	public Pokemon action(Capacity c, Pokemon p_attack,Pokemon p_defend) {
		int x = (int) ((((p_attack.getLevel() * 0.4) + 2) * p_attack.getDamages() * c.getPower())
				/ (p_defend.getDefenses() * 50));
		p_defend.setLife(x);

		View.printLife(p_defend, x);

		return p_defend;
	}
	
	protected void attack(AbstractModel model, int capNumb) {
		if (model == model1) {
			Capacity c = c1.get(capNumb);
			p2 = action(c, p1,p2);
			return;
		}
		Capacity c = c2.get(capNumb);
		p1 = action(c, p2, p1);
		return;
	}

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
