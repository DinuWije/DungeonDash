package com.finalGame.mainPackage;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;


/**
 * Using Jframe to setup main game window
 * 
 * Authors: Dinu, Hita, & Asha
 * 
 */
public class Window extends Canvas{

	private static final long serialVersionUID = -8255319694373975038L;
	
	public Window(int width, int height, String title, Game game) {
		JFrame frame = new JFrame(title);
		
		//doesn't allow for scalable window
		frame.setPreferredSize(new Dimension(width, height));
		frame.setMaximumSize(new Dimension(width, height));
		frame.setMinimumSize(new Dimension(width, height));
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.add(game);
		frame.setVisible(true);
		game.start();
	}
}

