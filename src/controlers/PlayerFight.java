package controlers;

import java.util.ArrayList;
import java.util.Scanner;

import abstractClass.Capacity;
import abstractClass.Pokemon;

public class PlayerFight extends AbstractFight{

	/**
     * PlayerFight constructor
     * @param two PlayerModel, two Pokemon representing the two players Pokemon & two ArrayList<Capacity>
     * representing the pokemon capacities
     */
	public PlayerFight(PlayerModel model1, PlayerModel model2, Pokemon p1, Pokemon p2, ArrayList<Capacity> c1, ArrayList<Capacity> c2) {
		this.model1 = model1;
		this.model2 = model2;
		this.p1 = p1;
		this.p2 = p2;
		this.c1 = c1;
		this.c2 = c2;
	}
	
	/**
     * Display the pokemon capacities of the playing model
     * @param the playing model
     */
	@Override
	protected void displayCap(AbstractModel model) {
		if (model == model1) {
			View.capacitySelection(p1, c1);
		}
		else {
		View.capacitySelection(p2, c2);
		}
	}
	
	/**
     * Display the different actions possible for the playing model
     * @param the playing model
     * @return an int representing the player's choice
     */
	@Override
	protected int chooseAction(AbstractModel model) {
		displayCap(model);
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		while (true) {
			if (str.contentEquals("e")) {
				return 4;
			}
			if (str.contentEquals("c")) {
				return 5;
			}
			if (str.contentEquals("a")) {
				return 6;
			}
			try {
				int res = Integer.valueOf(str);
				if (res >= 0 && res < model.getTeamSize()) {
					return res;
				}
			} catch (Exception e) {

			}
			str = sc.nextLine();
		}
	}
}
