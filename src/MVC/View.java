package MVC;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import abstractClass.Capacity;
import abstractClass.Pokemon;
import lab.MyMethodes;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class View {
	
	private static void bar() {
		System.out.println("--------------------");
	}
	private static String bar2() {
		return "--------";
	}
	static void space() {
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
	}
	
	public static void start() {
		System.out.println("\n  '*# POKEMON #*'\n");
		System.out.println(bar2()+"MENU"+bar2());
		System.out.println("1 - Select your team");
		System.out.println("2 - Load your team");
		System.out.println("3 - Rules");
		System.out.println("0 - Quit");
		bar();
	}
	
	public static void pokemonSelection() {
		space();
		System.out.println(bar2()+"POKEMON SELECTION"+bar2());
		System.out.println("Press 0 if you want to stop the selection");
	}
	
	@SuppressWarnings("resource")
	public static void printRules() {
		System.out.println(bar2()+"RULES"+bar2());
		bar();
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		System.out.println("Press 0 to escape");
		if (str.equals("0")) {
			return;
		}
	}
	
	public static void menu() {
		space();
		System.out.println(bar2()+"MENU"+bar2());
		System.out.println("1 - Continue");
		System.out.println("2 - Save");
		System.out.println("3 - Rules");
		System.out.println("0 - Quit");
		bar();
	}
	
	public static void save() {
		space();
		System.out.println(bar2()+"SAVE"+bar2());
		space();
	}
	
	public static void choice() {
		space();
		System.out.println(bar2()+"GAME"+bar2());
		System.out.println("1 - Fight");
		System.out.println("2 - Classic Ligue");
		System.out.println("3 - Ligue made in DUT 2");
		System.out.println("4 - Rules");
		System.out.println("0 - Menu");
		bar();
	}
	
	public static void printVersus(Model player1, Model player2) {
		space();
		player1.printTeam("1");
		System.out.println(bar2()+"VERSUS"+bar2());
		player2.printTeam("2");
		MyMethodes.wait(3);
		space();
	}
	public static void capacitySelection(Pokemon p, ArrayList<Capacity> c) {
		System.out.println(bar2()+p.getName()+" turn"+bar2());
		int i = 0;
		for (Capacity x : c) {
			System.out.println(i+" - "+x.getName());
			i++;
		}
		bar();
		System.out.println("c - change pokemon");
		//System.out.println("a - oneshot");
		System.out.println("e - escape (loose)");
	}
	
	public static void printLife(Pokemon p, int x) {
		space();
		System.out.println(p.getName()+" has lost "+x+"hp");
		System.out.println(p.getName()+" has now "+p.getLife());
	}
	
	public static void selectYourPokemon(ArrayList<Pokemon> team) {
		int x = 0;
		space();
		System.out.println(bar2()+"Wich Pokemon will have to fight ???"+bar2());
		for (Pokemon p : team) {
			System.out.println(x + " - " + p.getName());
			x++;
		}
		bar();
	}
	
}
