package main;

import java.io.IOException;

import MVC.AIModel;
import MVC.AIVersus;
import MVC.ClassicLeague;
import MVC.Controler;
import MVC.PlayerModel;
import MVC.View;
import lab.MyMethodes;

public class Game {

	public static void main(String[] args) {
		Controler c = new Controler();
		PlayerModel p1 = null;
		try {
			p1 = c.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
		c.choice(p1);

	}

}
