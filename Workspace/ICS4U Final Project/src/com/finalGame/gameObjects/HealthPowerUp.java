package com.finalGame.gameObjects;

import java.awt.Color;
import java.awt.Graphics;

import com.finalGame.mainPackage.Game;
import com.finalGame.mainPackage.ID;

public class HealthPowerUp extends GameObject{
	
	Game game;
	Player player;

	public HealthPowerUp(int x, int y, ID id, int WIDTH, int HEIGHT, Game game) {
		super(x, y, id, WIDTH, HEIGHT);
		this.game = game;
		player = game.getPlayGame().getPlayer();
	}

	@Override
	public void tick() {
		if(this.rect.intersects(player.rect)) {
			player.setHealth(player.getHealth()+15);
			game.getHandler().removeObject(this);
		}
		
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.green);
		g.fillRect(x, y, WIDTH, HEIGHT);
		
	}

}
