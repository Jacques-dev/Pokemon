package types;

import java.util.ArrayList;
import java.util.Objects;

import abstractClass.Type;

@SuppressWarnings("serial")
public class Grass extends Type{
	
	private final static ArrayList<Type> strength = new ArrayList<Type>() {{ 
		add(new Ground());
		add(new Rock());
		add(new Water());
	}};
	
	private final static ArrayList<Type> weakness = new ArrayList<Type>() {{ 
		add(new Flying());
		add(new Poison());
		add(new Bug());
		add(new Fire());
		add(new Ice());
	}};
	
	public Grass() {
		super("Grass", weakness, strength);
	}
}
