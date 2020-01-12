package controlers;

import java.util.ArrayList;
import java.util.Scanner;

import abstractClass.Capacity;
import abstractClass.Pokemon;

public class AIFight extends AbstractFight {

	public AIFight(PlayerModel model1, AIModel model2, Pokemon p1, Pokemon p2, ArrayList<Capacity> c1, ArrayList<Capacity> c2) {
		this.model1 = model1;
		this.model2 = model2;
		this.p1 = p1;
		this.p2 = p2;
		this.c1 = c1;
		this.c2 = c2;
	}

	@Override
	protected void displayCap(AbstractModel model) {
		if (model == model1) {
			View.capacitySelection(p1, c1);
		}
	}

	@Override
	int chooseAction(AbstractModel model) {
		if (model == model1) {
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
					if (!(res < 0 || res > getModelCapacities(model).size())) {
						return res;
					}
				} catch (Exception e) {

				}
				str = sc.nextLine();
			}
		}
		else {
			int randomInt = 0 + (int) (Math.random() * ((c2.size() - 0)));
			return randomInt;
		}
	}
}
