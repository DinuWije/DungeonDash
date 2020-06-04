package com.ics4u.finalproj;

import java.awt.Color;
import java.awt.Graphics;

public class BasicEnemy extends GameObject{
	
	public BasicEnemy(int x, int y, ID id, int WIDTH, int HEIGHT) {
		super(x, y, id, WIDTH, HEIGHT);
		this.velX = 2;
		this.velY = 2;
	
	}

	public void tick() {
		if (this.x < PlayGame.player.getX()) x += velX;
		else if (this.x > PlayGame.player.getX())x -= velX;
		
		if (this.y < PlayGame.player.getY()) y += velY;
		else if (this.y > PlayGame.player.getY()) y -= velY;
		
		if (this.rect.intersects(PlayGame.player.rect)) {
			Game.hud.setHealth(Game.hud.getHealth() - 1);
			this.setVelX(0);
			this.setVelY(0);
			
		} else {
			this.setVelX(2);
			this.setVelY(2);
		}
		
		this.rect.x = x;
		this.rect.y = y;
		
		//prevents player from leaving bounds of game (doesn't force the player to bounce off walls)	
		x = Game.clamp(x, 0, Game.WIDTH-38);
		y = Game.clamp(y, 0, Game.HEIGHT-60);
	}
	
	public void render(Graphics g) {
		g.setColor(Color.orange);
		g.fillRect(x, y, WIDTH , HEIGHT);
	}
	
	

}
