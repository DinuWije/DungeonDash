package com.finalGame.mainPackage;

import java.awt.Graphics;
import java.util.LinkedList;

import com.finalGame.gameObjects.GameObject;

public class Handler {
	//keeps track of all objects in the game
	private LinkedList<GameObject> object = new LinkedList<GameObject>();
	
	//updating objects
	public void tick() {
		for(int i = 0; i < object.size(); i++) {
			object.get(i).tick();
		}
	}
	
	public void render(Graphics g) {
		for(int i = 0; i < object.size(); i++) {
			GameObject tempObject = object.get(i);
			
			tempObject.render(g);
		}
	}
	
	//code for adding and removing objects
	public void addObject(GameObject object) {
		this.object.add(object);
	}
	
	public void removeObject(GameObject object) {
		this.object.remove(object);
	}
	
	public void killAllEntities() {
		object = new LinkedList<GameObject>();
	}
	
	protected LinkedList<GameObject> getObject(){
		return object;
	}
	

}