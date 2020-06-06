package com.finalGame.mainPackage;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import com.finalGame.gameObjects.Player;
import com.finalGame.gameScreens.PlayGame;

public class HUD {
	
	private Game game;
	private int HEALTH;
	private int level = 1;
	private int enemiesKilled = 0;
	
	HUD(Game game){
		this.game = game;
		this.HEALTH = game.getPlayGame().getPlayer().getHealth();
	}
	
	
	public void tick() {
		
	}
	
	public void render(Graphics g) {
		HEALTH = game.getPlayGame().getPlayer().getHealth();
		if (Game.gameState == Game.STATE.Game) {
			//drawing text and any static boxes on the screen
			g.setColor(Color.white);
			
			g.drawString("Level " + level, 225, 28);
			g.drawString("Enemies Killed: " + enemiesKilled, 225, 44);
			
			g.fillRect(14, 14, 202, 34);
			
			
			g.setColor(Color.gray);
			g.fillRect(15, 15, 200, 32);
			
			//changes color of health bar based on health level
			if (HEALTH >= 50) {
				g.setColor(Color.green);
				g.fillRect(15, 15, HEALTH * 2, 32);
			}
			else if (HEALTH >= 20 && HEALTH < 50) {
				g.setColor(Color.orange);
				g.fillRect(15, 15, HEALTH * 2, 32);
			}
			else if(HEALTH < 20 && HEALTH > 0) {
				g.setColor(Color.red);
				g.fillRect(15, 15, HEALTH * 2, 32);
			} else {
				Game.gameState = Game.STATE.GameOver;
				game.getGameOver().resetValues(this);
				game.getHandler().killAllEntities();
			}
		}		
		
	}
	
	public void enemyKilled() {
		enemiesKilled++;
	}
	
	public void levelPassed() {
		level += 1;
		game.getSpawner().newLevel(level);
	}
	
	public void resetValues() {
		level = 1;
		enemiesKilled = 0;
	}
	
	//bunch of getters and setters
	
	public int getLevel() {
		return level;
	}
	
	public void setLevel(int Level) {
		this.level = Level;
	}
	
	public int getEnemiesKilled() {
		return enemiesKilled;
	}
	
	public void setEnemiesKilled(int enemiesKilled) {
		this.enemiesKilled = enemiesKilled;
	}
	
}
