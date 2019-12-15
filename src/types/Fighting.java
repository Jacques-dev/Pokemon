package types;

import java.util.ArrayList;

import abstractClass.Type;

@SuppressWarnings("serial")
public class Fighting extends Type{
	
	private final static ArrayList<Type> strength = new ArrayList<Type>() {{ 
		add(new Normal());
		add(new Rock());
		add(new Steel());
		add(new Ice());
		add(new Dark());
	}};
	
	private final static ArrayList<Type> weakness = new ArrayList<Type>() {{ 
		add(new Flying());
		add(new Psychic());
		add(new Fairy());
	}};
	
	public Fighting() {
		super("Fighting", weakness, strength);
	}
	
	
}
