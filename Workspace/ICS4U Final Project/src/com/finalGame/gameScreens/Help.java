package com.finalGame.gameScreens;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Random;

import com.finalGame.mainPackage.Game;
import com.finalGame.mainPackage.Handler;

/**
 * Help screen
 * Can be reached from menu
 * 
 * Authors: Dinu, Hita, & Asha
 * 
 */

public class Help {
	private Game game;
	private Handler handler;
	private Random r;
	
	public Help(Game game) {
		this.game = game;
		this.handler = game.getHandler();
	}

	public void tick() {
		
	}
	
	public void render(Graphics g) {
		Font fnt = new Font("arial", 1, 15);
		Font fnt2 = new Font("arial", 1, 30);
		
		g.setColor(Color.white);
		
		g.setFont(fnt2);
		g.drawString("Spacebar = Shoot", 155, 100); 
		g.drawString("Shift = Open Door*", 155, 200); 
		g.setFont(fnt);
		g.drawString("*You must kill all enemies to get the key first!", 155, 220);
		g.drawString("Shoots in direction of travel", 155, 120);
		g.setFont(fnt2);
		g.drawString("Backspace to go back to menu", 155, 350);
		
	}

}
