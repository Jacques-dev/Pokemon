package Test;

import java.util.ArrayList;

import MVC.AIModel;
import MVC.AIVersus;
import MVC.PlayerModel;
import MVC.PlayerVersus;
import abstractClass.Pokemon;

public class Test$ {

	public static void main(String[] args) {
		AIModel m = new AIModel(6);
		m.printTeam("1");

		PlayerModel pm = new PlayerModel(6);
	
		AIVersus v = new AIVersus(pm, m);
		v.start();

	}
}
