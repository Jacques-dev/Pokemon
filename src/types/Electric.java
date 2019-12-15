package types;

import java.util.ArrayList;

import abstractClass.Type;

@SuppressWarnings("serial")
public class Electric extends Type{

	private final static ArrayList<Type> strength = new ArrayList<Type>() {{ 
		add(new Flying());
		add(new Water());
	}};
	
	private final static ArrayList<Type> weakness = new ArrayList<Type>() {{ 
		add(new Electric());
	}};
	
	public Electric() {
		super("Electric", weakness, strength);
	}
	
	
}
