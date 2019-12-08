package types;

import java.util.ArrayList;

import abstractClass.Type;

public class Rock extends Type{
	@SuppressWarnings("serial")
	private final static ArrayList<Type> strength = new ArrayList<Type>() {{ 
		add(new Flying());
		add(new Bug());
		add(new Fire());
		add(new Ice());
	}};
	
	@SuppressWarnings("serial")
	private final static ArrayList<Type> weakness = new ArrayList<Type>() {{ 
		add(new Fighting());
		add(new Ground());
		add(new Steel());
		add(new Water());
		add(new Grass());
	}};
	
	public Rock() {
		super("Rock", weakness, strength);
	}
	
	
}
