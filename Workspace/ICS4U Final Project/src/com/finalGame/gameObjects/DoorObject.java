package com.finalGame.gameObjects;

import java.awt.Color;
import java.awt.Graphics;

import com.finalGame.gameScreens.GameBackground;
import com.finalGame.gameScreens.PlayGame;
import com.finalGame.mainPackage.Game;
import com.finalGame.mainPackage.ID;

public class DoorObject extends GameObject{
	
	private Game game;
	private Player player;
	private GameBackground background;

	public DoorObject(int x, int y, ID id, int WIDTH, int HEIGHT, Game game) {
		super(x, y, id, WIDTH, HEIGHT);
		this.game = game;
		this.player = game.getPlayGame().getPlayer();
		this.background = game.getPlayGame().getBackground();
	}

	@Override
	public void tick() {
		this.rect.x = x;
		this.rect.y = y;
		if (this.rect.intersects(player.rect)) {
			System.out.println("Intersects");
			if(player.checkKey()) {
				System.out.println("Door Opens");
				background.changeBackground();
				game.getHandler().removeObject(this);
				
			}
		}
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.blue);
		g.fillRect(x, y, WIDTH , HEIGHT);
		
	}

}
