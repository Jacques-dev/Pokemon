package types;

import java.util.ArrayList;

import abstractClass.Type;

public class Grass extends Type{
	@SuppressWarnings("serial")
	private final static ArrayList<Type> strength = new ArrayList<Type>() {{ 
		add(new Ground());
		add(new Rock());
		add(new Water());
	}};
	
	@SuppressWarnings("serial")
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
