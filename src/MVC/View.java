package MVC;

import java.util.Scanner;

public class View {
	
	private static void bar() {
		System.out.println("--------------------");
	}
	private static String bar2() {
		return "--------";
	}
	static void space() {
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
	}
	
	public static void start() {
		System.out.println("\n  '*# POKEMON #*'\n");
		System.out.println(bar2()+"MENU"+bar2());
		System.out.println("1 - Start new game");
		System.out.println("2 - Play from save");
		System.out.println("3 - Rules");
		System.out.println("0 - Quit");
		bar();
	}
	
	public static void pokemonSelection() {
		space();
		System.out.println(bar2()+"POKEMON SELECTION"+bar2());
		System.out.println("Press 0 if you want to stop the selection");
	}
	
	@SuppressWarnings("resource")
	public static void printRules() {
		System.out.println(bar2()+"RULES"+bar2());
		bar();
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		System.out.println("Press 0 to escape");
		if (str.equals("0")) {
			return;
		}
	}
	
	public static void menu() {
		space();
		System.out.println(bar2()+"MENU"+bar2());
		System.out.println("1 - Continue");
		System.out.println("2 - Save");
		System.out.println("3 - Rules");
		System.out.println("0 - Quit");
		bar();
	}
	
	public static void save() {
		space();
		System.out.println(bar2()+"SAVE"+bar2());
		space();
		System.out.println(">>>");
	}
}
