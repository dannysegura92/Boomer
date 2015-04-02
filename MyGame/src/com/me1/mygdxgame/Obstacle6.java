package com.me1.mygdxgame;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;

public class Obstacle6 {
	public Sprite image;
	public Rectangle bounds;
	public int counter;
	
	public Obstacle6(){
		image = Assets.obstacle; //vertical rectangle
		bounds = new Rectangle(1920,0,156,650);
		counter = 0;
	}

}
