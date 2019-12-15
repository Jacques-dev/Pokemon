package types;

import java.util.ArrayList;

import abstractClass.Type;

@SuppressWarnings("serial")
public class Flying extends Type{

	private final static ArrayList<Type> strength = new ArrayList<Type>() {{ 
		add(new Fighting());
		add(new Bug());
		add(new Grass());
	}};
	
	private final static ArrayList<Type> weakness = new ArrayList<Type>() {{ 
		add(new Rock());
		add(new Electric());
		add(new Ice());
	}};
	
	public Flying() {
		super("Flying", weakness, strength);
	}
	
	
}
