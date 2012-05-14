package com.sbros.alightinthedark.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Logger;
import com.sbros.alightinthedark.DarkLightGame;

public class GameScreen extends Screen {

	public DarkLightGame game;
	public static Logger log;
	
	Player player;
	
	public GameScreen(DarkLightGame game){
		this.game = game;
		player = new Player(this);
		
		log = new Logger("GameScreenLogger", Logger.DEBUG); 
		
		log.debug("height: "+Gdx.graphics.getHeight());
		log.debug("width: "+Gdx.graphics.getWidth());
	}
	
	@Override
	public void render(float delta) {		
		cam.update();
		cam.apply(Gdx.gl10);
		spriteBatch.begin();
		player.render();
		spriteBatch.end();
	}

	@Override
	public void tick() {
		player.tick();
	}

}
