package types;

import java.util.ArrayList;

import system.Type;

public class Bug extends Type{
	@SuppressWarnings("serial")
	private final static ArrayList<Type> strength = new ArrayList<Type>() {{ 
		add(new Grass());
		add(new Psychic());
		add(new Dark());
	}};
	
	@SuppressWarnings("serial")
	private final static ArrayList<Type> weakness = new ArrayList<Type>() {{ 
		add(new Flying());
		add(new Rock());
		add(new Fire());
	}};
	
	public Bug() {
		super("Bug", weakness, strength);
	}
	
	
}
