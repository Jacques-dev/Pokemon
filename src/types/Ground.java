package types;

import java.util.ArrayList;

import system.Type;

public class Ground extends Type{
	@SuppressWarnings("serial")
	private final static ArrayList<Type> strength = new ArrayList<Type>() {{ 
		add(new Poison());
		add(new Rock());
		add(new Steel());
		add(new Fire());
		add(new Electric());
	}};
	
	@SuppressWarnings("serial")
	private final static ArrayList<Type> weakness = new ArrayList<Type>() {{ 
		add(new Water());
		add(new Grass());
		add(new Ice());
	}};
	
	public Ground() {
		super("Ground", weakness, strength);
	}
	
	
}
