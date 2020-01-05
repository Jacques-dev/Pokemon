package pokedex;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import abstractClass.Pokemon;
import abstractClass.Type;
import lab.MyMethodes;

@SuppressWarnings("serial")
public class PokedexStats implements Serializable{
	private final List<Pokemon> pokedex;
	
	public PokedexStats() throws IOException {
		this.pokedex = read();
	}

	
	/**
     * 
     * @return List<Pokemon> containing all the pokemon attributes in the pokedexstats.txt file
     */
	public List<Pokemon> read() throws IOException {
		BufferedReader lecteurAvecBuffer = null;
	    String ligne;
	    
	    try {
	    	lecteurAvecBuffer = new BufferedReader(new FileReader("pokedexstats.txt"));
        }
	    catch(FileNotFoundException exc) {
	    	System.out.println("Erreur d'ouverture");
	    }
	    
	    List<Pokemon> test = new ArrayList<>();
	    Pokemon p = null;
	    
	    int number = 0;
	    String name = null;
		List<Type> types = new ArrayList<Type>();
		int life = 0;
		int damages = 0;
		int defenses = 0;
		int specialAttack = 0;
		int specialDefense = 0;
		int speed = 0;
	    
	    while ((ligne = lecteurAvecBuffer.readLine()) != null) {
	    	String str[] =ligne.split(",");
	    	for (int i = 0 ; i != str.length ; i++) {
	    		
	    		switch (i) {
	    			case 0:
	    				number = Integer.valueOf(str[i]);
	    				System.out.println(number);
	    				break;
		    		case 1:
		    			name = str[i];
		    			break;
		    		case 2:
		    			types.add(MyMethodes.stringToType(str[i]));
		    			break;
		    		case 3:
		    			if (str[i].equals("")) {
		    				break;
		    			} else {
			    			types.add(MyMethodes.stringToType(str[i]));
			    			break;
		    			}
		    		case 5:
		    			life = Integer.valueOf(str[i]);
		    			break;
		    		case 6:
		    			damages = Integer.valueOf(str[i]);
		    			break;
		    		case 7:
		    			defenses = Integer.valueOf(str[i]);
		    			break;
		    		case 8:
		    			specialAttack = Integer.valueOf(str[i]);
		    			break;
		    		case 9:
		    			specialDefense = Integer.valueOf(str[i]);
		    			break;
		    		case 10:
		    			speed = Integer.valueOf(str[i]);
		    			break;
	    		}
	    		p = new Pokemon(number,name,types,life,damages, defenses, specialAttack, specialDefense, speed);
	    	}
	    	
	    	
	    	test.add(p);
	    	types = new ArrayList<Type>();
	    }
	    
	    lecteurAvecBuffer.close();
	    return test;
	}
	
	/**
     * Verify if a pokemon is contained in the pokedexstats.txt file
     * @param String "name" representing a pokemon name
     * @return true if the pokemon entered is known in the pokedexstats.txt file
     */
	public boolean checkPokemon(String name) {
		for (Pokemon p : pokedex) {
			
			if (name.equals(p.getName())) {
				return true;
			}
		}
		System.out.println("This "+name+" is unknown, sorry..");
		return false;
	}
	
	/**
     * Display all the pokemons in the pokedexapparences.txt file and their attributes
     */
	public void openPokedex() {
		for (Pokemon p : pokedex) {
			System.out.println(p.getName());
		}
	}

	/**
     * 
     * @param String "str" the name of the pokemon we want to return
     * @return Pokemon having the same name as str parameter
     */
	public Pokemon stringToPokemon(String str) {
		for (Pokemon p : pokedex) {
			
			if (str.equals(p.getName())) {
				return p;
			}
		}
		throw new IllegalArgumentException("This pokemon deosn't exist !!");
	}

	/**
     * 
     * @param int "number" the number of the pokemon we want to return
     * @return Pokemon having the number "number"
     */
	public Pokemon intToPokemon(int number) {
		for (Pokemon p : pokedex) {
			
			if (number == p.getNumber()) {
				return p;
			}
		}
		throw new IllegalArgumentException("Pokemon number " + number + " doesn't exist !!");
	}
	
	@Override
	public boolean equals(Object o) {
		if (!(o instanceof PokedexStats)) {return false;}
		PokedexStats x = (PokedexStats) o;
		return pokedex.equals(x.pokedex);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(pokedex);
	}
	
}
