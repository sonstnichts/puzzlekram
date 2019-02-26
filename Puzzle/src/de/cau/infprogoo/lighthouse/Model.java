package de.cau.infprogoo.lighthouse;

import java.util.HashSet;
import java.util.Set;



/**
 * This class is our Model. It contains the skeletal structure of our game.
 * It represents the current state of the game.
 *
 */
public class Model {
	

int[][] spielfeld = new int [4][6];
private final int WIDTH;
private final int HEIGHT;
//Position of the player
private int player1 = spielfeld [0][0];
private int player2 = spielfeld [0][2];
private int player3 = spielfeld [3][0];
private int player4 = spielfeld [3][2];
private int player5 = spielfeld [1][1];


/** Set of views registered to be notified of world updates. */
private final Set<GView> views = new HashSet<>();


public Model(int width, int height) {
	
	this.WIDTH = width;
	this.HEIGHT = height;
}


public int getWIDTH() {
	return WIDTH;
}


public int getHEIGHT() {
	return HEIGHT;
}


public int getPlayer1() {
	return player1;
}


public void setPlayer1(int player1) {
	this.player1 = player1;
	updateViews();
}


public int getPlayer2() {
	return player2;
}


public void setPlayer2(int player2) {
	this.player2 = player2;
	updateViews();
}


public int getPlayer3() {
	return player3;
}


public void setPlayer3(int player3) {
	this.player3 = player3;
	updateViews();
	
}


public int getPlayer4() {
	return player4;
}


public void setPlayer4(int player4) {
	this.player4 = player4;
	updateViews();
}


public int getPlayer5() {
	return player5;
}


public void setPlayer5(int player5) {
	this.player5 = player5;
	updateViews();
}





/**
* Adds the given view of the world and updates it once. Once registered through
* this method, the view will receive updates whenever the world changes.
* 
* @param view the view to be registered.
*/
public void registerView(GView view) {
views.add(view);
view.update(this);
}

/**
* Updates all views by calling their {@link GView#update(World)} methods.
*/
private void updateViews() {
for (GView view : views) {
view.update(this);
}
}








}
