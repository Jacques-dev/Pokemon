package types;

import java.util.ArrayList;

import abstractClass.Type;

@SuppressWarnings("serial")
public class Ghost extends Type{

	private final static ArrayList<Type> strength = new ArrayList<Type>() {{ 
		add(new Ghost());
		add(new Psychic());
	}};
	
	private final static ArrayList<Type> weakness = new ArrayList<Type>() {{ 
		add(new Ghost());
		add(new Dark());
	}};
	
	public Ghost() {
		super("Ghost", weakness, strength);
	}
	
	
}
