package types;

import java.util.ArrayList;

import abstractClass.Type;

@SuppressWarnings("serial")
public class Fire extends Type{

	private final static ArrayList<Type> strength = new ArrayList<Type>() {{ 
		add(new Bug());
		add(new Grass());
		add(new Ice());
		add(new Steel());
	}};
	
	private final static ArrayList<Type> weakness = new ArrayList<Type>() {{ 
		add(new Ground());
		add(new Rock());
		add(new Water());
	}};
	
	public Fire() {
		super("Fire", weakness, strength);
	}
	
	
}
