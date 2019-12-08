package types;

import java.util.ArrayList;

import abstractClass.Type;

public class Electric extends Type{
	@SuppressWarnings("serial")
	private final static ArrayList<Type> strength = new ArrayList<Type>() {{ 
		add(new Flying());
		add(new Water());
	}};
	
	@SuppressWarnings("serial")
	private final static ArrayList<Type> weakness = new ArrayList<Type>() {{ 
		add(new Electric());
	}};
	
	public Electric() {
		super("Electric", weakness, strength);
	}
	
	
}
