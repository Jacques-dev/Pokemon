package types;

import java.util.ArrayList;

import system.Type;

public class Psychic extends Type{
	@SuppressWarnings("serial")
	private final static ArrayList<Type> strength = new ArrayList<Type>() {{ 
		add(new Fighting());
		add(new Poison());
	}};
	
	@SuppressWarnings("serial")
	private final static ArrayList<Type> weakness = new ArrayList<Type>() {{ 
		add(new Bug());
		add(new Ghost());
		add(new Dark());
	}};
	
	public Psychic() {
		super("Psychic", weakness, strength);
	}
	
	
}
