package types;

import java.util.ArrayList;

import abstractClass.Type;

@SuppressWarnings("serial")
public class Ice extends Type{

	private final static ArrayList<Type> strength = new ArrayList<Type>() {{ 
		add(new Flying());
		add(new Ground());
		add(new Grass());
		add(new Dragon());
	}};
	
	private final static ArrayList<Type> weakness = new ArrayList<Type>() {{ 
		add(new Fighting());
		add(new Rock());
		add(new Steel());
		add(new Fire());
	}};
	
	public Ice() {
		super("Ice", weakness, strength);
	}
	
	
}
