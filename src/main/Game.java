package main;

import java.io.IOException;

import MVC.Controler;
import MVC.Model;
import MVC.View;
import lab.MyMethodes;

public class Game {

	public static void main(String[] args) {
		
		Controler controler = new Controler();
		
		Model player1 = null, player2 = null;
		
		try {
			player1 = controler.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
		player1.printTeam("");
		
		
			
		if (controler.choice(player1)) {
			try {
				player2 = controler.start();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			View.printVersus(player1,player2);
			
			
			controler.versus(player1,player2);
		}
		
		
		
	}

}
