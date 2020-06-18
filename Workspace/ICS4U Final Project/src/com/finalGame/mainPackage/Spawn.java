package com.finalGame.mainPackage;

import java.util.Random;

import com.finalGame.gameObjects.BasicEnemy;
import com.finalGame.gameObjects.Bullet;
import com.finalGame.gameObjects.DoorObject;
import com.finalGame.gameObjects.HealthPowerUp;
import com.finalGame.gameObjects.KeyObject;
import com.finalGame.gameObjects.Player;

/**
 * Spawns all entities into game
 * Sometimes spawns randomly, and sometimes in specific spots
 * 
 * Authors: Dinu, Hita, & Asha
 * 
 */
public class Spawn {
	
	private Game game;
	private Handler handler;
	private Random rand = new Random();
	private int enemyCount = 0;
	
	public Spawn(Game game) {
		this.game = game;
		this.handler = game.getHandler();
	}
	
	public void tick() {
		
	}
	
	private int randInt(int min, int max) {
	    int randomNum = rand.nextInt((max - min) + 1) + min;
	    return randomNum;
	}
	
	public void spawnEnemy() {
		int xCoord = randInt(10, game.getWidth()-10);
		int yCoord = randInt(60, game.getHeight()-10);
		handler.addObject(new BasicEnemy(xCoord, yCoord, ID.BasicEnemy, 16, 16, game));
		enemyCount++;
	}
	
	public void spawnDoorTop() {
		handler.addObject(new DoorObject(game.getWidth()/2, 60, ID.Door, 25, 25, game));
	}
	
	public void spawnDoorBottom() {
		handler.addObject(new DoorObject(game.getWidth()/2,game.getHeight()-47, ID.Door, 25, 25, game));
	}
	
	public void spawnBullet(String direction) {
		Player player = game.getPlayGame().getPlayer();
		int velX = 0;
		int velY = 0;
		int xCoord = player.getX();
		int yCoord = player.getY();
		
		if(direction == "North") {
			velY= -10;
			xCoord+=12;
		}
		if(direction == "South") {
			velY = 10;
			xCoord+=12;
		}
		if(direction == "East") {
			velX = 10;
			yCoord+=12;
		}
		if(direction == "West") {
			velX = -10;
			yCoord+=12;
		}
		handler.addObject(new Bullet(xCoord, yCoord, ID.Bullet, 8, 8, game, velX, velY));
	}
	
	public void enemyKilled(int xCoord, int yCoord) {
		enemyCount--;
		if(enemyCount <= 0) {
			spawnKey(xCoord, yCoord);
		}
	}
	
	public void newLevel(int level) {
		if (!(level == 1 || level == 2 || level == 3)) {
			int enemies = randInt(level-2, level +2);
			for (int i = 0; i < enemies; i++) {
				spawnEnemy();
			}
		} else {
			for(int i = 0; i < level; i++) {
				spawnEnemy();
			}
		}
	}
	
	public void spawnHealthPowerUp(int xCoord, int yCoord) {
		int chance = randInt(0, 100);
		if (chance < 33) {
			handler.addObject(new HealthPowerUp(xCoord, yCoord, ID.HealthPowerUp, 5, 5, game));
		}
	}
	
	private void spawnKey(int xCoord, int yCoord) {
		handler.addObject(new KeyObject(xCoord, yCoord, ID.Key, 5, 5, game));
	}
	
	public void setEnemyCount(int enemyCount) {
		this.enemyCount = enemyCount;
	}
	
	
	

}
