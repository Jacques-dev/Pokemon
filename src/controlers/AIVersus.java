package controlers;

import java.util.ArrayList;

import abstractClass.Capacity;
import abstractClass.Pokemon;

public class AIVersus {
	private final PlayerModel model1;
	private final AIModel model2;
	private final AIFight fight;
	
	public AIVersus(PlayerModel model1, AIModel model2) {
		super();
		this.model1 = model1;
		this.model2 = model2;
		this.fight = createFight();
	}
	
	public AIFight createFight() {
		Pokemon p1 = model1.getPokemon();
		ArrayList<Capacity> c1 = p1.getCapacities();

		Pokemon p2 = model2.getPokemon();
		ArrayList<Capacity> c2 = p2.getCapacities();
		
		return new AIFight(model1, model2 ,p1, p2, c1, c2 );
	}
	
	public void start() {
		View.printVersus(model1, model2);
		fight.start();
	}
	
	
}
