package types;

import java.util.ArrayList;

import abstractClass.Type;

public class Poison extends Type{
	@SuppressWarnings("serial")
	private final static ArrayList<Type> strength = new ArrayList<Type>() {{ 
		add(new Grass());
		add(new Fairy());
	}};
	
	@SuppressWarnings("serial")
	private final static ArrayList<Type> weakness = new ArrayList<Type>() {{ 
		add(new Rock());
		add(new Electric());
		add(new Ice());
	}};
	
	public Poison() {
		super("Poison", weakness, strength);
	}
	
	
}
