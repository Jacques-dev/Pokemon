package View;

public class Menus {
	
	private static void bar() {
		System.out.println("-------------------");
	}
	private static String bar2() {
		return "-------";
	}
	
	public static void start() {
		System.out.println("  '*# POKEMON #*'\n");
		System.out.println(bar2()+"MENU"+bar2());
		System.out.println("1 - Start new game");
		System.out.println("2 - Play from save");
		System.out.println("3 - Rules");
		System.out.println("4 - Quit");
		bar();
	}
	
	
}
