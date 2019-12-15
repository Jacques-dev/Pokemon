package types;

import java.util.ArrayList;
import java.util.Objects;

import abstractClass.Type;

@SuppressWarnings("serial")
public class Psychic extends Type{

	private final static ArrayList<Type> strength = new ArrayList<Type>() {{ 
		add(new Fighting());
		add(new Poison());
	}};
	
	private final static ArrayList<Type> weakness = new ArrayList<Type>() {{ 
		add(new Bug());
		add(new Ghost());
		add(new Dark());
	}};
	
	public Psychic() {
		super("Psychic", weakness, strength);
	}
}
