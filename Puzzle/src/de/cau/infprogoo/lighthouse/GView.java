package de.cau.infprogoo.lighthouse;

import java.awt.Color;

import acm.graphics.GCompound;
import acm.graphics.GLine;
import acm.graphics.GPolygon;



public class GView extends GCompound implements View {

	final static int WIDTH = 400;
	final static int HEIGHT = 600;
	// The background where we play in
	private final Figures backGrounder;
	// Our pieces
	private final Figures obenLinks;
	private final Figures obenRechts;
	private final Figures untenLinks;
	private final Figures untenRechts;
	private final Figures rechtEck;

	public GView() {
		backGrounder = new Figures("gitter", 0,0);
		add(backGrounder);

		obenLinks = new Figures("obenLinks", 50,0);
		add(obenLinks);
		
		obenRechts = new Figures("obenRechts", 0,0);
		add(obenRechts); 
		
		untenLinks = new Figures("untenLinks", 0,0);
		add(untenLinks);
		
		untenRechts = new Figures("untenRechts", 0,0);
		add(untenRechts);
		
		rechtEck = new Figures("rechteck", 0,0);
		add(rechtEck);
		
		

	}

	@Override
	public void update(Model world) {
		double cellWidth = WIDTH / world.getWIDTH();
		double cellHeight = HEIGHT / world.getHEIGHT();

		obenRechts.setLocation(Model.getPlayer1());
		
	}

}

class Figures extends GCompound {
	
	
public Figures(String figur,int x, int y) {
	
	switch(figur) {
	case "obenLinks":
		obenLinks(x,y);
		break;
	case "obenRechts":
		obenRechts(x,y);
		break;
	case "untenLinks":
		untenLinks(x,y);
		break;
	case "untenRechts":
		untenRechts(x,y);
		break;
	case "rechteck":
		rechteck(x,y);
		break;
	case "gitter":
		gitter();
		break;
	}
}
	

	public void obenLinks(int x, int y) {
		GPolygon obenL = new GPolygon(x, y);
		obenL.addPolarEdge(200, 90);
		obenL.addPolarEdge(200, 0);
		obenL.addPolarEdge(100, 270);
		obenL.addPolarEdge(100, 180);
		obenL.addPolarEdge(100, 270);
		obenL.addPolarEdge(100, 180);
		obenL.setLocation(5, 205);
		obenL.setFilled(true);
		obenL.setColor(Color.RED);
		add(obenL);
	}

	public void obenRechts(int x, int y) {
		GPolygon obenL = new GPolygon(x, y);
		obenL.addPolarEdge(100, 90);
		obenL.addPolarEdge(200, 0);
		obenL.addPolarEdge(200, 270);
		obenL.addPolarEdge(100, 180);
		obenL.addPolarEdge(100, 90);
		obenL.addPolarEdge(100, 180);
		obenL.setLocation(215, 105);
		obenL.setFilled(true);
		obenL.setColor(Color.BLUE);
		add(obenL);
	}

	public void untenLinks(int x, int y) {
		GPolygon obenL = new GPolygon(x, y);
		obenL.addPolarEdge(200, 90);
		obenL.addPolarEdge(100, 0);
		obenL.addPolarEdge(100, 270);
		obenL.addPolarEdge(100, 0);
		obenL.addPolarEdge(100, 270);
		obenL.addPolarEdge(200, 180);
		obenL.setLocation(5, 415);
		obenL.setFilled(true);
		obenL.setColor(Color.YELLOW);
		add(obenL);
	}

	public void untenRechts(int x, int y) {
		GPolygon obenL = new GPolygon(x, y);
		obenL.addPolarEdge(100, 90);
		obenL.addPolarEdge(100, 0);
		obenL.addPolarEdge(100, 90);
		obenL.addPolarEdge(100, 0);
		obenL.addPolarEdge(200, 270);
		obenL.addPolarEdge(200, 180);
		obenL.setLocation(215, 415);
		obenL.setFilled(true);
		obenL.setColor(Color.GREEN);
		add(obenL);
	}

	public void rechteck(int x, int y) {
		GPolygon obenL = new GPolygon(x, y);
		obenL.addPolarEdge(200, 90);
		obenL.addPolarEdge(200, 0);
		obenL.addPolarEdge(200, 270);
		obenL.addPolarEdge(200, 180);
		obenL.setLocation(110, 310);
		obenL.setFilled(true);
		obenL.setColor(Color.ORANGE);
		add(obenL);
	}

	public void gitter() {
		for (int i = 0; i < 7; i++) {
			GLine obenL = new GLine(0, 0 + i * 105, 420, 0 + i * 105);
			add(obenL);
		}
		for (int i = 0; i < 5; i++) {
			GLine obenL = new GLine(0 + i * 105, 0, 0 + i * 105, 630);
			add(obenL);
		}
	}
}
