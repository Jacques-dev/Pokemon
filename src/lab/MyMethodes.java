package lab;

import abstractClass.Type;
import capacityType.CapacityType;
import types.Bug;
import types.Dark;
import types.Dragon;
import types.Electric;
import types.Fairy;
import types.Fighting;
import types.Fire;
import types.Flying;
import types.Ghost;
import types.Grass;
import types.Ground;
import types.Ice;
import types.Normal;
import types.Poison;
import types.Psychic;
import types.Rock;
import types.Steel;
import types.Water;

public class MyMethodes {
	
	public static void wait(int x) {
		try {
		   Thread.sleep(x*1000) ;
		}  catch (InterruptedException e) {
		    // gestion de l'erreur
		}
	}
	
	public static Type stringToType(String s) {
		if (s.equals("fighting") || s.equals("Fighting")) {
			return new Fighting();
		}
		
		if (s.equals("bug") || s.equals("Bug")) {
			return new Bug();
		}
		
		if (s.equals("dark") || s.equals("Dark")) {
			return new Dark();
		}
		
		if (s.equals("dragon") || s.equals("Dragon")) {
			return new Dragon();
		}
		
		if (s.equals("electric") || s.equals("Electric")) {
			return new Electric();
		}
		
		if (s.equals("fairy") || s.equals("Fairy")) {
			return new Fairy();
		}
		
		if (s.equals("ghost") || s.equals("Ghost")) {
			return new Ghost();
		}
		
		if (s.equals("grass") || s.equals("Grass")) {
			return new Grass();
		}
		
		if (s.equals("ground") || s.equals("Ground")) {
			return new Ground();
		}
		
		if (s.equals("ice") || s.equals("Ice")) {
			return new Ice();
		}
		
		if (s.equals("normal") || s.equals("Normal")) {
			return new Normal();
		}
		
		if (s.equals("poison") || s.equals("Poison")) {
			return new Poison();
		}
		
		if (s.equals("psychic") || s.equals("Psychic")) {
			return new Psychic();
		}
		
		if (s.equals("rock") || s.equals("Rock")) {
			return new Rock();
		}
		
		if (s.equals("steel") || s.equals("Steel")) {
			return new Steel();
		}
		
		if (s.equals("water") || s.equals("Water")) {
			return new Water();
		}
		
		if (s.equals("fire") || s.equals("Fire")) {
			return new Fire();
		}
		
		if (s.equals("flying") || s.equals("Flying")) {
			return new Flying();
		}
				
		throw new IllegalArgumentException ("!!! This type doesn't exist !!!");	
	}
	
	public static CapacityType stringToClassType(String s) {
		switch (s) {
			case "physical":
				return CapacityType.Physical;
			case "special":
				return CapacityType.Special;
			case "statut":
				return CapacityType.Statut;
		}
		throw new IllegalArgumentException ("!!! This class_type doesn't exist !!!");	
	}
	
	public static int roundUp(int x) {
		switch (x%5) {
			case 1:
				return x-1;
			case 2:
				return x-2;
			case 3:
				return x-3;
			case 4:
				return x+1;
		}
		return x;
	}
	
	
}
