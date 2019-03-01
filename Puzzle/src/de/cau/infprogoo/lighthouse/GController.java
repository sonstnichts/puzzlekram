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

	@Override
	public void keyReleased(KeyEvent e) {
		
	}

}
