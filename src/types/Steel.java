package types;

import java.util.ArrayList;
import java.util.Objects;

import abstractClass.Type;

@SuppressWarnings("serial")
public class Steel extends Type{

	private final static ArrayList<Type> strength = new ArrayList<Type>() {{ 
		add(new Rock());
		add(new Ice());
		add(new Fairy());
	}};
	
	private final static ArrayList<Type> weakness = new ArrayList<Type>() {{ 
		add(new Fighting());
		add(new Ground());
		add(new Fire());
	}};
	
	public Steel() {
		super("Steel", weakness, strength);
	}
}
