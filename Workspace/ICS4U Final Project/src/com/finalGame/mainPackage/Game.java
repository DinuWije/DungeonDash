package com.finalGame.mainPackage;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferStrategy;
import java.util.Random;

import javax.swing.ImageIcon;

import com.finalGame.gameObjects.Player;
import com.finalGame.gameScreens.GameOver;
import com.finalGame.gameScreens.Menu;
import com.finalGame.gameScreens.PlayGame;

public class Game extends Canvas implements Runnable{
	
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	private static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;
	
	private Thread thread;
	private boolean running = false;
	private Handler handler;
	private HUD hud;
	private Spawn spawner;
	private Menu menu;
	private PlayGame playGame;
	private GameOver gameOver;
	private KeyInput keyInput;
	
	//private int highScore;
	//private String background = "/Users/dwijetunga/Documents/School 2019-2020/ICS4U/Final Project/Workspace/ICS4U Final Project/res/infiniteBackgroundTemp.png";	

	public enum STATE {
		Menu,
		Game,
		Help,
		Pause,
		GameOver
	};
	
	public static STATE gameState = STATE.Menu;
	
	public static void main(String[] args) {
		new Game();
	}
	
	public Game() {
		//adding key objects to game
		handler = new Handler();
		menu = new Menu(this);
		//this.addMouseListener(menu);
		spawner = new Spawn(this );
		playGame = new PlayGame(this);
		gameOver = new GameOver(this);
		hud = new HUD(this);
		keyInput = new KeyInput(this);
		this.addKeyListener(keyInput);
	
		//creating game Window
		new Window(WIDTH, HEIGHT, "Final Game", this);
	
	}
	
	//starts/stops thread
	protected synchronized void start() {
		thread = new Thread(this);
		thread.start();
		running = true;
	}
	
	protected synchronized void stop() {
		try{
			thread.join();
			running = false;
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//some code to make the ticking and rendering work properly (taken from the Internet)
	public void run() {
		//requests focus to the window
		this.requestFocus();
		
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000/ amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while(running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1) {
				tick();
				delta--;
			}
			if(running)
				render();
			frames++;
			
			if(System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.println("FPS: " + frames);
				frames = 0;
			}
		}
		stop();
	}
	
	//ticks the game, runs constantly
	private void tick() {
		handler.tick();
		if(gameState == STATE.Game) {
			hud.tick();
			spawner.tick();
//			if (hud.getScore() > highScore) {
//				highScore = hud.getScore();
//				setHighScore();
//			}
		} else if (gameState == STATE.Menu || gameState == STATE.Help) menu.tick();
		else if (gameState == STATE.GameOver) gameOver.tick();
		
	}
	
	//sets up visuals of the game
	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);	
		
		handler.render(g);
		
		//different visuals for different game states
		if(gameState == STATE.Game) {
			hud.render(g);
			playGame.render(g);
		}
		else if (gameState == STATE.Menu || gameState == STATE.Help || gameState == STATE.Pause) menu.render(g);
		else if (gameState == STATE.GameOver) gameOver.render(g);
		
		
		bs.show();
		g.dispose();
		
		
	}
	
	//clamps certain values in place (doesn't let them go above or below the set threshold)
	public int clamp(int var, int min, int max) {
		if(var >= max)
			return var = max;
		else if(var <= min)
			return var = min;
		else
			return var;
	}
	
	//getters and setters
	public Handler getHandler() {
		return handler;
	}
	
	public HUD getHUD() {
		return hud;
	}
	
	public Spawn getSpawner() {
		return spawner;
	}
	
	public Menu getMenu() {
		return menu;
	}
	
	public GameOver getGameOver() {
		return gameOver;
	}
	
	public PlayGame getPlayGame() {
		return playGame;
	}
	
	public int getHeight() {
		return HEIGHT;
	}
	
	public int getWidth() {
		return WIDTH;
	}
	
	public KeyInput getKeyInput() {
		return keyInput;
	}
	

}
