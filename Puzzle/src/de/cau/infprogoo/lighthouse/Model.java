package de.cau.infprogoo.lighthouse;

import java.util.HashSet;
import java.util.Set;

/**
 * This class is our Model. It contains the skeletal structure of our game. It
 * represents the current state of the game.
 *
 */
public class Model {
	public static int count;
	private final int WIDTH;
	private final int HEIGHT;

	// Spielfeld den Playern zuordnen

	// Position of the player
	private int playerOLX = 0;
	private int playerOLY = 2;

	private int playerORX = 2;
	private int playerORY = 1;

	private int playerRX = 1;
	private int playerRY = 3;

	private int playerULX = 0;
	private int playerULY = 4;

	private int playerURX = 2;
	private int playerURY = 4;

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

	public boolean noNazi() {
		if (noNazi1() || noNazi2() || noNazi3() || noNazi4() || noNazi5() || noNazi6() || noNazi7() || noNazi8()
				|| noNazi9()) {
			updateViews();
			return true;
		}
		return false;

	}

	private boolean noNazi1() {
		return playerOLX == 2 && playerOLY == 2 && playerORX == 2 && playerORY == 3 && playerULX == 0 && playerULY == 2
				&& playerURX == 0 && playerURY == 4;

	}

	private boolean noNazi2() {
		return playerOLX == 2 && playerOLY == 2 && playerORX == 2 && playerORY == 3 && playerULX == 0 && playerULY == 2;

	}

	private boolean noNazi3() {
		return playerOLX == 0 && playerOLY == 4 && playerORX == 0 && playerORY == 1 && playerULX == 2 && playerULY == 4;

	}

	private boolean noNazi4() {
		return playerOLX == 0 && playerOLY == 4 && playerORX == 0 && playerORY == 1 && playerURX == 2 && playerURY == 2;

	}

	private boolean noNazi5() {
		return playerOLX == 2 && playerOLY == 2 && playerORX == 2 && playerORY == 3 && playerURX == 0 && playerURY == 4;

	}

	private boolean noNazi6() {
		return playerOLX == 0 && playerOLY == 6 && playerULX == 2 && playerULY == 6 && playerURX == 2 && playerURY == 4;
	}

	private boolean noNazi7() {
		return playerOLX == 2 && playerOLY == 4 && playerULX == 0 && playerULY == 4 && playerURX == 0 && playerURY == 6;
	}

	private boolean noNazi8() {
		return playerORX == 2 && playerORY == 5 && playerULX == 0 && playerULY == 4 && playerURX == 0 && playerURY == 6;

	}

	private boolean noNazi9() {
		return playerORX == 0 && playerORY == 3 && playerULX == 2 && playerULY == 6 && playerURX == 2 && playerURY == 4;

	}

	public void win() {
		playerOLX = 0;
		playerOLY = 2;

		playerORX = 2;
		playerORY = 1;

		playerRX = 1;
		playerRY = 6;

		playerULX = 0;
		playerULY = 4;

		playerURX = 2;
		playerURY = 4;

		updateViews();
	}

	public void restart() {
		playerOLX = 0;
		playerOLY = 2;

		playerORX = 2;
		playerORY = 1;

		playerRX = 1;
		playerRY = 3;

		playerULX = 0;
		playerULY = 4;

		playerURX = 2;
		playerURY = 4;

		updateViews();

	}

	public int getPlayerOLX() {
		return playerOLX;
	}

	public void setPlayerOLX(int playerOLX) {
		this.playerOLX = playerOLX;
		updateViews();
	}

	public int getPlayerOLY() {
		return playerOLY;
	}

	public void setPlayerOLY(int playerOLY) {
		this.playerOLY = playerOLY;
		updateViews();
	}

	public int getPlayerORX() {
		return playerORX;
	}

	public void setPlayerORX(int playerORX) {
		this.playerORX = playerORX;
		updateViews();
	}

	public int getPlayerORY() {
		return playerORY;
	}

	public void setPlayerORY(int playerORY) {
		this.playerORY = playerORY;
		updateViews();
	}

	public int getPlayerRX() {
		return playerRX;
	}

	public void setPlayerRX(int playerRX) {
		this.playerRX = playerRX;
		updateViews();
	}

	public int getPlayerRY() {
		return playerRY;
	}

	public void setPlayerRY(int playerRY) {
		this.playerRY = playerRY;
		updateViews();
	}

	public int getPlayerULX() {
		return playerULX;
	}

	public void setPlayerULX(int playerULX) {
		this.playerULX = playerULX;
		updateViews();
	}

	public int getPlayerULY() {
		return playerULY;
	}

	public void setPlayerULY(int playerULY) {
		this.playerULY = playerULY;
		updateViews();
	}

	public int getPlayerURX() {
		return playerURX;
	}

	public void setPlayerURX(int playerURX) {
		this.playerURX = playerURX;
		updateViews();
	}

	public int getPlayerURY() {
		return playerURY;
	}

	public void setPlayerURY(int playerURY) {
		this.playerURY = playerURY;
		updateViews();
	}

	public int getWIDTH() {
		return WIDTH;
	}

	public int getHEIGHT() {
		return HEIGHT;
	}

}
