package com.finalGame.gameScreens;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import com.finalGame.gameObjects.Player;
import com.finalGame.mainPackage.Game;
import com.finalGame.mainPackage.HUD;

public class GameOver {
	
	private Game game;
	private PlayGame playGame;
	
	public GameOver(Game game){
		this.game = game;
		this.playGame = game.getPlayGame();
		
	}
	
	public void tick() {
	}
	
	public void render(Graphics g) {
		
		Font fnt1 = new Font("arial", 1, 50);
		Font fnt2 = new Font("arial", 1, 30);
	
		g.setColor(Color.red);
		g.setFont(fnt1);
		g.drawString("Game Over", 180, 100);
		
		g.setColor(Color.white);
		g.setFont(fnt2);
		g.drawString("Press Space to Return to Menu", 100, 150);
		
	}
	
	public void resetValues(HUD hud) {
		System.out.println(hud.getScore());
		hud.setScore(0);
		hud.setTempScore(0);
		hud.setLevel(1);
		Player player = playGame.getPlayer();
		player.setHealth(100);
		player.setX(game.getWidth()/2);
		player.setY(game.getHeight()/2);
		player.losesKey();
		
	}

}
