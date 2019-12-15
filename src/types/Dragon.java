package types;

import java.util.ArrayList;
import java.util.Objects;

import abstractClass.Type;

@SuppressWarnings("serial")
public class Dragon extends Type{

	private final static ArrayList<Type> strength = new ArrayList<Type>() {{ 
		add(new Dragon());
	}};
	
	private final static ArrayList<Type> weakness = new ArrayList<Type>() {{ 
		add(new Dragon());
		add(new Ice());
		add(new Fairy());
	}};
	
	public Dragon() {
		super("Dragon", weakness, strength);
	}
}
