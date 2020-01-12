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
	
	/**
     * Display the first menu
     */
	public static void start() {
		System.out.println("\n  '*# POKEMON #*'\n");
		System.out.println(bar2()+"MENU"+bar2());
		System.out.println("1 - Select your team");
		System.out.println("2 - Load your team");
		System.out.println("3 - Pokedex");
		System.out.println("4 - Rules");
		System.out.println("0 - Quit");
		bar();
	}
	
	public static void pokemonSelection() {
		space();
		System.out.println(bar2()+"POKEMON SELECTION"+bar2());
		System.out.println("Press 0 if you want to stop the selection");
	}
	
	/**
     * Display the rules of the game
     */
	@SuppressWarnings("resource")
	public static void printRules() {
		System.out.println(bar2()+"RULES"+bar2());
		bar();
		return;
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
	
	/**
     * Display the post-selection menu
     */
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
	
	/**
     * Display the versus screen
     * @param Model "player1", Model "player 2"
     */
	public static void printVersus(AbstractModel player1, AbstractModel player2) {
		space();
		player1.printTeam("1");
		System.out.println(bar2()+"VERSUS"+bar2());
		player2.printTeam("2");
		MyMethodes.wait(3);
		space();
	}
	
	/**
     * Display in-fight possible actions
     * @param Pokemon "p", ArrayList<Capacity> "c"
     */
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
	
	/**
     * Display the damages taken by a pokemon and his hp
     * @param Pokemon "p", int "x" representing the damages taken
     */
	public static void printLife(Pokemon p, int x) {
		space();
		System.out.println(p.getName()+" has lost "+x+"hp");
		System.out.println(p.getName()+" has now "+p.getLife());
	}
	
	/**
     * Display the team pokemons selection
     * @param ArrayList<Pokemon> team all the pokemons of a Model
     */
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
