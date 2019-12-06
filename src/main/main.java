package main;

import system.PhysicalCapacity;
import system.Type;
import types.Normal;

public class main {

	public static void main(String[] args) {
		Type normal = new Normal();
		PhysicalCapacity p = PhysicalCapacity.TACKLE;
		System.out.println(p.getType());
		System.out.println(p.getPower());

	}

}
