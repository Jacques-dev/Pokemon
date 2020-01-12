package main;

import java.io.IOException;

import controlers.AIModel;
import controlers.AIVersus;
import controlers.ClassicLeague;
import controlers.Controler;
import controlers.PlayerModel;
import controlers.View;
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
