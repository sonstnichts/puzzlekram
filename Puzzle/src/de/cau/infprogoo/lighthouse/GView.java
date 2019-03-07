package de.cau.infprogoo.lighthouse;

import java.awt.Color;
import acm.graphics.GCompound;
import acm.graphics.GLabel;
import acm.graphics.GLine;
import acm.graphics.GPolygon;

public class GView extends GCompound implements View {

	
	final static int WIDTH = 400;
	final static int HEIGHT = 600;

	// Our pieces
	private final GLine backGrounder;
	private final ObenLinks obenLinks;
	private final ObenRechts obenRechts;
	private final UntenLinks untenLinks;
	private final UntenRechts untenRechts;
	private final Rechteck rechteck;

	public GView() {
		
		// Figuren initialisieren
		obenLinks = new ObenLinks();
		add(obenLinks);

		obenRechts = new ObenRechts();
		add(obenRechts);

		untenLinks = new UntenLinks();
		add(untenLinks);

		untenRechts = new UntenRechts();
		add(untenRechts);

		rechteck = new Rechteck();
		add(rechteck);

		backGrounder = gitter();
		
		GLabel anleitung = new GLabel("Klicken für Start", 0,610);
		GLabel anleitung2 = new GLabel("Figur mit 1-5 auswählen", 0, 625);
		GLabel anleitung3 = new GLabel("Pfeiltasten zum Steuern", 0, 640);
		GLabel anleitung4 = new GLabel("R - Reset", 0, 655);
		GLabel anleitung5 = new GLabel("Q - Quit", 200, 610);
		add(anleitung5);
		add(anleitung4);
		add(anleitung3);
		add(anleitung2);
		add(anleitung);

	}

	@Override
	public void update(Model model) {
		double cellWidth = WIDTH / model.getWIDTH();
		double cellHeight = HEIGHT / model.getHEIGHT();
		// Location update
		obenRechts.setLocation(model.getPlayerORX() * cellWidth, model.getPlayerORY() * cellHeight);
		obenLinks.setLocation(model.getPlayerOLX() * cellWidth, model.getPlayerOLY() * cellHeight);
		untenLinks.setLocation(model.getPlayerULX() * cellWidth, model.getPlayerULY() * cellHeight);
		untenRechts.setLocation(model.getPlayerURX() * cellWidth, model.getPlayerURY() * cellHeight);
		rechteck.setLocation(model.getPlayerRX() * cellWidth, model.getPlayerRY() * cellHeight);
		
	}
	

	

	public GLine gitter() {
		for (int i = 0; i < 7; i++) {
			GLine obenL = new GLine(0, 0 + i * 100, 400, 0 + i * 100);
			add(obenL);
		}
		for (int i = 0; i < 5; i++) {
			GLine obenL = new GLine(0 + i * 100, 0, 0 + i * 100, 600);
			add(obenL);
		}
		return backGrounder;
	}

	/**
	 * Winkel-Objekt oben links.
	 * 
	 * @author olegattow
	 *
	 */
	class ObenLinks extends GCompound {

		public ObenLinks() {
			GPolygon obenL = new GPolygon();
			obenL.addPolarEdge(200, 90);
			obenL.addPolarEdge(200, 0);
			obenL.addPolarEdge(100, 270);
			obenL.addPolarEdge(100, 180);
			obenL.addPolarEdge(100, 270);
			obenL.addPolarEdge(100, 180);
			obenL.setFilled(true);
			obenL.setColor(Color.RED);
			add(obenL);
			GLabel nummer = new GLabel("1");
			nummer.setLocation(50, -100);
			add(nummer);
		}

	}

	/**
	 * Winkel-Objekt oben rechts.
	 * 
	 * @author olegattow
	 *
	 */
	class ObenRechts extends GCompound {

		public ObenRechts() {
			GPolygon obenL = new GPolygon();
			obenL.addPolarEdge(100, 90);
			obenL.addPolarEdge(200, 0);
			obenL.addPolarEdge(200, 270);
			obenL.addPolarEdge(100, 180);
			obenL.addPolarEdge(100, 90);
			obenL.addPolarEdge(100, 180);
			obenL.setFilled(true);
			obenL.setColor(Color.BLUE);
			add(obenL);
			GLabel nummer = new GLabel("2");
			nummer.setLocation(150, 0);
			add(nummer);
		}

	}

	/**
	 * Winkel-Objekt unten links.
	 * 
	 * @author olegattow
	 *
	 */
	class UntenLinks extends GCompound {

		public UntenLinks() {
			GPolygon obenL = new GPolygon();
			obenL.addPolarEdge(200, 90);
			obenL.addPolarEdge(100, 0);
			obenL.addPolarEdge(100, 270);
			obenL.addPolarEdge(100, 0);
			obenL.addPolarEdge(100, 270);
			obenL.addPolarEdge(200, 180);
			obenL.setFilled(true);
			obenL.setColor(Color.YELLOW);
			add(obenL);
			GLabel nummer = new GLabel("3");
			nummer.setLocation(50, -100);
			add(nummer);
		}

	}

	/**
	 * Winkel-Objekt unten rechts.
	 * 
	 * @author olegattow
	 *
	 */
	class UntenRechts extends GCompound {

		public UntenRechts() {
			GPolygon obenL = new GPolygon();
			obenL.addPolarEdge(100, 90);
			obenL.addPolarEdge(100, 0);
			obenL.addPolarEdge(100, 90);
			obenL.addPolarEdge(100, 0);
			obenL.addPolarEdge(200, 270);
			obenL.addPolarEdge(200, 180);
			obenL.setFilled(true);
			obenL.setColor(Color.GREEN);
			add(obenL);
			GLabel nummer = new GLabel("4");
			nummer.setLocation(150, -100);
			add(nummer);

		}

	}

	/**
	 * Rechteck.
	 * 
	 * @author olegattow
	 *
	 */
	class Rechteck extends GCompound {

		GPolygon obenL = new GPolygon();

		public Rechteck() {
			obenL.addPolarEdge(200, 90);
			obenL.addPolarEdge(200, 0);
			obenL.addPolarEdge(200, 270);
			obenL.addPolarEdge(200, 180);
			obenL.setFilled(true);
			obenL.setColor(Color.ORANGE);
			add(obenL);
			GLabel nummer = new GLabel("5");
			nummer.setLocation(100, -100);
			add(nummer);
		}

	}

}
