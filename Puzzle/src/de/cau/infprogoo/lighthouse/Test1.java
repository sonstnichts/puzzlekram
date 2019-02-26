package de.cau.infprogoo.lighthouse;



import java.awt.Color;

import acm.graphics.GCompound;
import acm.graphics.GLine;
import acm.graphics.GPolygon;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;

public class Test1 extends GraphicsProgram {

	public void run() {
		
		setSize(425, 635);
		add(new gitter());
		add(new obenlinks());
		add(new obenrechts());
		add(new untenlinks());
		add(new untenrechts());
		add(new rechteck());
	}

}

class obenlinks extends GCompound {

	public obenlinks() {

		GPolygon obenL = new GPolygon();
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

class obenrechts extends GCompound {

	public obenrechts() {

		GPolygon obenL = new GPolygon();
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

class untenlinks extends GCompound {

	public untenlinks() {

		GPolygon obenL = new GPolygon();
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

class untenrechts extends GCompound {

	public untenrechts() {

		GPolygon obenL = new GPolygon();
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

class rechteck extends GCompound {

	public rechteck() {

		GPolygon obenL = new GPolygon();
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

class gitter extends GCompound {

	public gitter() {

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