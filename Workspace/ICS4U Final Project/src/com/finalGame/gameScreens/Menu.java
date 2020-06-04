package com.finalGame.gameScreens;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import com.finalGame.mainPackage.Game;
import com.finalGame.mainPackage.Handler;

public class Menu {
	
	private Game game;
	private Handler handler;
	private Random r;
	
	public Menu(Game game) {
		this.game = game;
		this.handler = game.getHandler();
	}

	public void tick() {
		
	}
	
	public void render(Graphics g) {
		Font fnt = new Font("arial", 1, 50);
		Font fnt2 = new Font("arial", 1, 30);
		Font fnt3 = new Font("arial", 1, 15);
		
		g.setColor(Color.white);
		
		if (Game.gameState == Game.STATE.Menu) {
			g.setFont(fnt2);
			g.drawString("Press Space to Begin", 155, 100);
		} 
		
	}
	

}