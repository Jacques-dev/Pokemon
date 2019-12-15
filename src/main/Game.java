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
		
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		
		while(true) {
			
			if (str.equals("0")) {
				controler.menu(data);
				str = sc.nextLine();
			}
			System.out.println(">>>");
			str = sc.nextLine();
		}
	}

}
