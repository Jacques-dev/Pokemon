package types;

import java.util.ArrayList;

import system.Type;

public class Fire extends Type{
	@SuppressWarnings("serial")
	private final static ArrayList<Type> strength = new ArrayList<Type>() {{ 
		add(new Bug());
		add(new Grass());
		add(new Ice());
		add(new Steel());
	}};
	
	@SuppressWarnings("serial")
	private final static ArrayList<Type> weakness = new ArrayList<Type>() {{ 
		add(new Ground());
		add(new Rock());
		add(new Water());
	}};
	
	public Fire() {
		super("Fire", weakness, strength);
	}
	
	
}
