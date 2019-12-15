package main;

import java.io.IOException;
import java.util.Scanner;

import MVC.Controler;
import MVC.Model;

public class Game {

	public static void main(String[] args) {
		
		Controler controler = new Controler();
		
		Model data = null;
		
		try {
			data = controler.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
		data.printMyTeam();
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		
		while(true) {
			
			if (str.equals("0")) {
				controler.menu(data);
			}
			System.out.println("(Press 0 to open Menu) >>>");
			str = sc.nextLine();
		}
	}

}
