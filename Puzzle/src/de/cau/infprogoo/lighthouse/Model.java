package de.cau.infprogoo.lighthouse;

import java.util.HashSet;
import java.util.Set;



/**
 * This class is our Model. It contains the skeletal structure of our game. It
 * represents the current state of the game.
 *
 */
public class Model {

	int[] spielfeld = {1,1,2,2,1,3,3,2,4,3,3,5,4,4,5,5,0,0,0,0,0,0,0,0};

	private final int WIDTH;
	private final int HEIGHT;
	
	//Spielfeld den Playern zuordnen
	

//Position of the player in a 2D Array
	private int playerOL = 1;

	private int playerOR = 2;

	private int playerR = 3;

	private int playerUL = 4;

	private int playerUR = 5;

	public Model(int width, int height) {

		this.WIDTH = width;
		this.HEIGHT = height;
		
		
	}
	
	
	/** Set of views registered to be notified of world updates. */
	private final Set<View> views = new HashSet<>();
	
	/**
	 * Adds the given view of the world and updates it once. Once registered through
	 * this method, the view will receive updates whenever the world changes.
	 * 
	 * @param view the view to be registered.
	 */
	public void registerView(View view) {
		views.add(view);
		view.update(this);
	}

	/**
	 * Updates all views by calling their {@link View#update(World)} methods.
	 */
	private void updateViews() {
		for (View view : views) {
			view.update(this);
		}
	}

	public int getWIDTH() {
		return WIDTH;
	}

	public int getHEIGHT() {
		return HEIGHT;
	}

	public int getPlayerOL() {
		return playerOL;
	}

	public void setPlayerOL(int playerOL) {
		this.playerOL = playerOL;
		updateViews();
	}

	public int getPlayerOR() {
		return playerOR;
	}

	public void setPlayerOR(int playerOR) {
		this.playerOR = playerOR;
		updateViews();
	}

	public int getPlayerR() {
		return playerR;
	}

	public void setPlayerR(int playerR) {
		this.playerR = playerR;
		updateViews();
	}

	public int getPlayerUL() {
		return playerUL;
	}

	public void setPlayerUL(int playerUL) {
		this.playerUL = playerUL;
		updateViews();
	}

	public int getPlayerUR() {
		return playerUR;
	}

	public void setPlayerUR(int playerUR) {
		this.playerUR = playerUR;
		updateViews();
	}

	
}
