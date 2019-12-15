package MVC;

import java.util.Scanner;

import lab.TimeControl;

public class Controler {

	public static void start() {
		View.start();
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		switch (str) {
		case "1":
			View.pokemonSelection();
			TimeControl.wait(3);
			Model.setTeam();
			break;
		case "2":
			Model.reloadTeam();
			break;
		case "3":
			View.printRules();
			break;
		case "0":
			System.exit(0);
		}
	}

}
