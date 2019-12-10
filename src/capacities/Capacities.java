package capacities;

import java.util.HashMap;
import java.util.Map;

import abstractClass.Capacity;

public class Capacities {
	@SuppressWarnings("serial")
	private final static HashMap<Integer, Capacity> capacities = new HashMap<Integer,Capacity>() {{
		put(1,new Bite());
		put(2,new Crunch());
		put(3,new DefenseCurl());
		put(4,new DoubleEdge());
		put(5,new EarthQuake());
		put(6,new FlameWheel());
		put(7,new FlareBlitz());
		put(8,new FutureSight());
		put(9,new Psy());
		put(10,new Thunder());
		put(11,new ThunderShock());
		put(12,new VineWhip());
	}};
	
	public static void openCapacities() {
		for (Map.Entry<Integer,Capacity> e : capacities.entrySet()){
		    System.out.println(e.getKey() + " : " + e.getValue());
		}
	}
}
