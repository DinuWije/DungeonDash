package com.ics4u.finalproj;

import java.awt.Color;
import java.awt.Graphics;

public class Player extends GameObject{
	
	public Player(int x, int y, ID id, int WIDTH, int HEIGHT) {
		super(x, y, id, WIDTH, HEIGHT);
	
	}

	public void tick() {
		x += velX;
		y += velY;
		this.rect.x = x;
		this.rect.y = y;
		
		//prevents player from leaving bounds of game (doesn't force the player to bounce off walls)	
		x = Game.clamp(x, 0, Game.WIDTH-38);
		y = Game.clamp(y, 0, Game.HEIGHT-60);
	}
	
	public void render(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(x, y, WIDTH , HEIGHT);
	}
	
	

}
