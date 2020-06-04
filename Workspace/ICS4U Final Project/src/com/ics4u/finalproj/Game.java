package com.ics4u.finalproj;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferStrategy;
import java.util.Random;

import javax.swing.ImageIcon;

public class Game extends Canvas implements Runnable{
	
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;
	
	private Thread thread;
	private boolean running = false;
	private Handler handler;
	private String background = "/Users/dwijetunga/Documents/School 2019-2020/ICS4U/Final Project/Workspace/ICS4U Final Project/res/infiniteBackgroundTemp.png";
	//private int highScore;
	
	
	public static HUD hud;
	
	public Spawn spawner;
	public Menu menu;
	public PlayGame playGame;
	public GameOver gameOver;
	
	
	public enum STATE {
		Menu,
		Game,
		Help,
		Pause,
		GameOver
	};
	
	public static STATE gameState = STATE.Menu;
	
	public Game() {
		//adding key objects to game
		handler = new Handler();
		menu = new Menu(this, handler);
		this.addMouseListener(menu);
		hud = new HUD(this);
		spawner = new Spawn(handler, hud);
		playGame = new PlayGame(this);
		gameOver = new GameOver();
		this.addKeyListener(new KeyInput(handler, playGame));
		
		//creating game Window
		new Window(WIDTH, HEIGHT, "Final Game", this);
	
//		startGame(handler, hud);
	}
	
	//starts/stops thread
	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		running = true;
	}
	
	public synchronized void stop() {
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
		if(gameState == STATE.Game) hud.render(g);
		else if (gameState == STATE.Menu || gameState == STATE.Help || gameState == STATE.Pause) menu.render(g);
		else if (gameState == STATE.GameOver) gameOver.render(g);
		bs.show();
		g.dispose();
		
		
	}
	
	//clamps certain values in place (doesn't let them go above or below the set threshold)
	public static int clamp(int var, int min, int max) {
		if(var >= max)
			return var = max;
		else if(var <= min)
			return var = min;
		else
			return var;
	}
	
	
	public static void main(String[] args) {
		new Game();
	}
	
	//getters and setters
	public Handler getHandler() {
		return handler;
	}

}
