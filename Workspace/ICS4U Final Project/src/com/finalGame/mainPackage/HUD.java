package com.finalGame.mainPackage;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import com.finalGame.gameObjects.Player;
import com.finalGame.gameScreens.PlayGame;

public class HUD {
	
	private Game game;
	private int HEALTH;
	private int score = 0;
	private int tempScore;
	private int level = 1;
	
	HUD(Game game){
		this.game = game;
		this.HEALTH = game.getPlayGame().getPlayer().getHealth();
	}
	
	
	public void tick() {
		score++;
	}
	
	public void render(Graphics g) {
		HEALTH = game.getPlayGame().getPlayer().getHealth();
		if (Game.gameState == Game.STATE.Game) {
			//drawing text and any static boxes on the screen
			g.setColor(Color.white);
			
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
	
	//bunch of getters and setters
	public void setScore(int score) {
		this.score = score;
	}
	
	public int getScore() {
		return score;
	}
	
	public int getLevel() {
		return level;
	}
	
	public void setLevel(int Level) {
		this.level = Level;
	}
	
	public void setTempScore(int tempScore){
		this.tempScore = tempScore;
	}
	
	public int getTempScore() {
		return tempScore;
	}
	
}
