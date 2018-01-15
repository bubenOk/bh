package com.voitov.bh;

import com.badlogic.gdx.Game;
import com.voitov.bh.screens.ScreenManager;
import com.voitov.bh.textures.TextureManager;
import com.voitov.bh.world.GameWorld;

//0.5. Добавить в Git!!!
//1. Наполнить сцены жизнью!
//2. Тема на Геймдев
//	 - когда стабилизируется рабочий процесс, н
// 	   можно создать тему на геймдев со скриншотами и описанием
//   Это будет очень полезно - живой feedback, есть шанс найти команду
//   - художника, сопрограммера (если не выеживаться)
// 1. Виральность 2. Глубина 3. Раскрутка

// можно посмотреть ещё вики и туториалы, чтобы найти архитектуру получше
//https://www.reddit.com/user/deepfakes/submitted/

/** Входная точка приложения. Здесь инициализируются все синглтоны приложения. */

public class BHGame extends Game {
	
	private GameWorld gameWorld; 
	private TextureManager textureManager;
	private ScreenManager screenManager;
	
	@Override
	public void create () {
		gameWorld = new GameWorld(null, null); //TODO создавать нормального стартового юзера и галактики
		textureManager = new TextureManager();
		screenManager = new ScreenManager(this, textureManager, gameWorld);
		
		screenManager.toLoadingScreen();
	}

	@Override
	public void dispose () {
		screenManager.dispose();
		textureManager.dispose();
	}

}
