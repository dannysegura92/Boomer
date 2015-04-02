package com.me1.mygdxgame;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;

public class Powerup1 {
	public Sprite image;
	public Rectangle bounds;
	public int counter;
	public boolean used;
	public boolean holder;
	
	public Powerup1(){
		image = Assets.powerup1;
		bounds = new Rectangle(1920,0,128,128);
		used = false;
		holder = true;
		//		bounds = new Rectangle(540,540,128,128);
		counter = 0;
	}

}
