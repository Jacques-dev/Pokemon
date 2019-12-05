package types;

import java.util.ArrayList;

import system.Type;

public class Dark extends Type{
	@SuppressWarnings("serial")
	private final static ArrayList<Type> strength = new ArrayList<Type>() {{ 
		add(new Ghost());
		add(new Psychic());
	}};
	
	@SuppressWarnings("serial")
	private final static ArrayList<Type> weakness = new ArrayList<Type>() {{ 
		add(new Flying());
		add(new Bug());
		add(new Fairy());
	}};
	
	public Dark() {
		super("Dark", weakness, strength);
	}
	
	
}
