package com.finalGame.gameScreens;

import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;

import com.finalGame.gameObjects.GameObject;
import com.finalGame.mainPackage.Game;
import com.finalGame.mainPackage.ID;
import com.finalGame.mainPackage.Spawn;

public class GameBackground {
	
	private int backgroundNum = 1;
	private Spawn spawner;
	Game game;
	
	GameBackground(Game game, Spawn spawner){
		this.spawner = spawner;
		this.game = game;
	}
	
	public void setBackground(Graphics g, Spawn spawner){
		if(backgroundNum == 1) {
			spawner.spawnDoorTop();
			g.setColor(Color.blue);
		} else {
			spawner.spawnDoorBottom();
			g.setColor(Color.blue);
		}
	}
	
	public void changeBackground() {
		
		if(backgroundNum == 1) backgroundNum = 2;
		else backgroundNum = 1;
	}

}
