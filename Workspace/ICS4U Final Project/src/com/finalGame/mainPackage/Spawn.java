package com.finalGame.mainPackage;

import java.util.Random;

import com.finalGame.gameObjects.BasicEnemy;
import com.finalGame.gameObjects.DoorObject;
import com.finalGame.gameObjects.KeyObject;

public class Spawn {
	
	private Game game;
	private Handler handler;
	private HUD hud;
	private int scoreKeep = 0;
	private static Random rand = new Random();
	private static int levelLength = 500;
	
	
	public Spawn(Game game) {
		this.game = game;
		this.handler = game.getHandler();
		this.hud = game.getHUD();
	}
	
	public void tick() {
		//scoreKeep and levelLength are used to increment the level
		scoreKeep++;
		if(scoreKeep >= levelLength) {
			scoreKeep = 0;
			//hud.setLevel((hud.getLevel())+1);
		}
	}
	
	public static int getLevelLength() {
		return levelLength;
	}
	
	public static int randInt(int min, int max) {
	    int randomNum = rand.nextInt((max - min) + 1) + min;
	    return randomNum;
	}
	
	public void spawnEnemy() {
		int xCoord = randInt(0, game.getWidth());
		int yCoord = randInt(0, game.getHeight());
		handler.addObject(new BasicEnemy(xCoord, yCoord, ID.BasicEnemy, 16, 16, game));
	}
	
	public void spawnKey() {
		int xCoord = randInt(0, game.getWidth());
		int yCoord = randInt(0, game.getHeight());
		handler.addObject(new KeyObject(xCoord, yCoord, ID.Key, 5, 5, game));
	}
	
	public void spawnDoorTop() {
		handler.addObject(new DoorObject(game.getWidth()/2, 0, ID.Door, 25, 25, game));
	}
	
	public void spawnDoorBottom() {
		handler.addObject(new DoorObject(game.getWidth()/2, game.getHeight(), ID.Door, 5, 5, game));
	}
	

}
