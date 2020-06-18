package com.finalGame.gameObjects;

import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;

import com.finalGame.mainPackage.Game;
import com.finalGame.mainPackage.ID;

/**
 * Simple bullet class
 * 
 * Authors: Dinu, Hita, & Asha
 * 
 */
public class Bullet extends GameObject{
	
	Game game;

	public Bullet(int x, int y, ID id, int WIDTH, int HEIGHT, Game game, int velX, int velY) {
		super(x, y, id, WIDTH, HEIGHT);
		this.game = game;
		this.velX = velX;
		this.velY = velY;
	}

	@Override
	public void tick() {
		x += velX; 
		y += velY;
		this.rect.x = x;
		this.rect.y = y;
		
		//deletes bullet if it leaves game bounds
		if(this.x > game.getWidth() || this.x < 0) {
			game.getHandler().removeObject(this);
		}
		if(this.y > game.getHeight() || this.y < 0) {
			game.getHandler().removeObject(this);
		}
		
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(x, y, WIDTH, HEIGHT);
	}

}
