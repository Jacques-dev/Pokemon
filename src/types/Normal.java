package types;

import java.util.ArrayList;

import abstractClass.Type;

public class Normal extends Type{
	
	@SuppressWarnings("serial")
	private final static ArrayList<Type> weakness = new ArrayList<Type>() {{ 
		add(new Fighting());
	}};
	
	public Normal() {
		super("Normal", weakness);
	}
	
	
}
