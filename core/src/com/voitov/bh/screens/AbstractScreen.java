package com.voitov.bh.screens;

import java.util.LinkedHashMap;
import java.util.Map;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.voitov.bh.BHGame;
import com.voitov.bh.textures.TextureManager;
import com.voitov.bh.world.staticc.GameWorld;

public abstract class AbstractScreen<M, C> implements Screen {
	
	protected BHGame game;
	protected ScreenManager screenManager;
	protected GameWorld gameWorld;
	protected TextureManager textureManager;
	
	protected InputMultiplexer inputMultiplexer;
	
	protected Map<Class<?>, BaseStage<M,C>> stages = new LinkedHashMap<Class<?>, BaseStage<M,C>>();

	public AbstractScreen(BHGame game) {
		this.game = game;
		this.screenManager = game.screenManager;
		this.gameWorld = game.gameWorld;
		this.textureManager = game.textureManager;
		this.inputMultiplexer = new InputMultiplexer();
	}
	
	abstract M getModel();
	abstract C getController();
	abstract void init();
	
	@Override
	public void show(){
		Gdx.input.setInputProcessor(inputMultiplexer);
		init();
	}
	
	@Override
	public void render(float delta) {
		for(BaseStage<M,C> stage: stages.values()){
			if(stage.isVisible()){
				stage.act();
				stage.draw();		
			}
		}
	}
	
	public void resetStage(BaseStage<M,C> stage){
		inputMultiplexer.removeProcessor(getStage(stage.getClass()));
		stages.put(stage.getClass(), stage);
		stage.init(inputMultiplexer);
	}
	
	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		for(BaseStage<M,C> bs: stages.values()){
			bs.dispose();		
		}
	}

	
	@SuppressWarnings("unchecked")
	<T > T getStage(Class<T> clazz){
		for(BaseStage<M,C> bs: stages.values()){
			if(bs.getClass() == clazz){
				return (T)bs;
			}
		}
		return null;
	}

}
