package types;

import java.util.ArrayList;
import java.util.Objects;

import abstractClass.Type;

@SuppressWarnings("serial")
public class Normal extends Type{
	
	private final static ArrayList<Type> weakness = new ArrayList<Type>() {{ 
		add(new Fighting());
	}};
	
	public Normal() {
		super("Normal", weakness);
	}
}
