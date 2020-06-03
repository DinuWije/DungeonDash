package com.ics4u.finalproj;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class HUD {
	
	Game game; 
	
	HUD(Game game){
		this.game = game;
	}
	
	public int HEALTH = 100;
	
	private int score = 0;
	private int tempScore;
	private int level = 1;
	
	public void tick() {
		HEALTH = Game.clamp(HEALTH, 0, 100);
		score++;
	}
	
	public void render(Graphics g) {
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
	
	public int getHealth() {
		return HEALTH;
	}
	
	public void setHealth(int HEALTH) {
		this.HEALTH = HEALTH;
	}
	
}
