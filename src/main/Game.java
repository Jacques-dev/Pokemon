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
		
		while (true) {
			try {
				player1 = controler.start();
			} catch (IOException e) {
				e.printStackTrace();
			}
			player1.printTeam("");
			
			int mode = controler.choice(player1);
				
			if (mode == 1) {
				try {
					player2 = controler.start();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				View.printVersus(player1,player2);
				
				
				controler.versus(player1,player2);
			}
			
			if (mode == 2) {
					for (int i=0; i<4; i++) {
						try {

							player2 = controler.setEnnemy(5);

						} catch (IOException e) {
							e.printStackTrace();
						}
					
					View.printVersus(player1, player2);
					
					controler.versus(player1, player2);
					}
					try {

					player2 = controler.setEnnemy(6);

					} catch (IOException e) {
						e.printStackTrace();
					}
					
					View.printVersus(player1, player2);
					
					controler.versus(player1, player2);
			}
			
			if (mode == 3) {
				for (int i=0; i<9; i++) {
					try {

						player2 = controler.setEnnemy(6);

					} catch (IOException e) {
						e.printStackTrace();
					}
				
				View.printVersus(player1, player2);
				
				controler.versus(player1, player2);
				}
				try {

				player2 = controler.setEnnemy(6);

				} catch (IOException e) {
					e.printStackTrace();
				}
				
				View.printVersus(player1, player2);
				
				controler.versus(player1, player2);				
			}
		
		}
		
	}

}
