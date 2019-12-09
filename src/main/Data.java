package main;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import abstractClass.Capacity;
import abstractClass.Pokemon;

public class Data implements Serializable{
	private final Map<Pokemon,ArrayList<Capacity>> capacities = new HashMap<Pokemon,ArrayList<Capacity>>();
	
	
}
