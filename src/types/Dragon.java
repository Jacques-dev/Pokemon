package types;

import java.util.ArrayList;

import abstractClass.Type;

public class Dragon extends Type{
	@SuppressWarnings("serial")
	private final static ArrayList<Type> strength = new ArrayList<Type>() {{ 
		add(new Dragon());
	}};
	
	@SuppressWarnings("serial")
	private final static ArrayList<Type> weakness = new ArrayList<Type>() {{ 
		add(new Dragon());
		add(new Ice());
		add(new Fairy());
	}};
	
	public Dragon() {
		super("Dragon", weakness, strength);
	}
	
	
}
