package MVC;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import abstractClass.Capacity;
import abstractClass.Pokemon;
import lab.MyMethodes;
import pokedex.Attacks;
import pokedex.PokedexApparences;
import pokedex.PokedexStats;

public class Controler {

	/**
     * Display the first menu and respond to the user's entries
     * @return Model created by the user or restored from a save
     */
	@SuppressWarnings("resource")
	public Model start() throws IOException {
		View.start();
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		while(str != "1" || str != "2") {
		switch (str) {
		case "1":
			View.pokemonSelection();
			MyMethodes.wait(2);
			Model data = setTeam();
			return data;
		case "2":
			try {
				return read();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		case "3":
			PokedexApparences x = new PokedexApparences();
			x.openPokedex();
			break;
		case "4":
			View.printRules();
			break;			
		case "0":
			System.exit(0);
		}
		View.start();
		str = sc.nextLine();
	}
		return null;
	}

	/**
     * Display all the pokemons and the capacities they're able to learn
     * @return Model containing the pokemon chosen by the user and their capacities
     */
	@SuppressWarnings("resource")
	public Model setTeam() throws IOException {

		ArrayList<Pokemon> team = new ArrayList<Pokemon>();
		PokedexApparences pa = new PokedexApparences();
		PokedexStats ps = new PokedexStats();
		Attacks a = new Attacks();

		Scanner sc = new Scanner(System.in);
		int counter = 0;
		while (counter != Model.getSIZE()) {

			// Pokemon set
			ps.openPokedex();
			System.out.println("\nMy pokemon : ");
			String str = sc.nextLine();
			Pokemon p = null;
			if (str.equals("0")) {
				return new Model(team, pa, ps, a);
			}
			if (ps.checkPokemon(str)) {
				p = ps.stringToPokemon(str);
			}
			
			if (p != null) {
				
				// Capacity set
				for (int i = 0; i != 4; i++) {
	
					sc = new Scanner(System.in);
					a.openPokedex(p.getTypes());
					System.out.println("\n" + p.getName() + " - capacities : ");
					str = sc.nextLine();
					Capacity c = null;
					if (str.equals("0")) {
						break;
					}
					if (a.checkAttack(str)) {
						c = a.setCapacity(str);
						p.learn(c);
					}
				}
				team.add(p);
	
				counter++;
			}

		}
		return new Model(team, pa, ps, a);

	}

	/**
     * Creates a new model containing random pokemons
     * @param int "teamSize", the number of pokemon you want to create 
     * @return Model containing the pokemon created and their capacities
     */
	@SuppressWarnings("resource")
	public Model setEnnemy(int teamSize) throws IOException {

		if (teamSize < 1 || teamSize > 6) {
			throw new IllegalArgumentException("Parameter should be between 1 and 6");
		}
		ArrayList<Pokemon> team = new ArrayList<Pokemon>();
		PokedexApparences pa = new PokedexApparences();
		PokedexStats ps = new PokedexStats();
		Attacks a = new Attacks();

		int counter = 0;
		while (counter != teamSize) {

			// Cr�er un pok�mon al�atoi	    				System.out.println(number);rement
			Pokemon p = null;
			int nombreAleatoire = 1 + (int) (Math.random() * ((807 - 1) + 1));
			p = ps.intToPokemon(nombreAleatoire);
			// R�cup�rez 4 capacit�s al�atoirement
			for (int i = 0; i != 4; i++) {

				Capacity c = null;
				nombreAleatoire = 1 + (int) (Math.random() * ((728 - 1) + 1));
				c = a.setCapacity(nombreAleatoire);
				p.learn(c);
			}
			team.add(p);
			counter++;

		}
		return new Model(team, pa, ps, a);

	}

	/**
     * 
     * @param Model "data", the model you want to save in the "Data.ser" file
     */
	public void save(Model data) throws IOException {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Data.ser"))) {
			oos.writeObject(data);
		} catch (IOException e) {
			e.printStackTrace();

		}
	}

