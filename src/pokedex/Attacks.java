package pokedex;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import abstractClass.Capacity;
import abstractClass.Pokemon;
import abstractClass.Type;
import capacityType.CapacityType;
import lab.MyMethodes;


@SuppressWarnings("serial")
public class Attacks  implements Serializable{
	
	private final List<Capacity> pokedex;
	
	public Attacks() throws IOException {
		this.pokedex = read();
	}

	public List<Capacity> read() throws IOException {
		BufferedReader lecteurAvecBuffer = null;
	    String ligne;
	    
	    try {
	    	lecteurAvecBuffer = new BufferedReader(new FileReader("attacks.txt"));
        }
	    catch(FileNotFoundException exc) {
	    	System.out.println("Erreur d'ouverture");
	    }
	    
	    List<Capacity> test = new ArrayList<>();
	    Capacity cap = null;
	    
	    String name = null;
		Type type = null; //exemple : new Electric()
		int power = 0; //15 - 300
		int pp = 0;
		int accuracy = 0; //0 - 100
		CapacityType captype = null; //exemple : Special
	    
	    while ((ligne = lecteurAvecBuffer.readLine()) != null) {
	    	String str[] =ligne.split(",");
	    	for (int i = 0 ; i != str.length ; i++) {
	    		
	    		switch (i) {
		    		case 1:
		    			name = str[i];
		    			break;
		    		case 2:
		    			type = MyMethodes.stringToType(str[i]);
		    			break;
		    		case 3:
		    			if (str[i].equals("")) {
		    				power = 0;
		    				break;
		    			}
		    			power = MyMethodes.roundUp(Integer.valueOf(str[i]));
		    			break;
		    		case 4:
		    			if (str[i].equals("")) {
		    				pp = 0;
		    				break;
		    			}
		    			pp = Integer.valueOf(str[i]);
		    			break;
		    		case 5:
		    			if (str[i].equals("")) {
		    				accuracy = 0;
		    				break;
		    			}
		    			accuracy = Integer.valueOf(str[i]);
		    			break;
		    		case 6:
		    			captype = MyMethodes.stringToClassType(str[i]);
		    			break;
	    		}
	    	}
	    	
	    	cap = new Capacity(name,type,power,pp,accuracy,captype);
	    	test.add(cap);
	    }
	    
	    lecteurAvecBuffer.close();
	    return test;
	}
	
	public boolean checkAttack(String name) {
		for (Capacity cap : pokedex) {
				
			if (name.equals(cap.getName())) {
				return true;
			}
		}
		System.out.println("This "+name+" is unknown, sorry..");
		return false;
	}
	
	public void openPokedex(List<Type> types) {
		for (Capacity cap : pokedex) {
			if (types.contains(cap.getType())) {
				System.out.println(cap.getName());
			}
		}
	}

	public Capacity setCapacity(String str) {
		for (Capacity c : pokedex) {
			
			if (str.equals(c.getName())) {
				return c;
			}
		}
		throw new IllegalArgumentException("This capacity deosn't exist !!");
	}
	
}
