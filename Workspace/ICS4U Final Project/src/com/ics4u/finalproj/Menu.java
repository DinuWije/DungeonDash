package com.ics4u.finalproj;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Menu extends MouseAdapter{
	
	private Game game;
	private Handler handler;
	private Random r;
	Player player;
	
	public Menu(Game game, Handler handler) {
		this.game = game;
		this.handler = handler;
	}
	
	
	public void tick() {
		
	}
	
	public void render(Graphics g) {
		Font fnt = new Font("arial", 1, 50);
		Font fnt2 = new Font("arial", 1, 30);
		Font fnt3 = new Font("arial", 1, 15);
		g.setColor(Color.white);
		
		//different graphics & screens for different game states
		if (Game.gameState == Game.STATE.Menu) {
			g.setFont(fnt);
			g.drawString("Final Project", 210, 70);
						
		} 
	}
	

}