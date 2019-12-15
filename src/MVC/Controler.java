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
		while (counter != Model.getTeamSize()) {
			
			
			
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

}
