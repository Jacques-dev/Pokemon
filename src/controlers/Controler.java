package controlers;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import abstractClass.Capacity;
import abstractClass.Pokemon;
import lab.MyMethodes;
import pokedex.Attacks;
import pokedex.PokedexApparences;
import pokedex.PokedexStats;

public class Controler {

	/**
     * Display the first menu and respond to the user's entries
     * @return PlayerModel created by the user or restored from a save
     */
	@SuppressWarnings("resource")
	public PlayerModel start() throws IOException {
		View.start();
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		while(str != "1" || str != "2") {
		switch (str) {
		case "1":
			View.pokemonSelection();
			MyMethodes.wait(2);
			PlayerModel data = new PlayerModel(6);
			return data;
		case "2":
			try {
				return read();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		case "3":
			PokedexApparences x = new PokedexApparences();
			x.openPokedex();
			break;
		case "4":
			View.printRules();
			break;			
		case "0":
			System.exit(0);
		}
		View.start();
		str = sc.nextLine();
	}
		return null;
	}

	/**
     * save a model in the "Data.ser" file
     * @param Model "data", the model you want to save in the "Data.ser" file
     */
	public void save(PlayerModel data) throws IOException {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Data.ser"))) {
			oos.writeObject(data);
		} catch (IOException e) {
			e.printStackTrace();

		}
	}

	/**
     * restore a PlayerModel from the "Data.ser" file
     * @return the PlayerModel contained in the "Data.ser" file
     */
	public PlayerModel read() throws ClassNotFoundException, IOException {

		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Data.ser"))) {

			PlayerModel x = (PlayerModel) ois.readObject();

			return x;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
     * Display the post-selection menu and respond to the user's entries
     * @param Model "data" created by the user or restored from a save
     */
	@SuppressWarnings("resource")
	public void menu(PlayerModel data) {
		View.menu();
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		switch (str) {
		case "1":
			break;
		case "2":
			try {
				save(data);
				View.save();
				MyMethodes.wait(2);

			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		case "3":
			View.printRules();
			break;
		case "0":
			View.space();
			System.exit(0);
		}
	}

	/**
     * Display the pre-fight menu and respond to the user's entries
     * @param Model "data" created by the user or restored from a save
     * @return int "choice" representing the user's choice
     */
	public void choice(PlayerModel data) {
		View.choice();
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		while (str != "1" || str != "2" || str != "3" || str !="0") {
		switch (str) {
		case "1":
			PlayerModel model2 = new PlayerModel(6);
			PlayerVersus v = new PlayerVersus(data, model2);
			v.start();
			return;
		case "2":
			ClassicLeague cl = new ClassicLeague();
			cl.challenge(data);
			return;
		case "3":
			LeagueDUT ldut = new LeagueDUT();
			ldut.challenge(data);
			return;
		case "4":
			View.printRules();
			break;
		case "0":
			menu(data);
		}

		View.choice();
		str = sc.nextLine();
	}

		return;
	}

}
