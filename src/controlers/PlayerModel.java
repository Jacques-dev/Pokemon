package controlers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import abstractClass.Capacity;
import abstractClass.Pokemon;
import pokedex.Attacks;
import pokedex.PokedexApparences;
import pokedex.PokedexStats;

public class PlayerModel extends AbstractModel{

	public PlayerModel(ArrayList<Pokemon> team, PokedexApparences pa, PokedexStats ps, Attacks a) {
		this.team = team;
		this.pa = pa;
		this.ps = ps;
		this.a = a;
		this.turn = false;
	}
	
	public PlayerModel(int teamSize) {
		setTeam(teamSize);
	}
	
	@Override
	Pokemon getPokemon() {
		View.selectYourPokemon(team);
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		while (true) {
			try {
				if (Integer.valueOf(str) >= 0 && Integer.valueOf(str) < team.size()) {
					return team.get(Integer.valueOf(str));
				}
				System.out.println("Choose a valid index\n");
				str = sc.nextLine();
			} catch (Exception e) {
				System.out.println("Enter a number\n");
				View.selectYourPokemon(team);
				str = sc.nextLine();
			}
		}
	}

	@Override
	void setTeam(int teamSize) {
		ArrayList<Pokemon> team = new ArrayList<Pokemon>();
		PokedexApparences pa = null;
		try {
			pa = new PokedexApparences();
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		PokedexStats ps = null;
		try {
			ps = new PokedexStats();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		Attacks a = null;
		try {
			a = new Attacks();
		} catch (IOException e) {
			e.printStackTrace();
		}

		Scanner sc = new Scanner(System.in);
		int counter = 0;
		while (counter != teamSize) {

			// Pokemon set
			ps.openPokedex();
			System.out.println("\nMy pokemon : ");
			String str = sc.nextLine();
			Pokemon p = null;
			if (str.equals("0")) {
				this.team = team;
				this.pa = pa;
				this.ps = ps;
				this.a = a;
				this.turn = false;
				return;
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
		this.team = team;
		this.pa = pa;
		this.ps = ps;
		this.a = a;
		this.turn = false;
		
	}

}
