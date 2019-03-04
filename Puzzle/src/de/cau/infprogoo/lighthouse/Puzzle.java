package de.cau.infprogoo.lighthouse;

import java.awt.Color;


import acm.program.GraphicsProgram;


public class Puzzle extends GraphicsProgram{
	@Override
	public void init() {
		this.setBackground(Color.GRAY);
		setSize(500,700);
		// Create the world
		Model world = new Model(4, 6);

		// Create two views and let the world know about them
		GView gview = new GView();
		add(gview);
		world.registerView(gview);
		
		
		LighthouseDisplay display = new LighthouseDisplay("die_dicke_KATZE", "API-TOK_ySnj-ST3X-GqJm-mprn-Pt9o");

		
	
		new GController(world, this);

		
	}


}
