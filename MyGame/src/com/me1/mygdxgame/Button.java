package com.me1.mygdxgame;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;

public class Button {
	public Sprite image;
	public Rectangle bounds;

	
	public Button(){
		image = Assets.button;
		bounds = new Rectangle(500,650,250,125);
		// rectangle ( 0,0, length, height)
		
	}

}
