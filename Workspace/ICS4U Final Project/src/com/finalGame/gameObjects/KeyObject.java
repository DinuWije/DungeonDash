package com.finalGame.gameObjects;

import java.awt.Color;
import java.awt.Graphics;

import com.finalGame.gameScreens.PlayGame;
import com.finalGame.mainPackage.Game;
import com.finalGame.mainPackage.ID;

/**
 * Key that opens door
 * Dropped by the last remaining enemy
 * 
 * Authors: Dinu, Hita, & Asha
 * 
 */

public class KeyObject extends GameObject{
	
	private Game game;
	private Player player;

	public KeyObject(int x, int y, ID id, int WIDTH, int HEIGHT, Game game) {
		super(x, y, id, WIDTH, HEIGHT);
		this.game = game;
		this.player = game.getPlayGame().getPlayer();
		
	}

	@Override
	public void tick() {
		this.rect.x = x;
		this.rect.y = y;
		if (this.rect.intersects(player.rect)) {
			player.picksUpKey();
			game.getHandler().removeObject(this);
		}
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.yellow);
		g.fillRect(x, y, WIDTH , HEIGHT);
	}

}
