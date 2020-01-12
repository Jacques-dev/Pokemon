package MVC;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import abstractClass.Capacity;
import abstractClass.Pokemon;
import pokedex.Attacks;
import pokedex.PokedexApparences;
import pokedex.PokedexStats;

public class AIModel extends AbstractModel{
	
	public AIModel(int teamsize) {
		setTeam(teamsize);
	}
	
	@Override
	Pokemon getPokemon() {
		@SuppressWarnings("resource")
		int randomInt = 0 + (int) (Math.random() * ((team.size() - 0)));
		return team.get(randomInt);
	}

	@Override
	void setTeam(int teamSize) {
		if (teamSize < 1 || teamSize > 6) {
			throw new IllegalArgumentException("Parameter should be between 1 and 6");
		}
		ArrayList<Pokemon> team = new ArrayList<Pokemon>();
		PokedexApparences pa = null;
		try {
			pa = new PokedexApparences();
		} catch (IOException e) {
			e.printStackTrace();
		}
		PokedexStats ps = null;
		try {
			ps = new PokedexStats();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Attacks a = null;
		try {
			a = new Attacks();
		} catch (IOException e) {
			e.printStackTrace();
		}

		int counter = 0;
		while (counter != teamSize) {

			Pokemon p = null;
			int nombreAleatoire = 1 + (int) (Math.random() * ((807 - 1) + 1));
			p = ps.intToPokemon(nombreAleatoire);
			for (int i = 0; i != 4; i++) {

				Capacity c = null;
				nombreAleatoire = 1 + (int) (Math.random() * ((728 - 1) + 1));
				c = a.setCapacity(nombreAleatoire);
				p.learn(c);
			}
			team.add(p);
			counter++;

		}
		this.team = team;
		this.pa = pa;
		this.ps = ps;
		this.a = a;
		this.turn = false;
	}

}
