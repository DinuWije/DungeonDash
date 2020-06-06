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
			boolean shiftPressed = game.getKeyInput().getShiftPressed();
			if(shiftPressed) {
				if(player.checkKey()) {
					game.getSpawner().spawnDoorTop();
					player.setY(game.getHeight()-55);
					player.losesKey();
					game.getHUD().levelPassed();
					game.getHandler().removeObject(this);
				}
			}
		}
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.darkGray);
		g.fillRect(x, y, WIDTH , HEIGHT);
		
		if (this.rect.intersects(player.rect)) {
			g.setColor(Color.white);
			boolean shiftPressed = game.getKeyInput().getShiftPressed();
			if(shiftPressed) {
				if(!player.checkKey()) g.drawString("You don't have the key!", 240, game.getHeight()-50);
			} else g.drawString("Press Shift to Open Door", 240, game.getHeight()-50);	
		}
		
	}

}
