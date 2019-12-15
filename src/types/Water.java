package types;

import java.util.ArrayList;
import java.util.Objects;

import abstractClass.Type;

@SuppressWarnings("serial")
public class Water extends Type{

	private final static ArrayList<Type> strength = new ArrayList<Type>() {{ 
		add(new Ground());
		add(new Rock());
		add(new Fire());
	}};
	

	private final static ArrayList<Type> weakness = new ArrayList<Type>() {{ 
		add(new Grass());
		add(new Electric());
	}};
	
	public Water() {
		super("Water", weakness, strength);
	}
	
}
