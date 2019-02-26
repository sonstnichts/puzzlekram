package de.cau.infprogoo.lighthouse;

import java.awt.Color;

import acm.graphics.GCompound;
import acm.graphics.GLine;
import acm.graphics.GPolygon;
import acm.program.GraphicsProgram;

public class GView extends GraphicsProgram implements View {


	@Override
	public void update(Model world) {
		// TODO Auto-generated method stub
		
	}
	
	

}
class Obenlinks extends GCompound {

	public Obenlinks(int x, int y) {

		GPolygon obenL = new GPolygon(x, y);
		obenL.addPolarEdge(200, 90);
		obenL.addPolarEdge(200, 0);
		obenL.addPolarEdge(100, 270);
		obenL.addPolarEdge(100, 180);
		obenL.addPolarEdge(100, 270);
		obenL.addPolarEdge(100, 180);
		obenL.move(5, 205);
		obenL.setFilled(true);
		obenL.setColor(Color.RED);
		add(obenL);

	}
}

class Obenrechts extends GCompound {

	public Obenrechts(int x, int y) {

		GPolygon obenL = new GPolygon(x, y);
		obenL.addPolarEdge(100, 90);
		obenL.addPolarEdge(200, 0);
		obenL.addPolarEdge(200, 270);
		obenL.addPolarEdge(100, 180);
		obenL.addPolarEdge(100, 90);
		obenL.addPolarEdge(100, 180);
		obenL.move(215, 105);
		obenL.setFilled(true);
		obenL.setColor(Color.BLUE);
		add(obenL);

	}
}
class Untenlinks extends GCompound {

	public Untenlinks(int x, int y) {

		GPolygon obenL = new GPolygon(x, y);
		obenL.addPolarEdge(200, 90);
		obenL.addPolarEdge(100, 0);
		obenL.addPolarEdge(100, 270);
		obenL.addPolarEdge(100, 0);
		obenL.addPolarEdge(100, 270);
		obenL.addPolarEdge(200, 180);
		obenL.move(5, 415);
		obenL.setFilled(true);
		obenL.setColor(Color.YELLOW);
		add(obenL);

	}
}
class Untenrechts extends GCompound {

	public Untenrechts(int x, int y) {

		GPolygon obenL = new GPolygon(x, y);
		obenL.addPolarEdge(100, 90);
		obenL.addPolarEdge(100, 0);
		obenL.addPolarEdge(100, 90);
		obenL.addPolarEdge(100, 0);
		obenL.addPolarEdge(200, 270);
		obenL.addPolarEdge(200, 180);
		obenL.move(215, 415);
		obenL.setFilled(true);
		obenL.setColor(Color.GREEN);
		add(obenL);

	}
}

class Rechteck extends GCompound {

	public Rechteck(int x, int y) {

		GPolygon obenL = new GPolygon(x, y);
		obenL.addPolarEdge(200, 90);
		obenL.addPolarEdge(200, 0);
		obenL.addPolarEdge(200, 270);
		obenL.addPolarEdge(200, 180);
		obenL.move(110, 310);
		obenL.setFilled(true);
		obenL.setColor(Color.gray);
		add(obenL);

	}
}

class Gitter extends GCompound {

	public Gitter() {

		for (int i = 0; i <7 ; i++) {
			GLine obenL = new GLine(0, 0+i*105, 420, 0+i*105);
			add(obenL);
		}
		for (int i = 0; i <5 ; i++) {
			GLine obenL = new GLine(0+i*105, 0,0+i*105,630);
			add(obenL);
		}
		

	}
}