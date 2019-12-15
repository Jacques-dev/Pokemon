package types;

import java.util.ArrayList;
import java.util.Objects;

import abstractClass.Type;

@SuppressWarnings("serial")
public class Ground extends Type{

	private final static ArrayList<Type> strength = new ArrayList<Type>() {{ 
		add(new Poison());
		add(new Rock());
		add(new Steel());
		add(new Fire());
		add(new Electric());
	}};
	
	private final static ArrayList<Type> weakness = new ArrayList<Type>() {{ 
		add(new Water());
		add(new Grass());
		add(new Ice());
	}};
	
	public Ground() {
		super("Ground", weakness, strength);
	}
}
