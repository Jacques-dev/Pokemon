package types;

import java.util.ArrayList;

import abstractClass.Type;

public class Fairy extends Type{
	@SuppressWarnings("serial")
	private final static ArrayList<Type> strength = new ArrayList<Type>() {{ 
		add(new Fighting());
		add(new Dragon());
		add(new Dark());
	}};
	
	@SuppressWarnings("serial")
	private final static ArrayList<Type> weakness = new ArrayList<Type>() {{ 
		add(new Poison());
		add(new Steel());
	}};
	
	public Fairy() {
		super("Fairy", weakness, strength);
	}
	
	
}
