package com.ics4u.finalproj;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class GameOver {
	
	GameOver(){
	}
	
	public void tick() {
	}
	
	public void render(Graphics g) {
		
		Font fnt1 = new Font("arial", 1, 50);
		Font fnt2 = new Font("arial", 1, 30);
	
		g.setColor(Color.red);
		g.setFont(fnt1);
		g.drawString("Game Over", 180, 100);
		
		g.setColor(Color.white);
		g.setFont(fnt2);
		g.drawString("Press Space to Return to Menu", 100, 150);
		
	}

}
