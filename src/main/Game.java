package main;

import java.util.Scanner;

import MVC.Model;
import MVC.View;

public class Game {

	public static void main(String[] args) {
		
		Model.start();
		
		Model.printMyTeam();
		
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		
		while(true) {
			
			if (str.equals("escape")) {
				View.menu();
			}
			
		}
	}

}
