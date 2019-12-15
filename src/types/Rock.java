package types;

import java.util.ArrayList;
import java.util.Objects;

import abstractClass.Type;

@SuppressWarnings("serial")
public class Rock extends Type{

	private final static ArrayList<Type> strength = new ArrayList<Type>() {{ 
		add(new Flying());
		add(new Bug());
		add(new Fire());
		add(new Ice());
	}};
	
	private final static ArrayList<Type> weakness = new ArrayList<Type>() {{ 
		add(new Fighting());
		add(new Ground());
		add(new Steel());
		add(new Water());
		add(new Grass());
	}};
	
	public Rock() {
		super("Rock", weakness, strength);
	}
}
