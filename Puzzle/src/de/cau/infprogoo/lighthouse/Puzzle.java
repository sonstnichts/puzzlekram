package de.cau.infprogoo.lighthouse;

import java.awt.Color;
import java.io.IOException;

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
		add(gview);
		model.registerView(gview);
	
		
//		
//		LighthouseView display = new LighthouseView("die_dicke_KATZE", "API-TOK_Aem9-K+La-ibUC-H41Q-Ub2o");
//		display.connect();
//		model.registerView(display);
		
	
		new GController(model, this);

		
	}

	


}
