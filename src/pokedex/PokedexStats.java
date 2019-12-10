package pokedex;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PokedexStats {
private final List<ArrayList> pokedex;
	
	public PokedexStats() throws IOException {
		this.pokedex = read();
	}

	public List<ArrayList> read() throws IOException {
		BufferedReader lecteurAvecBuffer = null;
	    String ligne;
	    
	    try {
	    	lecteurAvecBuffer = new BufferedReader(new FileReader("pokedexstats.txt"));
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
	
	public Boolean checkPokemon(String name) {
		for (ArrayList array : pokedex) {
			for (int i = 0 ; i != array.size() ; i++) {
				
				if (name.equals(array.get(1))) {
					print(array);
					return true;
				}
			}
		}
		System.out.println("This "+name+" is unknown, sorry..");
		return false;
	}
	
	public void openPokedex() {
		StringBuilder str = new StringBuilder("[");
		for (int i = 0 ; i != pokedex.size() ; i++) {
			str.append(pokedex.get(i).get(0)+", ");
			str.append(pokedex.get(i).get(1)+", ");
			str.append(pokedex.get(i).get(2)+", ");
			if (pokedex.get(i).size() == 13) {
				System.out.println(pokedex.get(i).get(3)+", ");
			}
			str.append(pokedex.get(i).get(4)+", ");
			str.append(pokedex.get(i).get(5)+", ");
			str.append(pokedex.get(i).get(6)+", ");
			str.append(pokedex.get(i).get(7)+", ");
			str.append(pokedex.get(i).get(8)+", ");
			str.append(pokedex.get(i).get(9));
			str.append("]\n");
		}
		System.out.println(str.toString());
	}
	//#,Name,Type 1,Type 2,Total,HP,Attack,Defense,Sp. Atk,Sp. Def,Speed,Generation,Legendary
	public void print(ArrayList a) {
		
		System.out.println("id : "+a.get(0));
		System.out.println("name : "+a.get(1));
		System.out.println("type1 : "+a.get(2));
		System.out.println("type2 : "+a.get(3));
		System.out.println("life : "+a.get(4));
		System.out.println("attack : "+a.get(5));
		System.out.println("defense : "+a.get(6));
		System.out.println("super attack : "+a.get(7));
		System.out.println("super defense : "+a.get(8));
		System.out.println("speed : "+a.get(9));
	}
	
}
