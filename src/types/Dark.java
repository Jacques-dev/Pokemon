package types;

import java.util.ArrayList;
import java.util.Objects;

import abstractClass.Type;

@SuppressWarnings("serial")
public class Dark extends Type{

	private final static ArrayList<Type> strength = new ArrayList<Type>() {{ 
		add(new Ghost());
		add(new Psychic());
	}};
	

	private final static ArrayList<Type> weakness = new ArrayList<Type>() {{ 
		add(new Flying());
		add(new Bug());
		add(new Fairy());
	}};
	
	public Dark() {
		super("Dark", weakness, strength);
	}

}
