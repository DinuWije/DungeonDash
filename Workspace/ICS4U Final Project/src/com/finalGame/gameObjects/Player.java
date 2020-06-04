package com.finalGame.gameObjects;

import java.awt.Color;
import java.awt.Graphics;

import com.finalGame.gameScreens.GameBackground;
import com.finalGame.mainPackage.Game;
import com.finalGame.mainPackage.ID;

public class Player extends GameObject{
	
	private Boolean hasKey = false;
	private Game game;
	private int Health = 100;
	
	public Player(int x, int y, ID id, int WIDTH, int HEIGHT, Game game) {
		super(x, y, id, WIDTH, HEIGHT);
		this.game = game;
	
	}

	public void tick() {
		x += velX;
		y += velY;
		this.rect.x = x;
		this.rect.y = y;
		Health = game.clamp(Health, 0, 100);
		
		//prevents player from leaving bounds of game (doesn't force the player to bounce off walls)	
		x = game.clamp(x, 0, game.getWidth()-33);
		y = game.clamp(y, 0, game.getHeight()-55);
	}
	
	public void render(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(x, y, WIDTH , HEIGHT);
	}
	
	public void picksUpKey() {
		hasKey = true;
	}
	
	public void dropsKey() {
		hasKey = false;
	}
	
	public boolean checkKey() {
		return hasKey;
	}
	
	public int getHealth() {
		return Health;
	}
	
	public void setHealth(int Health) {
		this.Health = Health;
	}
	
	

}
