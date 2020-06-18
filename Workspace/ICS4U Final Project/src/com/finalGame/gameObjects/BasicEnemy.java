package com.finalGame.gameObjects;

import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;
import java.util.Random;

import com.finalGame.gameScreens.PlayGame;
import com.finalGame.mainPackage.Game;
import com.finalGame.mainPackage.ID;


/**
 * Main code for enemy
 * Tracks enemy health
 * Has enemy travel towards player
 * Checks if enemy is shot
 * Updates mini health bar for enemy
 * 
 * Authors: Dinu, Hita, & Asha
 * 
 */

public class BasicEnemy extends GameObject{
	
	private Player player;
	private Game game;
	private LinkedList<GameObject> object;
	private final int baseEnemyHealth = 50;
	private int enemyHealth = baseEnemyHealth;
	private Random rand = new Random();
	private int randX = randInt(1,2);
	private int randY = randInt(1,2);
	
	public BasicEnemy(int x, int y, ID id, int WIDTH, int HEIGHT, Game game) {
		super(x, y, id, WIDTH, HEIGHT);
		velX = randX;
		velY = randY;
		this.game = game;
		this.player = game.getPlayGame().getPlayer();
	
	}
	
	private int randInt(int min, int max) {
	    int randomNum = rand.nextInt((max - min) + 1) + min;
	    return randomNum;
	}

	public void tick() {
		
		//enemy travels towards player
		if (this.x < player.getX()) x += velX;
		else if (this.x > player.getX())x -= velX;
		
		if (this.y < player.getY()) y += velY;
		else if (this.y > player.getY()) y -= velY;
		
		if (this.rect.intersects(player.rect)) {
			player.setHealth(player.getHealth() - 1);
			this.setVelX(0);
			this.setVelY(0);
		} else {
			this.setVelX(randX);
			this.setVelY(randY);
		}
		
		//checks if enemy is hit by bullet
		object = game.getHandler().getObject();
		
		for(int i = 0; i < object.size(); i++) {
			GameObject tempObject = object.get(i);
			
			if (tempObject.id == ID.Bullet) {
				if (tempObject.rect.intersects(this.rect)) {
					enemyHealth -= 5;
				}
			}	
		}
		
		this.rect.x = x;
		this.rect.y = y;
		
		//prevents player from leaving bounds of game
		x = game.clamp(x, 0, game.getWidth()-38);
		y = game.clamp(y, 60, game.getHeight()-60);
		
		//once enemy dies:
		if (enemyHealth <= 0) {
			game.getHUD().enemyKilled();
			game.getSpawner().enemyKilled(x, y);
			game.getSpawner().spawnHealthPowerUp(x, y);
			game.getHandler().removeObject(this);
		}
	}
	
	public void render(Graphics g) {
		g.setColor(Color.red); 
		g.fillRect(x, y, WIDTH , HEIGHT);
		
		
		g.setColor(Color.gray);
		g.fillRect(x-5, y-5, 25, 2);
		
		//changes color of health bar based on health level
		if (enemyHealth >= baseEnemyHealth/2) {
			g.setColor(Color.green);
			g.fillRect(x-5, y-5, enemyHealth/2, 2);
		}
		else if (enemyHealth >= ((baseEnemyHealth/2)/2) && enemyHealth < baseEnemyHealth/2) {
			g.setColor(Color.orange);
			g.fillRect(x-5, y-5, enemyHealth/2, 2);
		}
		else if(enemyHealth < ((baseEnemyHealth/2)/2) && enemyHealth > 0) {
			g.setColor(Color.red);
			g.fillRect(x-5, y-5, enemyHealth/2, 2);
		}
		
	}
	

}
