package pokedex;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@SuppressWarnings("serial")
public class PokedexApparences  implements Serializable{
	
	private final List<ArrayList<String>> pokedex;
	
	public PokedexApparences() throws IOException {
		this.pokedex = read();
	}

	public List<ArrayList<String>> read() throws IOException {
		BufferedReader lecteurAvecBuffer = null;
	    String ligne;
	    
	    try {
	    	lecteurAvecBuffer = new BufferedReader(new FileReader("pokedexapparences.txt"));
        }
	    catch(FileNotFoundException exc) {
	    	System.out.println("Erreur d'ouverture");
	    }
	    
	    ArrayList<String> x = new ArrayList<>();
	    
		List<ArrayList<String>> test = new ArrayList<>();
	    
	    
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
	
	public boolean checkPokemon(String name) {
		for (ArrayList<String> array : pokedex) {
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
			str.append(pokedex.get(i).get(3)+", ");
			str.append(pokedex.get(i).get(4)+", ");
			str.append(pokedex.get(i).get(5)+", ");
			try {
				str.append(pokedex.get(i).get(5));
			} catch (Exception e) {
				
			}
			str.append("]\n");
		}
		System.out.println(str.toString());
	}
	
	public void print(ArrayList<String> a) {
		System.out.println("id : "+a.get(0));
		System.out.println("name : "+a.get(1));
		System.out.println("height : "+a.get(3));
		System.out.println("weight : "+a.get(4));
		System.out.println("type1 : "+a.get(5));
		try {
			System.out.println("type2 : "+a.get(6));
		} catch (Exception e) {
			
		}
	}
	
}
