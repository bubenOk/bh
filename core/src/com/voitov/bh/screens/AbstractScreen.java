package com.voitov.bh.screens;

import com.badlogic.gdx.Screen;
import com.voitov.bh.textures.TextureManager;
import com.voitov.bh.world.GameWorld;

public abstract class AbstractScreen implements Screen {
	
	protected ScreenManager screenManager;
	protected TextureManager textureManager;
	protected GameWorld gameWorld;

	public AbstractScreen(ScreenManager screenManager, TextureManager textureManager,
			GameWorld gameWorld) {
		this.screenManager = screenManager;
		this.textureManager = textureManager;
		this.gameWorld = gameWorld;
	}

}
