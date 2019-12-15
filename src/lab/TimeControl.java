package lab;

public class TimeControl {
	
	public static void wait(int x) {
		try {
		   Thread.sleep(x*1000) ;
		}  catch (InterruptedException e) {
		    // gestion de l'erreur
		}
	}
	
}
