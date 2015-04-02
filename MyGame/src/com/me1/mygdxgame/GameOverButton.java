package com.me1.mygdxgame;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;

public class GameOverButton {
	public Sprite image;
	public Rectangle bounds;

	
	public GameOverButton(){
		image = Assets.tryagainbutton;
		bounds = new Rectangle(1500, 750,250,125);
		// rectangle ( 0,0, length, height)
		
	}

}
