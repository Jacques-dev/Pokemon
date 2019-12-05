package types;

import java.util.ArrayList;

import system.Type;

public class Water extends Type{
	@SuppressWarnings("serial")
	private final static ArrayList<Type> strength = new ArrayList<Type>() {{ 
		add(new Ground());
		add(new Rock());
		add(new Fire());
	}};
	
	@SuppressWarnings("serial")
	private final static ArrayList<Type> weakness = new ArrayList<Type>() {{ 
		add(new Grass());
		add(new Electric());
	}};
	
	public Water() {
		super("Water", weakness, strength);
	}
	
	
}
