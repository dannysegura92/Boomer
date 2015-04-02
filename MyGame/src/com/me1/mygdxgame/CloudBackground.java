package com.me1.mygdxgame;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;

public class CloudBackground {
	public Sprite image;
	public Rectangle bounds;
	public int counter;
	
	public CloudBackground(){
		image = Assets.cloudbackground; 
		bounds = new Rectangle(0,0, 5600,1080);
		counter = 0;
	}

}
