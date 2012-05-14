package com.sbros.alightinthedark.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.sbros.alightinthedark.Assets;

public class Player {
	
	public float x, y;
	public float xa = 0, ya = 0;
	public Screen screen;
	public boolean onGround;
	public float gravity;
	public float speed;
	public float accX, accY, accZ;
	public TextureRegion tex;
	
	public Player(Screen screen){
		this.screen = screen;
		x = 20; 
		y = Gdx.graphics.getHeight() - 32;
		gravity = .1f;
		speed = .4f;
		tex = new TextureRegion();
	}
	
	public void tick(){
		accX = Gdx.input.getAccelerometerX();
		accY = Gdx.input.getAccelerometerY();
		accZ = Gdx.input.getAccelerometerZ();
		if(Gdx.input.isKeyPressed(Input.Keys.RIGHT) || Gdx.input.getAccelerometerY() > 3f){
			this.xa += speed; 
		} else if ( Gdx.input.isKeyPressed(Input.Keys.LEFT) || Gdx.input.getAccelerometerY() < -3f){
			this.xa -= speed;
		}
		if ((Gdx.input.isKeyPressed(Input.Keys.UP) || Gdx.input.isTouched()) && onGround){
			this.ya -= 3;
		}
		
		onGround = false;
		this.x += xa;
		if(this.y + ya >= Gdx.graphics.getHeight()){
			onGround = true;
			ya = 0;
			this.y = Gdx.graphics.getHeight();
		} else {
			this.y += ya;
		}
		
		this.xa *= .96f;
		
		if (Gdx.input.isKeyPressed(Input.Keys.UP)){
			this.ya += gravity * .5f;
		} else {
			this.ya += gravity;
		}
		
		if (this.x < -32){
			this.x = Gdx.graphics.getWidth();
		} else if (this.x > Gdx.graphics.getWidth()){
			this.x = -32;
		}
	}
	
	public void render(){
		tex = new TextureRegion(Assets.player);
		screen.draw(tex, (int)this.x, (int)this.y);
	}
}
