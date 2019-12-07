package pokedex;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Pokedex {
	
	private final List<ArrayList> pokedex;
	
	public Pokedex() throws IOException {
		this.pokedex = read();
	}

	public List<ArrayList> read() throws IOException {
		BufferedReader lecteurAvecBuffer = null;
	    String ligne;
	    
	    try {
	    	lecteurAvecBuffer = new BufferedReader(new FileReader("pokedex.txt"));
        }
	    catch(FileNotFoundException exc) {
	    	System.out.println("Erreur d'ouverture");
	    }
	    
	    ArrayList<String> x = new ArrayList<>();
	    
		List<ArrayList> test = new ArrayList<>();
	    
	    
	    while ((ligne = lecteurAvecBuffer.readLine()) != null) {
	    	x = new ArrayList<>();
	    	String str[] =ligne.split(",");
	    	for (int i = 0 ; i != str.length ; i++) {
	    		
	    		x.add(str[i]);
	    		
	    		
	    	}
	    	test.add(x);
	    	
	    }
	    
	    lecteurAvecBuffer.close();
	    return test;
	}
	
	public List<ArrayList> openPokedex() {
		return pokedex;
	}
	
	public void checkPokemon(String name) {
		for (ArrayList array : pokedex) {
			for (int i = 0 ; i != array.size() ; i++) {
				
				if (name.equals(array.get(1))) {
					System.out.println(array);
					return;
				}
			}
		}
		System.out.println("This "+name+" is unknown, sorry..");
	}
	
}
