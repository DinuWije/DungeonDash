package com.ics4u.finalproj;

import com.ics4u.finalproj.Game.STATE;

public class PlayGame {
	
	private Game game;
	public static Player player;
	
	PlayGame(Game game){
		this.game = game;
	}
	
	public void startGame(Handler handler, HUD hud) {
		Game.gameState = STATE.Game;
		player = new Player(Game.WIDTH/2-32, Game.HEIGHT/2-32, ID.Player, 32, 32);
		handler.addObject(player);
		game.spawner.spawnEnemy();
	}

}
