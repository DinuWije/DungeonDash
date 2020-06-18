package com.finalGame.gameScreens;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.LinkedList;

import com.finalGame.gameObjects.GameObject;
import com.finalGame.mainPackage.Game;
import com.finalGame.mainPackage.ID;
import com.finalGame.mainPackage.Spawn;

/**
 * Optional background graphics switcher
 * UNUSED
 * 
 * Authors: Dinu, Hita, & Asha
 * 
 */

public class GameBackground {
	
	private int backgroundNum = 1;
	private Spawn spawner;
	Game game;
	
	GameBackground(Game game, Spawn spawner){
		this.spawner = spawner;
		this.game = game;
	}
	
	public void setBackground(Spawn spawner){
		
//		if(backgroundNum == 1) {
//			spawner.spawnDoorTop();
//			g.setColor(Color.blue);
//		} else {
//			spawner.spawnDoorBottom();
//			g.setColor(Color.blue);
//		}
//		
//		g.dispose();
	}
	
	public void changeBackground() {
		
		if(backgroundNum == 1) backgroundNum = 2;
		else backgroundNum = 1;
	}

}