	/**
     * 
     * @return Model contained in the "Data.ser" file
     */
	public Model read() throws ClassNotFoundException, IOException {

		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Data.ser"))) {

			Model x = (Model) ois.readObject();

			return x;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
     * Display the post-selection menu and respond to the user's entries
     * @param Model "data" created by the user or restored from a save
     */
	@SuppressWarnings("resource")
	public void menu(Model data) {
		View.menu();
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		switch (str) {
		case "1":
			break;
		case "2":
			try {
				save(data);
				View.save();
				MyMethodes.wait(2);

			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		case "3":
			View.printRules();
			break;
		case "0":
			View.space();
			System.exit(0);
		}
	}

	/**
     * Display the pre-fight menu and respond to the user's entries
     * @param Model "data" created by the user or restored from a save
     * @return int "choice" representing the user's choice
     */
	public int choice(Model data) {
		View.choice();
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		while (str != "1" || str != "2" || str != "3" || str !="0") {
		switch (str) {
		case "1":
			return 1;
		case "2":
			return 2;
		case "3":
			return 3;
		case "4":
			View.printRules();
			break;
		case "0":
			menu(data);
		}

		View.choice();
		str = sc.nextLine();
	}

		return 0;
	}

	/**
     * Creates a match between two models
     * @param 2 Model representing the two teams
     */
	public void versus(Model player1, Model player2) {
		Pokemon p1 = player1.getPokemon();
		ArrayList<Capacity> c1 = p1.getCapacities();

		Pokemon p2 = player2.getPokemon();
		ArrayList<Capacity> c2 = p2.getCapacities();
		while (true) {
			View.space();

			switch (fight(p1, c1, p2, c2, player1, player2)) {
			case 0:
				return;
			case 1: // pokemon player1 died
				player1.getTeam().remove(p1);
				if (player1.getTeam().size()>0) {
				p1 = player1.getPokemon();
				c1 = p1.getCapacities();	
				}
				break;
			case 2: // pokemon player2 died
				player2.getTeam().remove(p2);
				if (player2.getTeam().size()>0) {
				p2 = player2.getPokemon();
				c2 = p2.getCapacities();	
				}
				break;
			case 3:
				p1 = player1.getPokemon();
				c1 = p1.getCapacities();
				break;
			case 4:
				p2 = player2.getPokemon();
				c2 = p2.getCapacities();
				break;
			}

			if (player1.getTeam().size() == 0) {
				System.out.println("Player 1 can't fight anymore !");
				System.out.println("Player 2 won !");
				MyMethodes.wait(3);
				return;
			}
			if (player2.getTeam().size() == 0) {
				System.out.println("Player 2 can't fight anymore !");
				System.out.println("Player 1 won !");
				MyMethodes.wait(3);
				return;
			}

			System.out.println("# New fight #");
		}

	}

	/**
     * Manage the in-fight display and the user's actions
     * @param Pokemon "p1", ArrayList<Capacity> "capacities1, Pokemon "p2", ArrayList<Capacity> "capacities2", Model "player1", Model "player2"
     * @return int representing differents in-fight events
     */
	@SuppressWarnings("resource")
	public int fight(Pokemon p1, ArrayList<Capacity> capacities1, Pokemon p2, ArrayList<Capacity> capacities2,
			Model player1, Model player2) {

		boolean boolean_player1;
		if (p1.getSpeed() > p2.getSpeed()) {
			boolean_player1 = true;
		} else {
			boolean_player1 = false;
		}

		while (true) {
			if (boolean_player1) {
				View.capacitySelection(p1, capacities1);
			} else {
				View.capacitySelection(p2, capacities2);
			}

			Scanner sc = new Scanner(System.in);
			String str = sc.nextLine();
			if (str.equals("e")) {
				if (boolean_player1) {
					System.out.println("Player 1 gave up !");
					System.out.println("Player 2 won !");
				} else {
					System.out.println("Player 2 gave up !");
					System.out.println("Player 1 won !");
				}
				MyMethodes.wait(3);
				return 0;
			}
			if (str.contentEquals("c")) {
				if (boolean_player1) {
					return 3;
				} else {
					return 4;
				}

			}
			if (str.contentEquals("a")) {
				if (boolean_player1) {
					p2 = oneshot(p2);
				} else {
					p1 = oneshot(p1);
				}
			} if (!(str.contentEquals("e") || str.contentEquals("a") || str.contentEquals("c"))) {
				Capacity c = capacities1.get(Integer.valueOf(str));

				if (boolean_player1) {
					p2 = action(c, p1, p2); // p1 attack with c on p2
				} else {
					p1 = action(c, p2, p1); // p2 attack with c on p1
				}
			}

			if (str.contentEquals("a")) {
				if (boolean_player1) {
					p2 = oneshot(p2);
				} else {
					p1 = oneshot(p1);
				}
			} if (!(str.contentEquals("e") || str.contentEquals("a") || str.contentEquals("c"))) {
				Capacity c = capacities1.get(Integer.valueOf(str));

				if (boolean_player1) {
					p2 = action(c, p1, p2); // p1 attack with c on p2
				} else {
					p1 = action(c, p2, p1); // p2 attack with c on p1
				}
			}

			if (p1.getLife() <= 0) {// p1 loose
				return 1;
			}
			if (p2.getLife() <= 0) {// p2 loose
				return 2;
			}
			if (boolean_player1) {
				boolean_player1 = false;
			} else {
				boolean_player1 = true;
			}
		}
	}

	/**
     * Manage damages caused by a capacity on a pokemon
     * @param Capacity "c", Pokemon "p_attack" the pokemon which attacks, Pokemon "p_defend" the pokemon attacked
     * @return Pokemon p_defend with the hp he got left after being attacked
     */
	public Pokemon action(Capacity c, Pokemon p_attack, Pokemon p_defend) {
		int x = (int) ((((p_attack.getLevel() * 0.4) + 2) * p_attack.getDamages() * c.getPower())
				/ (p_defend.getDefenses() * 50));
		p_defend.setLife(x);

		View.printLife(p_defend, x);

		return p_defend;
	}

	/**
     * Method for dev purposes only, allow to one shot the opponent pokemon
     * @param Pokemon "p_defend" the pokemon attacked
     * @return Pokemon p_defend with the hp he got left after being attacked
     */
	public Pokemon oneshot(Pokemon p_defend) {
		p_defend.setLife(999);

		View.printLife(p_defend, 999);

		return p_defend;
	}

}
