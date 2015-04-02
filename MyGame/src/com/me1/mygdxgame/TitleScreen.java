package com.me1.mygdxgame;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;

public class TitleScreen {
	public Sprite image;
	public Rectangle bounds;
	public int counter;
	
	public TitleScreen(){
		image = Assets.sprite_back;
		bounds = new Rectangle(0,0,1920,1040);
		counter = 0;
	}
	
	

}
