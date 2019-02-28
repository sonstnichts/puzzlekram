package de.cau.infprogoo.lighthouse;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GController implements KeyListener {

	/** The world that is updated upon every key press. */
	private Model model;

	public GController(Model model, Puzzle puzzle) {

		this.model = model;

		puzzle.getGCanvas().addKeyListener(this);

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		boolean relevantKey = false;
		
		

		// ObenLinks bewegt sich (rot)
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

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
