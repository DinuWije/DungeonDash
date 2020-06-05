package com.finalGame.gameScreens;

import java.awt.Graphics;

import com.finalGame.gameObjects.DoorObject;
import com.finalGame.gameObjects.Player;
import com.finalGame.mainPackage.Game;
import com.finalGame.mainPackage.HUD;
import com.finalGame.mainPackage.Handler;
import com.finalGame.mainPackage.ID;
import com.finalGame.mainPackage.Spawn;
import com.finalGame.mainPackage.Game.STATE;

public class PlayGame {
	
	private Game game;
	private Player player;
	private Spawn spawner;
	private GameBackground gameBackground = new GameBackground(game, spawner);
	
	public PlayGame(Game game){
		this.game = game;
		this.spawner = game.getSpawner();
		player = new Player(game.getWidth()/2, game.getHeight()/2, ID.Player, 32, 32, game);
	}
	
	public void startGame(Handler handler, HUD hud) {
		handler.addObject(player);
		spawner.spawnEnemy();
		spawner.spawnKey();
		spawner.spawnDoorTop();
		Game.gameState = STATE.Game;
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public void render(Graphics g) {
		
	}
	
	public GameBackground getBackground() {
		return gameBackground;
	}

}
