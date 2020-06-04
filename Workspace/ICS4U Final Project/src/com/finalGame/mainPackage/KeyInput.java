package com.finalGame.mainPackage;



import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.LinkedList;

import com.finalGame.gameObjects.GameObject;
import com.finalGame.gameScreens.PlayGame;

public class KeyInput extends KeyAdapter{
	
	private Handler handler;
	private boolean[] keyDown = new boolean[4];
	private PlayGame playGame;
	private Game game;
	private LinkedList<GameObject> object;
	
	public KeyInput(Game game) {
		this.game = game;
		this.handler = game.getHandler();
		this.playGame = game.getPlayGame();
		this.object = game.getHandler().getObject();
		
		// sets initial positions of keys as UP
		for (int i = 0; i < 4; i++) {
			keyDown[i] = false;
		}
	}
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		//only checks key states if game is in GAME state
		if (Game.gameState == Game.STATE.Game) {
			for(int i = 0; i < object.size(); i++) {
				GameObject tempObject = object.get(i);
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
		} else if(Game.gameState == Game.STATE.Menu) {
			if(key == KeyEvent.VK_SPACE) playGame.startGame(handler, game.getHUD());
		} else if (Game.gameState == Game.STATE.GameOver) {
			if(key == KeyEvent.VK_SPACE) Game.gameState = Game.STATE.Menu;
		}
		//quits game on escape
		if(key == KeyEvent.VK_ESCAPE) System.exit(1);
		
	}
	
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		
		if (Game.gameState == Game.STATE.Game) {
			for(int i = 0; i < object.size(); i++) {
				GameObject tempObject = object.get(i);
				
				if(tempObject.getId() == ID.Player) {
					//key events for player 1
					if(key == KeyEvent.VK_W) keyDown[0] = false; 
					if(key == KeyEvent.VK_S) keyDown[1] = false; 
					if(key == KeyEvent.VK_A) keyDown[2] = false; 
					if(key == KeyEvent.VK_D) keyDown[3] = false;
				
					//vertical movement
					if(!keyDown[0] && !keyDown[1]) tempObject.setVelY(0);
					//horizontal movement
					if(!keyDown[2] && !keyDown[3]) tempObject.setVelX(0);
				}
				
			}
		}
	}

}
