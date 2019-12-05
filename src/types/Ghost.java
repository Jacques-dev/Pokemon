package types;

import java.util.ArrayList;

import system.Type;

public class Ghost extends Type{
	@SuppressWarnings("serial")
	private final static ArrayList<Type> strength = new ArrayList<Type>() {{ 
		add(new Ghost());
		add(new Psychic());
	}};
	
	@SuppressWarnings("serial")
	private final static ArrayList<Type> weakness = new ArrayList<Type>() {{ 
		add(new Ghost());
		add(new Dark());
	}};
	
	public Ghost() {
		super("Ghost", weakness, strength);
	}
	
	
}
