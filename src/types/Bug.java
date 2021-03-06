package types;

import java.util.ArrayList;
import java.util.Objects;

import abstractClass.Type;

@SuppressWarnings("serial")
public class Bug extends Type{

	private final static ArrayList<Type> strength = new ArrayList<Type>() {{ 
		add(new Grass());
		add(new Psychic());
		add(new Dark());
	}};
	

	private final static ArrayList<Type> weakness = new ArrayList<Type>() {{ 
		add(new Flying());
		add(new Rock());
		add(new Fire());
	}};
	
	public Bug() {
		super("Bug", weakness, strength);
	}
	
}
