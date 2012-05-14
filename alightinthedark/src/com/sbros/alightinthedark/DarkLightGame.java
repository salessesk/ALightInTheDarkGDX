package com.sbros.alightinthedark;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.sbros.alightinthedark.screen.GameScreen;
import com.sbros.alightinthedark.screen.Screen;

public class DarkLightGame extends Game {
	public GameScreen gameScreen;
	
	@Override
	public void create() {
		Assets.load();
		gameScreen = new GameScreen(this);
		this.setScreen(gameScreen);
	}
	
	@Override
	public void render () {
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		((Screen)this.getScreen()).tick();		
		this.getScreen().render(Gdx.graphics.getDeltaTime());
	}
}
