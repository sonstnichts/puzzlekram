package de.cau.infprogoo.lighthouse;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GController implements KeyListener {

	/** The world that is updated upon every key press. */
	private Model model;
	
	/**
	 * Speichert die zuletzt ausgewählte Figur. */
	private int previous;

	public GController(Model model, Puzzle puzzle) {

		this.model = model;

		puzzle.getGCanvas().addKeyListener(this);

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		boolean relevantKey = false;
		
		//Saves the keycode between 1-5 to choose a Piece
		if (e.getKeyCode() == KeyEvent.VK_1 || e.getKeyCode() == KeyEvent.VK_2 || e.getKeyCode() == KeyEvent.VK_3
				|| e.getKeyCode() == KeyEvent.VK_4 || e.getKeyCode() == KeyEvent.VK_5) {
			previous = e.getKeyCode();
			System.out.println(previous);
		}

		
		// ObenLinks bewegt sich (rot)
		if (previous == KeyEvent.VK_1) {
			switch (e.getKeyCode()) {
			case KeyEvent.VK_UP:
				model.setPlayerOLY(Math.max(2, model.getPlayerOLY() - 1));
				relevantKey = true;
				break;
			case KeyEvent.VK_DOWN:
				model.setPlayerOLY(Math.min(model.getHEIGHT(), model.getPlayerOLY() + 1));
				relevantKey = true;
				break;
			case KeyEvent.VK_RIGHT:
				model.setPlayerOLX(Math.min(model.getWIDTH() - 2, model.getPlayerOLX() + 1));
				relevantKey = true;
				break;
			case KeyEvent.VK_LEFT:
				model.setPlayerOLX(Math.max(0, model.getPlayerOLX() - 1));
				relevantKey = true;
				break;
			}
		}

		// Blau
		if (previous == KeyEvent.VK_2) {
			switch (e.getKeyCode()) {
			case KeyEvent.VK_UP:
				model.setPlayerORY(Math.max(1, model.getPlayerORY() - 1));
				relevantKey = true;
				break;
			case KeyEvent.VK_DOWN:
				model.setPlayerORY(Math.min(model.getHEIGHT() - 1, model.getPlayerORY() + 1));
				relevantKey = true;
				break;
			case KeyEvent.VK_RIGHT:
				model.setPlayerORX(Math.min(model.getWIDTH() - 2, model.getPlayerORX() + 1));
				relevantKey = true;
				break;
			case KeyEvent.VK_LEFT:
				model.setPlayerORX(Math.max(0, model.getPlayerORX() - 1));
				relevantKey = true;
				break;
			}
		}
		// Gelb
		if (previous == KeyEvent.VK_3) {
			switch (e.getKeyCode()) {
			case KeyEvent.VK_UP:
				model.setPlayerULY(Math.max(2, model.getPlayerULY() - 1));
				relevantKey = true;
				break;
			case KeyEvent.VK_DOWN:
				model.setPlayerULY(Math.min(model.getHEIGHT(), model.getPlayerULY() + 1));
				relevantKey = true;
				break;
			case KeyEvent.VK_RIGHT:
				model.setPlayerULX(Math.min(model.getWIDTH() - 2, model.getPlayerULX() + 1));
				relevantKey = true;
				break;
			case KeyEvent.VK_LEFT:
				model.setPlayerULX(Math.max(0, model.getPlayerULX() - 1));
				relevantKey = true;
				break;
			}
		}
		// Grün
		if (previous == KeyEvent.VK_4) {
			switch (e.getKeyCode()) {
			case KeyEvent.VK_UP:
				model.setPlayerURY(Math.max(2, model.getPlayerURY() - 1));
				relevantKey = true;
				break;
			case KeyEvent.VK_DOWN:
				model.setPlayerURY(Math.min(model.getHEIGHT(), model.getPlayerURY() + 1));
				relevantKey = true;
				break;
			case KeyEvent.VK_RIGHT:
				model.setPlayerURX(Math.min(model.getWIDTH() - 2, model.getPlayerURX() + 1));
				relevantKey = true;
				break;
			case KeyEvent.VK_LEFT:
				model.setPlayerURX(Math.max(0, model.getPlayerURX() - 1));
				relevantKey = true;
				break;
			}
		}
		// Rechteck
		if (previous == KeyEvent.VK_5) {
			switch (e.getKeyCode()) {
			case KeyEvent.VK_UP:
				model.setPlayerRY(Math.max(2, model.getPlayerRY() - 1));
				relevantKey = true;
				break;
			case KeyEvent.VK_DOWN:
				model.setPlayerRY(Math.min(model.getHEIGHT(), model.getPlayerRY() + 1));
				relevantKey = true;
				break;
			case KeyEvent.VK_RIGHT:
				model.setPlayerRX(Math.min(model.getWIDTH() - 2, model.getPlayerRX() + 1));
				relevantKey = true;
				break;
			case KeyEvent.VK_LEFT:
				model.setPlayerRX(Math.max(0, model.getPlayerRX() - 1));
				relevantKey = true;
				break;
			}

		}
	}

	private boolean checkUR1(int x, int y) {
		if (y == model.getPlayerOLY() && x - 1 == model.getPlayerOLX()
				|| y - 1 == model.getPlayerOLY() && x == model.getPlayerOLX()
				|| y - 2 == model.getPlayerOLY() && x + 1 == model.getPlayerOLX()

				|| y - 2 == model.getPlayerORY() && x + 1 == model.getPlayerORX()
				|| y - 3 == model.getPlayerORY() && x == model.getPlayerORX()
				|| y - 2 == model.getPlayerORY() && x - 1 == model.getPlayerORX()

				|| y - 2 == model.getPlayerRY() && x + 1 == model.getPlayerRX()
				|| y - 2 == model.getPlayerRY() && x == model.getPlayerRX()
				|| y - 1 == model.getPlayerRY() && x - 1 == model.getPlayerRX()

				|| y - 2 == model.getPlayerULY() && x + 1 == model.getPlayerULX()
				|| y - 2 == model.getPlayerULY() && x == model.getPlayerULX()
				|| y - 1 == model.getPlayerULY() && x - 1 == model.getPlayerULX()

		) {

			return false;
		}
		return true;
	}

	private boolean checkUR4(int x, int y) {
		if (y + 1 == model.getPlayerOLY() && x - 2 == model.getPlayerOLX()
				|| y == model.getPlayerOLY() && x - 1 == model.getPlayerOLX()
				|| y - 1 == model.getPlayerOLY() && x == model.getPlayerOLX()

				|| y == model.getPlayerORY() && x - 2 == model.getPlayerORX()
				|| y - 1 == model.getPlayerORY() && x - 2 == model.getPlayerORX()
				|| y - 2 == model.getPlayerORY() && x - 1 == model.getPlayerORX()

				|| y + 1 == model.getPlayerRY() && x - 2 == model.getPlayerRX()
				|| y == model.getPlayerRY() && x - 2 == model.getPlayerRX()
				|| y - 1 == model.getPlayerRY() && x - 1 == model.getPlayerRX()

				|| y + 1 == model.getPlayerULY() && x - 1 == model.getPlayerULX()
				|| y == model.getPlayerULY() && x - 2 == model.getPlayerULX()
				|| y - 1 == model.getPlayerULY() && x - 1 == model.getPlayerULX()

		) {

			return false;
		}
		return true;
	}

	private boolean checkUL3(int x, int y) {
		if (y + 1 == model.getPlayerOLY() && x + 2 == model.getPlayerOLX()
				|| y == model.getPlayerOLY() && x + 2 == model.getPlayerOLX()
				|| y - 1 == model.getPlayerOLY() && x + 1 == model.getPlayerOLX()

				|| y == model.getPlayerORY() && x + 2 == model.getPlayerORX()
				|| y - 1 == model.getPlayerORY() && x + 1 == model.getPlayerORX()
				|| y - 2 == model.getPlayerORY() && x == model.getPlayerORX()

				|| y + 1 == model.getPlayerRY() && x + 2 == model.getPlayerRX()
				|| y == model.getPlayerRY() && x + 2 == model.getPlayerRX()
				|| y - 1 == model.getPlayerRY() && x + 1 == model.getPlayerRX()

				|| y + 1 == model.getPlayerURY() && x + 1 == model.getPlayerURX()
				|| y == model.getPlayerURY() && x + 2 == model.getPlayerURX()
				|| y - 1 == model.getPlayerURY() && x + 1 == model.getPlayerURX()

		) {

			return false;
		}
		return true;
	}

	private boolean checkUL1(int x, int y) {
		if (y - 1 == model.getPlayerOLY() && x - 1 == model.getPlayerOLX()
				|| y - 2 == model.getPlayerOLY() && x == model.getPlayerOLX()
				|| y - 1 == model.getPlayerOLY() && x + 1 == model.getPlayerOLX()

				|| y - 3 == model.getPlayerORY() && x - 1 == model.getPlayerORX()
				|| y - 2 == model.getPlayerORY() && x == model.getPlayerORX()
				|| y - 1 == model.getPlayerORY() && x + 1 == model.getPlayerORX()

				|| y - 2 == model.getPlayerRY() && x - 1 == model.getPlayerRX()
				|| y - 2 == model.getPlayerRY() && x == model.getPlayerRX()
				|| y - 1 == model.getPlayerRY() && x + 1 == model.getPlayerRX()

				|| y - 2 == model.getPlayerURY() && x - 1 == model.getPlayerURX()
				|| y - 2 == model.getPlayerURY() && x == model.getPlayerURX()
				|| y - 1 == model.getPlayerURY() && x + 1 == model.getPlayerURX()

		) {

			return false;
		}
		return true;
	}

	/**
	 * Blaue Box interaktion mit den anderen.
	 * @param key 1 nach oben, 2 nach unten, 3 nach rechts, 4 nach links.
	 * @param x
	 * @param y
	 * @return
	 */
	private boolean wavecheck(int key, int x, int y) {
		switch (key) {
		case 1:
			if (y - 1 == model.getPlayerOLY() && x + 1 == model.getPlayerOLX()
					|| y - 1 == model.getPlayerOLY() && x == model.getPlayerOLX()
					|| y == model.getPlayerOLY() && x - 1 == model.getPlayerOLX()

					|| y - 1 == model.getPlayerRY() && x + 1 == model.getPlayerRX()
					|| y - 1 == model.getPlayerRY() && x == model.getPlayerRX()
					|| y - 1 == model.getPlayerRY() && x - 1 == model.getPlayerRX()

					|| y - 1 == model.getPlayerULY() && x + 1 == model.getPlayerULX()
					|| y - 1 == model.getPlayerULY() && x == model.getPlayerULX()
					|| y - 1 == model.getPlayerULY() && x - 1 == model.getPlayerULX()

					|| y - 1 == model.getPlayerURY() && x + 1 == model.getPlayerURX()
					|| y - 1 == model.getPlayerURY() && x == model.getPlayerURX()
					|| y - 1 == model.getPlayerURY() && x - 1 == model.getPlayerURX()) {
				return false;
			} else {
				return true;
			}
		case 2:
			if (y + 2 == model.getPlayerOLY() && x - 1 == model.getPlayerOLX()
					|| y + 3 == model.getPlayerOLY() && x == model.getPlayerOLX()
					|| y + 3 == model.getPlayerOLY() && x + 1 == model.getPlayerOLX()

					|| y + 2 == model.getPlayerRY() && x - 1 == model.getPlayerRX()
					|| y + 3 == model.getPlayerRY() && x == model.getPlayerRX()
					|| y + 3 == model.getPlayerRY() && x + 1 == model.getPlayerRX()

					|| y + 3 == model.getPlayerULY() && x + 1 == model.getPlayerULX()
					|| y + 2 == model.getPlayerULY() && x == model.getPlayerULX()
					|| y + 1 == model.getPlayerULY() && x - 1 == model.getPlayerULX()

					|| y + 2 == model.getPlayerURY() && x - 1 == model.getPlayerURX()
					|| y + 3 == model.getPlayerURY() && x == model.getPlayerURX()
					|| y + 2 == model.getPlayerURY() && x + 1 == model.getPlayerURX()) {
				return false;
			} else {
				return true;
			}
		case 3:
			if (y + 2 == model.getPlayerOLY() && x + 2 == model.getPlayerOLX()
					|| y + 1 == model.getPlayerOLY() && x + 2 == model.getPlayerOLX()
					|| y == model.getPlayerOLY() && x + 2 == model.getPlayerOLX()

					|| y + 2 == model.getPlayerRY() && x + 2 == model.getPlayerRX()
					|| y + 1 == model.getPlayerRY() && x + 2 == model.getPlayerRX()
					|| y == model.getPlayerRY() && x + 2 == model.getPlayerRX()

					|| y + 2 == model.getPlayerULY() && x + 2 == model.getPlayerULX()
					|| y + 1 == model.getPlayerULY() && x + 2 == model.getPlayerULX()
					|| y == model.getPlayerULY() && x + 2 == model.getPlayerULX()

					|| y + 2 == model.getPlayerURY() && x + 1 == model.getPlayerURX()
					|| y + 1 == model.getPlayerURY() && x + 2 == model.getPlayerURX()
					|| y == model.getPlayerURY() && x + 2 == model.getPlayerURX()) {
				return false;
			} else {
				return true;
			}
		case 4:
			if (y + 2 == model.getPlayerOLY() && x - 1 == model.getPlayerOLX()
					|| y + 1 == model.getPlayerOLY() && x - 2 == model.getPlayerOLX()
					|| y == model.getPlayerOLY() && x - 1 == model.getPlayerOLX()

					|| y + 2 == model.getPlayerRY() && x - 1 == model.getPlayerRX()
					|| y + 1 == model.getPlayerRY() && x - 2 == model.getPlayerRX()
					|| y == model.getPlayerRY() && x - 2 == model.getPlayerRX()

					|| y + 2 == model.getPlayerULY() && x == model.getPlayerULX()
					|| y + 1 == model.getPlayerULY() && x - 1 == model.getPlayerULX()
					|| y == model.getPlayerULY() && x - 2 == model.getPlayerULX()

					|| y + 2 == model.getPlayerURY() && x - 1 == model.getPlayerURX()
					|| y + 1 == model.getPlayerURY() && x - 2 == model.getPlayerURX()
					|| y == model.getPlayerURY() && x - 2 == model.getPlayerURX()) {
				return false;
			} else {
				return true;
			}
		default:
			return false;

		}
	}

	private boolean checkOL2(int x, int y) {
		if (y == model.getPlayerORY() && x + 1 == model.getPlayerORX()
				|| y + 1 == model.getPlayerORY() && x == model.getPlayerORX()
				|| y + 1 == model.getPlayerORY() && x - 1 == model.getPlayerORX()

				|| y + 1 == model.getPlayerRY() && x + 1 == model.getPlayerRX()
				|| y + 2 == model.getPlayerRY() && x == model.getPlayerRX()
				|| y + 2 == model.getPlayerRY() && x - 1 == model.getPlayerRX()

				|| y + 1 == model.getPlayerULY() && x + 1 == model.getPlayerULX()
				|| y + 2 == model.getPlayerULY() && x == model.getPlayerULX()
				|| y + 1 == model.getPlayerULY() && x - 1 == model.getPlayerULX()

				|| y == model.getPlayerURY() && x + 1 == model.getPlayerURX()
				|| y + 1 == model.getPlayerURY() && x == model.getPlayerURX()
				|| y + 2 == model.getPlayerURY() && x - 1 == model.getPlayerURX()) {
			return false;
		}
		return true;
	}

	private boolean checkOL3(int x, int y) {
		if (y == model.getPlayerORY() && x + 1 == model.getPlayerORX()
				|| y + 1 == model.getPlayerRY() && x + 1 == model.getPlayerRX()
				|| y + 1 == model.getPlayerULY() && x + 1 == model.getPlayerULX()
				|| y + 1 == model.getPlayerURY() && x == model.getPlayerURX()) {
			return false;
		} else if (y - 1 == model.getPlayerORY() && x + 2 == model.getPlayerORX()
				|| y == model.getPlayerRY() && x + 2 == model.getPlayerRX()
				|| y == model.getPlayerULY() && x + 2 == model.getPlayerULX()
				|| y == model.getPlayerURY() && x + 1 == model.getPlayerURX()) {
			return false;
		} else if (y - 2 == model.getPlayerORY() && x + 1 == model.getPlayerORX()
				|| y - 1 == model.getPlayerRY() && x + 2 == model.getPlayerRX()
				|| y - 1 == model.getPlayerULY() && x + 2 == model.getPlayerULX()
				|| y - 1 == model.getPlayerURY() && x + 2 == model.getPlayerURX()) {
			return false;
		}
		return true;

	}

	private boolean checkpos(int key, int x, int y) {
		switch (key) {
		case 1:
			// Für alle Objecte die Oben eine gerade Fläche haben.
			// Linkssperre
			if (y - 1 == model.getPlayerORY() + 1 && x + 1 == model.getPlayerORX()
					|| y - 1 == model.getPlayerRY() + 1 && x + 1 == model.getPlayerRX()
					|| y - 1 == model.getPlayerULY() + 1 && x + 1 == model.getPlayerULX()
					|| y - 1 == model.getPlayerURY() + 1 && x + 1 == model.getPlayerURX()
					|| y - 1 == model.getPlayerOLY() + 1 && x + 1 == model.getPlayerOLX()) {
				return false;
				// Mittelsperre
			} else if (y - 1 == model.getPlayerORY() + 2 && x == model.getPlayerORX()
					|| y - 1 == model.getPlayerRY() + 1 && x + 1 == model.getPlayerRX() + 1
					|| y - 1 == model.getPlayerULY() + 1 && x + 1 == model.getPlayerULX() + 1
					|| y - 1 == model.getPlayerURY() + 1 && x + 1 == model.getPlayerURX() + 1
					|| y - 1 == model.getPlayerOLY() + 1 && x + 1 == model.getPlayerOLX() + 1) {
				return false;
				// Rechtssperre
			} else if (y - 1 == model.getPlayerORY() + 2 && x == model.getPlayerORX() + 1
					|| y - 1 == model.getPlayerRY() + 1 && x + 1 == model.getPlayerRX() + 2
					|| y - 1 == model.getPlayerULY() + 1 && x + 1 == model.getPlayerULX() + 2
					|| y - 1 == model.getPlayerURY() + 1 && x + 1 == model.getPlayerURX() + 2
					|| y - 1 == model.getPlayerOLY() && x == model.getPlayerOLX() + 1) {

				return false;
			} else {
				return true;
			}
		case 2:
			// für alle objekte die unten eine gerade fläche haben
			// Linkssperre
			if (y + 2 == model.getPlayerOLY() && x + 1 == model.getPlayerOLX()
					|| y + 1 == model.getPlayerORY() && x + 1 == model.getPlayerORX()
					|| y + 2 == model.getPlayerRY() && x + 1 == model.getPlayerRX()
					|| y + 2 == model.getPlayerULY() && x + 1 == model.getPlayerULX()
					|| y + 1 == model.getPlayerURY() && x + 1 == model.getPlayerURX()) {
				return false;
				// Mittelsperre
			} else if (y + 2 == model.getPlayerOLY() && x == model.getPlayerOLX()
					|| y + 1 == model.getPlayerORY() && x == model.getPlayerORX()
					|| y + 2 == model.getPlayerRY() && x == model.getPlayerRX()
					|| y + 2 == model.getPlayerULY() && x == model.getPlayerULX()
					|| y + 2 == model.getPlayerURY() && x == model.getPlayerURX()) {
				return false;
				// Rechtssperre
			} else if (y + 2 == model.getPlayerOLY() && x - 1 == model.getPlayerOLX()
					|| y + 1 == model.getPlayerORY() && x - 1 == model.getPlayerORX()
					|| y + 2 == model.getPlayerRY() && x - 1 == model.getPlayerRX()
					|| y + 1 == model.getPlayerULY() && x - 1 == model.getPlayerULX()
					|| y + 2 == model.getPlayerURY() && x - 1 == model.getPlayerURX()) {
				return false;
			} else {
				return true;
			}
		case 3:
			// für alle objekte die rechts eine gerade fläche haben
			// Obere Sperre
			if (x + 2 == model.getPlayerOLX() && y == model.getPlayerOLY() - 1
					|| x + 2 == model.getPlayerORX() && y == model.getPlayerORY()
					|| x + 2 == model.getPlayerULX() && y == model.getPlayerULY() - 1
					|| x + 1 == model.getPlayerURX() && y == model.getPlayerURY() - 1
					|| x + 2 == model.getPlayerRX() && y == model.getPlayerRY() - 1) {
				return false;
				// Mittlere Sperre
			} else if (x + 2 == model.getPlayerOLX() && y == model.getPlayerOLY()
					|| x + 2 == model.getPlayerORX() && y - 1 == model.getPlayerORY()
					|| x + 2 == model.getPlayerULX() && y == model.getPlayerULY()
					|| x + 2 == model.getPlayerURX() && y == model.getPlayerURY()
					|| x + 2 == model.getPlayerRX() && y == model.getPlayerRY()) {
				return false;
				// Untere Sperre
			} else if (x + 2 == model.getPlayerOLX() && y == model.getPlayerOLY() + 1
					|| x + 2 == model.getPlayerORX() + 1 && y - 2 == model.getPlayerORY()
					|| x + 2 == model.getPlayerULX() && y == model.getPlayerULY() + 1
					|| x + 2 == model.getPlayerURX() && y == model.getPlayerURY() + 1
					|| x + 2 == model.getPlayerRX() && y == model.getPlayerRY() + 1) {
				return false;
			} else {
				return true;
			}

		case 4:
			// für alle Objekte die links eine gerade fläche haben.
			// Obere Sperre
			if (x - 2 == model.getPlayerOLX() && y + 1 == model.getPlayerOLY()
					|| x - 2 == model.getPlayerORX() && y == model.getPlayerORY()
					|| x - 1 == model.getPlayerULX() && y + 1 == model.getPlayerULY()
					|| x - 2 == model.getPlayerURX() && y + 1 == model.getPlayerURY()
					|| x - 2 == model.getPlayerRX() && y + 1 == model.getPlayerRY()) {
				return false;
				// Mittlere Sperre
			} else if (x - 2 == model.getPlayerOLX() && y == model.getPlayerOLY()
					|| x - 2 == model.getPlayerORX() && y - 1 == model.getPlayerORY()
					|| x - 2 == model.getPlayerULX() && y == model.getPlayerULY()
					|| x - 2 == model.getPlayerURX() && y == model.getPlayerURY()
					|| x - 2 == model.getPlayerRX() && y == model.getPlayerRY()) {
				return false;
				// Untere Sperre
			} else if (x - 1 == model.getPlayerOLX() && y - 1 == model.getPlayerOLY()
					|| x - 2 == model.getPlayerORX() + 1 && y - 2 == model.getPlayerORY()
					|| x - 2 == model.getPlayerULX() && y - 1 == model.getPlayerULY()
					|| x - 2 == model.getPlayerURX() && y - 1 == model.getPlayerURY()
					|| x - 2 == model.getPlayerRX() && y - 1 == model.getPlayerRY()) {
				return false;
			} else {
				return true;
			}
		default:
			return false;
		}

	}
	
	
	@Override
	public void keyReleased(KeyEvent e) {
		
	}

}
