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
	
	
	@SuppressWarnings("resource")
	public Model start() throws IOException {
		View.start();
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
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
			View.printRules();
			break;
		case "0":
			System.exit(0);
		}
		
		return null;
	}
	
	@SuppressWarnings("resource")
	public Model setTeam() throws IOException {
		
		Map<Pokemon,ArrayList<Capacity>> team = new HashMap<Pokemon,ArrayList<Capacity>>();
		PokedexApparences pa = new PokedexApparences();
		PokedexStats ps = new PokedexStats();
		Attacks a = new Attacks();
		
		ArrayList<Capacity> capacities = new ArrayList<Capacity>();
		
		Scanner sc = new Scanner(System.in);
		int counter = 0;
		while (counter != Model.getSIZE()) {
			
			
			
			//Pokemon set
			ps.openPokedex();
			System.out.println("\nMy pokemon : ");
			String str = sc.nextLine();
			Pokemon p = null;
			if (str.equals("0")) {
				return new Model(team,pa,ps,a);
			}
			if (ps.checkPokemon(str)) {
				p = ps.stringToPokemon(str);
			}
			
			
				
				
			//Capacity set
			for (int i = 0 ; i != 4 ; i++) { 
			
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
				}
				capacities.add(c);
			}
			
			team.put(p,capacities);
				
			capacities = new ArrayList<Capacity>();
			
			counter++;
			
		}
		return new Model(team,pa,ps,a);
		
	}
	
	public void save(Model data) throws IOException {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Data.ser"))) {
            oos.writeObject(data);
        }
        catch (IOException e) {
            e.printStackTrace();
            
        }
	}
	
	public Model read() throws ClassNotFoundException, IOException {
		
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Data.ser"))) {
			
			Model x = (Model) ois.readObject();
			
			return x;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

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
	
	public boolean choice(Model data) {
		View.choice();
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		switch (str) {
			case "1":
				return true;
			case "2":
				View.printRules();
				break;
			case "0":
				menu(data);
		}
		return false;
	}
	
	public void versus(Model player1, Model player2) {
		while (player1.getTeamSize() != 0 || player2.getTeamSize() != 0) {
			Pokemon p1 = player1.getPokemon();
			ArrayList<Capacity> c1 = player1.getCapacities();
			
			Pokemon p2 = player1.getPokemon();
			ArrayList<Capacity> c2 = player1.getCapacities();
			
			if (fight(p1,c1,p2,c2)) {
				player1.getTeam().remove(p1);
			} else {
				player2.getTeam().remove(p2);
			}
		}
	}
	
	@SuppressWarnings("resource")
	public boolean fight(Pokemon p1, ArrayList<Capacity> capacities1, Pokemon p2, ArrayList<Capacity> capacities2) {
		
		boolean player1;
		if (p1.getSpeed() > p2.getSpeed()) {
			player1 = true;
		} else {
			player1 = false;
		}
		
		while (true) {
		
			if (player1) {
				View.capacitySelection(p1, capacities1);
			} else {
				View.capacitySelection(p2, capacities2);
			}
			
			Scanner sc = new Scanner(System.in);
			String str = sc.nextLine();
			if (str.equals("e")) {
				//escape
			}
			Capacity c = capacities1.get(Integer.valueOf(str));
			
			
			if (player1) {
				p2 = action(c,p1);
			} else {
				p1 = action(c,p2);
			}
			
			
			if (p2.getLife()<=0) {
				return true;
			}
			if (p1.getLife()<=0) {
				return false;
			}
			
			player1 = !player1;
		}
	}
	
	public Pokemon action(Capacity c, Pokemon p) {
		int x = (int) ((((p.getLevel()*0.4)+2)*p.getDamages()*c.getPower())/(p.getDefenses()*50));
		p.setLife(x);
		
		View.printLife(p,x);
		
		return p;
	}

}
