package de.cau.infprogoo.lighthouse;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GController implements KeyListener {

	/** The world that is updated upon every key press. */
	private Model model;

	private int count;

	/**
	 * Speichert die zuletzt ausgewählte Figur.
	 */
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

		// Saves the keycode between 1-5 to choose a Piece
		if (e.getKeyCode() == KeyEvent.VK_1 || e.getKeyCode() == KeyEvent.VK_2 || e.getKeyCode() == KeyEvent.VK_3
				|| e.getKeyCode() == KeyEvent.VK_4 || e.getKeyCode() == KeyEvent.VK_5) {
			previous = e.getKeyCode();

		}

		if (e.getKeyCode() == KeyEvent.VK_R) {
			model.restart();
			previous = 0;
			model.count = 0;
		}

		if (e.getKeyCode() == KeyEvent.VK_W) {
			model.count = 25;
			model.win();
			previous = 0;
		}

		// ObenLinks bewegt sich (rot)
		if (previous == KeyEvent.VK_1) {
			switch (e.getKeyCode()) {
			case KeyEvent.VK_UP:
				if (checkpos(1, model.getPlayerOLX(), model.getPlayerOLY())) {
					model.setPlayerOLY(Math.max(2, model.getPlayerOLY() - 1));
					if (model.noNazi()) {
						model.restart();
						previous = 0;
					}

				}
				break;
			case KeyEvent.VK_DOWN:
				if (checkOL2(model.getPlayerOLX(), model.getPlayerOLY())) {
					model.setPlayerOLY(Math.min(model.getHEIGHT(), model.getPlayerOLY() + 1));
					if (model.noNazi()) {
						model.restart();
						previous = 0;
					}

				}
				break;
			case KeyEvent.VK_RIGHT:
				if (checkOL3(model.getPlayerOLX(), model.getPlayerOLY())) {
					model.setPlayerOLX(Math.min(model.getWIDTH() - 2, model.getPlayerOLX() + 1));
					if (model.noNazi()) {
						model.restart();
						previous = 0;
					}

				}
				break;
			case KeyEvent.VK_LEFT:
				if (checkpos(4, model.getPlayerOLX(), model.getPlayerOLY())) {
					model.setPlayerOLX(Math.max(0, model.getPlayerOLX() - 1));
					if (model.noNazi()) {
						model.restart();
						previous = 0;
					}

				}
				break;
			}
		}

		// Blau
		if (previous == KeyEvent.VK_2) {
			switch (e.getKeyCode()) {
			case KeyEvent.VK_UP:
				if (wavecheck(1, model.getPlayerORX(), model.getPlayerORY())) {
					model.setPlayerORY(Math.max(1, model.getPlayerORY() - 1));
					if (model.noNazi()) {
						model.restart();
						previous = 0;
					}

				}
				break;
			case KeyEvent.VK_DOWN:
				if (wavecheck(2, model.getPlayerORX(), model.getPlayerORY())) {
					model.setPlayerORY(Math.min(model.getHEIGHT() - 1, model.getPlayerORY() + 1));
					if (model.noNazi()) {
						model.restart();
						previous = 0;
					}

				}
				break;
			case KeyEvent.VK_RIGHT:
				if (wavecheck(3, model.getPlayerORX(), model.getPlayerORY())) {
					model.setPlayerORX(Math.min(model.getWIDTH() - 2, model.getPlayerORX() + 1));
					if (model.noNazi()) {
						model.restart();
						previous = 0;
					}

				}
				break;
			case KeyEvent.VK_LEFT:
				if (wavecheck(4, model.getPlayerORX(), model.getPlayerORY())) {
					model.setPlayerORX(Math.max(0, model.getPlayerORX() - 1));
					if (model.noNazi()) {
						model.restart();
						previous = 0;
					}

				}
				break;
			}
		}
		// Gelb
		if (previous == KeyEvent.VK_3) {
			switch (e.getKeyCode()) {
			case KeyEvent.VK_UP:
				if (checkUL1(model.getPlayerULX(), model.getPlayerULY())) {
					model.setPlayerULY(Math.max(2, model.getPlayerULY() - 1));
					if (model.noNazi()) {
						model.restart();
						previous = 0;
					}

				}
				break;
			case KeyEvent.VK_DOWN:
				if (checkpos(2, model.getPlayerULX(), model.getPlayerULY())) {
					model.setPlayerULY(Math.min(model.getHEIGHT(), model.getPlayerULY() + 1));
					if (model.noNazi()) {
						model.restart();
						previous = 0;
					}

				}
				break;
			case KeyEvent.VK_RIGHT:
				if (checkUL3(model.getPlayerULX(), model.getPlayerULY())) {
					model.setPlayerULX(Math.min(model.getWIDTH() - 2, model.getPlayerULX() + 1));
					if (model.noNazi()) {
						model.restart();
						previous = 0;
					}

				}
				break;
			case KeyEvent.VK_LEFT:
				if (checkpos(4, model.getPlayerULX(), model.getPlayerULY())) {
					model.setPlayerULX(Math.max(0, model.getPlayerULX() - 1));
					if (model.noNazi()) {
						model.restart();
						previous = 0;
					}

				}
				break;
			}
		}
		// Grün
		if (previous == KeyEvent.VK_4) {
			switch (e.getKeyCode()) {
			case KeyEvent.VK_UP:
				if (checkUR1(model.getPlayerURX(), model.getPlayerURY())) {
					model.setPlayerURY(Math.max(2, model.getPlayerURY() - 1));
					if (model.noNazi()) {
						model.restart();
						previous = 0;
					}

				}
				break;
			case KeyEvent.VK_DOWN:
				if (checkpos(2, model.getPlayerURX(), model.getPlayerURY())) {
					model.setPlayerURY(Math.min(model.getHEIGHT(), model.getPlayerURY() + 1));
					if (model.noNazi()) {
						model.restart();
						previous = 0;
					}

				}
				break;
			case KeyEvent.VK_RIGHT:
				if (checkpos(3, model.getPlayerURX(), model.getPlayerURY())) {
					model.setPlayerURX(Math.min(model.getWIDTH() - 2, model.getPlayerURX() + 1));
					if (model.noNazi()) {
						model.restart();
						previous = 0;
					}

				}
				break;
			case KeyEvent.VK_LEFT:
				if (checkUR4(model.getPlayerURX(), model.getPlayerURY())) {
					model.setPlayerURX(Math.max(0, model.getPlayerURX() - 1));
					if (model.noNazi()) {
						model.restart();
						previous = 0;
					}

				}
				break;
			}
		}
		// Rechteck
		if (previous == KeyEvent.VK_5) {
			switch (e.getKeyCode()) {
			case KeyEvent.VK_UP:
				if (checkpos(1, model.getPlayerRX(), model.getPlayerRY())) {
					model.setPlayerRY(Math.max(2, model.getPlayerRY() - 1));

				}
				break;
			case KeyEvent.VK_DOWN:
				if (checkpos(2, model.getPlayerRX(), model.getPlayerRY())) {
					model.setPlayerRY(Math.min(model.getHEIGHT(), model.getPlayerRY() + 1));

				}
				break;
			case KeyEvent.VK_RIGHT:
				if (checkpos(3, model.getPlayerRX(), model.getPlayerRY())) {
					model.setPlayerRX(Math.min(model.getWIDTH() - 2, model.getPlayerRX() + 1));

				}
				break;
			case KeyEvent.VK_LEFT:
				if (checkpos(4, model.getPlayerRX(), model.getPlayerRY())) {
					model.setPlayerRX(Math.max(0, model.getPlayerRX() - 1));

				}
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
	 * 
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
