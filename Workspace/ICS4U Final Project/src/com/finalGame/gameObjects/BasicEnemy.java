package com.finalGame.gameObjects;

import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;

import com.finalGame.gameScreens.PlayGame;
import com.finalGame.mainPackage.Game;
import com.finalGame.mainPackage.ID;

public class BasicEnemy extends GameObject{
	
	private Player player;
	private Game game;
	private LinkedList<GameObject> object;
	private int enemyHealth = 50;
	
	public BasicEnemy(int x, int y, ID id, int WIDTH, int HEIGHT, Game game) {
		super(x, y, id, WIDTH, HEIGHT);
		this.velX = 2;
		this.velY = 2;
		this.game = game;
		this.player = game.getPlayGame().getPlayer();
	
	}

	public void tick() {
		if (this.x < player.getX()) x += velX;
		else if (this.x > player.getX())x -= velX;
		
		if (this.y < player.getY()) y += velY;
		else if (this.y > player.getY()) y -= velY;
		
		if (this.rect.intersects(player.rect)) {
			player.setHealth(player.getHealth() - 1);
			this.setVelX(0);
			this.setVelY(0);
		} else {
			this.setVelX(2);
			this.setVelY(2);
		}
		
		object = game.getHandler().getObject();
		
		for(int i = 0; i < object.size(); i++) {
			GameObject tempObject = object.get(i);
			
			if (tempObject.id == ID.Bullet) {
				if (tempObject.rect.intersects(this.rect)) {
					enemyHealth--;
				}
			}
			
		}
		
		this.rect.x = x;
		this.rect.y = y;
		
		//prevents player from leaving bounds of game
		x = game.clamp(x, 0, game.getWidth()-38);
		y = game.clamp(y, 60, game.getHeight()-60);
		
		if (enemyHealth <= 0) {
			game.getHandler().removeObject(this);
		}
	}
	
	public void render(Graphics g) {
		g.setColor(Color.orange);
		g.fillRect(x, y, WIDTH , HEIGHT);
		
	}
	
	

}
