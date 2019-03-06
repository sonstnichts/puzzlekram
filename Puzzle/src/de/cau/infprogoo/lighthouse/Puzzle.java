package de.cau.infprogoo.lighthouse;

import java.awt.Color;

import acm.program.GraphicsProgram;


public class Puzzle extends GraphicsProgram{
	@Override
	public void init() {
		this.setBackground(Color.GRAY);
		setSize(500,700);
		// Create the world
		Model model = new Model(4, 6);

		// Create two views and let the world know about them
		GView gview = new GView();
		model.registerView(gview);
		add(gview);
	
		
		LighthouseView display = new LighthouseView("die_dicke_KATZE", "API-TOK_Aem9-K+La-ibUC-H41Q-Ub2o");
		model.registerView(display);
		display.connect();
		
	
		new GController(model, this);

		
	}

	


}
