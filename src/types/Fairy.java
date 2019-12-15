package types;

import java.util.ArrayList;
import java.util.Objects;

import abstractClass.Type;

@SuppressWarnings("serial")
public class Fairy extends Type{

	private final static ArrayList<Type> strength = new ArrayList<Type>() {{ 
		add(new Fighting());
		add(new Dragon());
		add(new Dark());
	}};
	
	private final static ArrayList<Type> weakness = new ArrayList<Type>() {{ 
		add(new Poison());
		add(new Steel());
	}};
	
	public Fairy() {
		super("Fairy", weakness, strength);
	}
}
