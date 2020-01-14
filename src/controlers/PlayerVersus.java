package controlers;

import java.util.ArrayList;

import abstractClass.Capacity;
import abstractClass.Pokemon;

public class PlayerVersus {
	private final PlayerModel model1;
	private final PlayerModel model2;
	private final PlayerFight fight;
	
	/**
     * PlayerVersus constructor
     * @param two PlayerModel
     * @return a PlayerVersus
     */
	public PlayerVersus(PlayerModel model1, PlayerModel model2) {
		super();
		this.model1 = model1;
		this.model2 = model2;
		this.fight = createFight();
	}
	
	/**
     * initialise the fight attribute of a PlayerVersus
     * @return a PlayerFight
     */
	public PlayerFight createFight() {
		Pokemon p1 = model1.getPokemon();
		ArrayList<Capacity> c1 = p1.getCapacities();

		Pokemon p2 = model2.getPokemon();
		ArrayList<Capacity> c2 = p2.getCapacities();
		
		return new PlayerFight(model1, model2 ,p1, p2, c1, c2 );
	}
	
	/**
     * Start the fight between the two PlayerModel
     */
	public void start() {
		View.printVersus(model1, model2);
		fight.start();
	}
	
}
