package com.voitov.bh.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.utils.ObjectMap;
import com.voitov.bh.textures.TextureManager;
import com.voitov.bh.world.GameWorld;

/** Управляет созданием и переключением экранов.  */

public class ScreenManager {
	
	private Game game;

	public enum StageType{LOADING, SPACE}
	
	private ObjectMap<StageType, AbstractScreen> stages = new ObjectMap<StageType, AbstractScreen>();
	
	public ScreenManager(Game game, TextureManager textureManager, GameWorld gameWorld){
		this.game = game;
		
		for(StageType st: StageType.values()){
			switch(st){
			case LOADING:
				stages.put(StageType.LOADING, new LoadingScreen(this, textureManager, gameWorld));
				break;
			case SPACE:
				stages.put(StageType.SPACE, new SpaceScreen(this, textureManager, gameWorld));
				break;
			}
		}
	}
	
	public void dispose(){
		for(AbstractScreen s: stages.values()){
			s.dispose();
		}
	}
	
	public void toLoadingScreen() {
		toStage(StageType.LOADING);		
	}

	public void toStage(StageType type) {
		AbstractScreen stage = stages.get(type);
		game.setScreen(stage);
	}
}
