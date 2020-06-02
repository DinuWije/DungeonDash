package com.ics4u.finalproj;



import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter{
	
	private Handler handler;
	private boolean[] keyDown = new boolean[4];
	
	public KeyInput(Handler handler) {
		this.handler = handler;
		
		// sets initial positions of keys as UP
		for (int i = 0; i < 4; i++) {
			keyDown[i] = false;
		}
	}
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		//only checks key states if game is in GAME state
		if (Game.gameState == Game.STATE.Game) {
			for(int i = 0; i < handler.object.size(); i++) {
				GameObject tempObject = handler.object.get(i);
				//only applies key events to the player
				if(tempObject.getId() == ID.Player) {
					//key events for player 1
					if(key == KeyEvent.VK_W) { 
						tempObject.setVelY(-5); 
						keyDown[0] = true; 
						}
					if(key == KeyEvent.VK_S) { 
						tempObject.setVelY(5); 
						keyDown[1] = true;
						}
					if(key == KeyEvent.VK_A) { 
						tempObject.setVelX(-5); 
						keyDown[2] = true;
						}
					if(key == KeyEvent.VK_D) { 
						tempObject.setVelX(5); 
						keyDown[3] = true;
						}
				}
			}
		}
		//quits game on escape
		if(key == KeyEvent.VK_ESCAPE) System.exit(1);
	}
	
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		
		if (Game.gameState == Game.STATE.Game) {
			for(int i = 0; i < handler.object.size(); i++) {
				GameObject tempObject = handler.object.get(i);
				
				if(tempObject.getId() == ID.Player) {
					//key events for player 1
					if(key == KeyEvent.VK_W) keyDown[0] = false; //tempObject.setVelY(0);
					if(key == KeyEvent.VK_S) keyDown[1] = false; //tempObject.setVelY(0);
					if(key == KeyEvent.VK_A) keyDown[2] = false; //tempObject.setVelX(0);
					if(key == KeyEvent.VK_D) keyDown[3] = false;  //tempObject.setVelX(0);
				
					//vertical movement
					if(!keyDown[0] && !keyDown[1]) tempObject.setVelY(0);
					//horizontal movement
					if(!keyDown[2] && !keyDown[3]) tempObject.setVelX(0);
				}
				
			}
		}
	}

}
