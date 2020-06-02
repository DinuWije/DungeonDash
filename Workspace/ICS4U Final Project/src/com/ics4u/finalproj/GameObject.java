package com.ics4u.finalproj;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class GameObject {
	
	protected int x, y;
	protected int tempX, tempY;
	protected ID id;
	protected int velX, velY;
	protected int tempVelX, tempVelY;
	protected Rectangle rect;
	protected int WIDTH, HEIGHT;
	
	//parent class for objects
	public GameObject(int x, int y, ID id, int WIDTH, int HEIGHT) {
		this.x = x;
		this.y = y;
		this.id = id;
		this.WIDTH = WIDTH;
		this.HEIGHT = HEIGHT;
		this.rect = new Rectangle(x, y, WIDTH, HEIGHT);
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
	
	//bunch of getters and setters
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public void setId(ID id) {
		this.id = id;
	}
	public ID getId() {
		return id;
	}
	public void setVelX(int velX) {
		this.velX = velX;
	}
	public void setVelY(int velY) {
		this.velY = velY;
	}
	public int getVelX() {
		return velX;
	}
	public int getVelY() {
		return velY;
	}
	
	public void setTempVelX(int tempVelX) {
		this.tempVelX = tempVelX;
	}
	public void setTempVelY(int tempVelY) {
		this.tempVelY = tempVelY;
	}
	public int getTempVelX() {
		return tempVelX;
	}
	public int getTempVelY() {
		return tempVelY;
	}
	public void setTempX(int tempX) {
		this.tempX = tempX;
	}
	public void setTempY(int tempY) {
		this.tempY = tempY;
	}
	public int getTempX() {
		return tempX;
	}
	public int getTempY() {
		return tempY;
	}

}