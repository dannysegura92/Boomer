package com.me1.mygdxgame;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;

public class Obstacle7 {
	public Sprite image;
	public Rectangle bounds;
	public int counter;
	
	public Obstacle7(){
		image = Assets.obstacle; //vertical rec
		bounds = new Rectangle(1920,0,156,650);
		counter = 0;
	}
	

}
