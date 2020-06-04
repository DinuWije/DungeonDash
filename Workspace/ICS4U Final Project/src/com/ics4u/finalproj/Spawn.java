package com.ics4u.finalproj;

import java.util.Random;

public class Spawn {
	
	private Handler handler;
	private HUD hud;
	private int scoreKeep = 0;
	private static Random rand = new Random();
	
	private static int levelLength = 500;
	
	
	public Spawn(Handler handler, HUD hud) {
		this.handler = handler;
		this.hud = hud;
	}
	
	public void tick() {
		//scoreKeep and levelLength are used to increment the level
		scoreKeep++;
		if(scoreKeep >= levelLength) {
			scoreKeep = 0;
			hud.setLevel((hud.getLevel())+1);
		}
	}
	
	public static int getLevelLength() {
		return levelLength;
	}
	
	public void spawnEnemy() {
		int xCoord = randInt(0, Game.WIDTH);
		int yCoord = randInt(0, Game.HEIGHT);
		handler.addObject(new BasicEnemy(xCoord, yCoord, ID.BasicEnemy, 16, 16));
	}
	
	public static int randInt(int min, int max) {
	    int randomNum = rand.nextInt((max - min) + 1) + min;
	    return randomNum;
	}

}
