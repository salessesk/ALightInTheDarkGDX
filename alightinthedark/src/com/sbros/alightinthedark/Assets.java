package com.sbros.alightinthedark;

import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;

public class Assets {
	public static Pixmap level;
	public static Texture player;
	
	public static void load()
	{
		player = new Texture("indie.png"); 
	}
}
