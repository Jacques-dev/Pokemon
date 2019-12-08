package types;

import java.util.ArrayList;

import abstractClass.Type;

public class Steel extends Type{
	@SuppressWarnings("serial")
	private final static ArrayList<Type> strength = new ArrayList<Type>() {{ 
		add(new Rock());
		add(new Ice());
		add(new Fairy());
	}};
	
	@SuppressWarnings("serial")
	private final static ArrayList<Type> weakness = new ArrayList<Type>() {{ 
		add(new Fighting());
		add(new Ground());
		add(new Fire());
	}};
	
	public Steel() {
		super("Steel", weakness, strength);
	}
	
	
}
