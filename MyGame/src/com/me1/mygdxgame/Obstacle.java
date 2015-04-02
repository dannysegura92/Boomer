package com.me1.mygdxgame;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;

public class Obstacle {
	public Sprite image;
	public Rectangle bounds;
	public int counter;
	
	public Obstacle(){
		image = Assets.obstacle2; // horizontal obstacle
		bounds = new Rectangle(1920,0,128,500);
		counter = 0;
		
	}

}
