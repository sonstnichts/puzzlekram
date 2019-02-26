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

private int player1X;
private int player1Y;
private int player2X;
private int player2Y;
private int player3X;
private int player3Y;
private int player4X;
private int player4Y;
private int player5X;
private int player5Y;

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

public int getPlayer1X() {
	return player1X;
}


public void setPlayer1X(int player1x) {
	player1X = player1x;
}


public int getPlayer1Y() {
	return player1Y;
}


public void setPlayer1Y(int player1y) {
	player1Y = player1y;
}


public int getPlayer2X() {
	return player2X;
}


public void setPlayer2X(int player2x) {
	player2X = player2x;
}


public int getPlayer2Y() {
	return player2Y;
}


public void setPlayer2Y(int player2y) {
	player2Y = player2y;
}


public int getPlayer3X() {
	return player3X;
}


public void setPlayer3X(int player3x) {
	player3X = player3x;
}


public int getPlayer3Y() {
	return player3Y;
}


public void setPlayer3Y(int player3y) {
	player3Y = player3y;
}


public int getPlayer4X() {
	return player4X;
}


public void setPlayer4X(int player4x) {
	player4X = player4x;
}


public int getPlayer4Y() {
	return player4Y;
}


public void setPlayer4Y(int player4y) {
	player4Y = player4y;
}


public int getPlayer5X() {
	return player5X;
}


public void setPlayer5X(int player5x) {
	player5X = player5x;
}


public int getPlayer5Y() {
	return player5Y;
}


public void setPlayer5Y(int player5y) {
	player5Y = player5y;
}



///////////////////////////////////////////////////////////////////////////
// View Management

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
