package com.voitov.bh.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.ObjectMap;
import com.voitov.bh.BHGame;
import com.voitov.bh.world.staticc.galaxy.Galaxy;
import com.voitov.bh.world.staticc.galaxy.Planet;

/** Управляет созданием и переключением экранов.  */

public class ScreenManager {
	
	//TODO тут по хорошему надо ввести состояние, и выдавать понятную ошибку, 
	//если вызывается toLoadingScreen перед createScreens
	
	public int height;
	
	public int width;
	
	private BHGame game;

	public enum ScreenType{LOADING, SPACE, SYSTEMS, PLANET}
	
	private ObjectMap<ScreenType, AbstractScreen<?, ?>> screens = new ObjectMap<ScreenType, AbstractScreen<?, ?>>();
	
	public ScreenManager(BHGame game){
		this.game = game;
		
		height = Gdx.graphics.getHeight();
		width = Gdx.graphics.getWidth();
	}
	
	public void createScreens(){
		for(ScreenType st: ScreenType.values()){
			switch(st){
			case LOADING:
				screens.put(ScreenType.LOADING, new LoadingScreen(game));
				break;
			case SPACE:
				screens.put(ScreenType.SPACE, new SpaceScreen(game));
				break;
			case SYSTEMS:
				screens.put(ScreenType.SYSTEMS, new SystemsScreen(game));
				break;
			case PLANET:
				screens.put(ScreenType.PLANET, new PlanetScreen(game));
				break;
			}
		}
	}
	
	public void dispose(){
		for(AbstractScreen<?, ?> s: screens.values()){
			s.dispose();
		}
	}
	
	public void toLoadingScreen() {
		toScreen(ScreenType.LOADING);		
	}

	//TODO этот метод нельзя вызывать напрямую.
	public void toScreen(ScreenType type) {
		AbstractScreen<?, ?> screen = screens.get(type);
		game.setScreen(screen);
	}
	
	public void toGalaxyScreen(Galaxy galaxy){
		AbstractScreen<?, ?> screen = screens.get(ScreenType.SPACE);
		((SpaceScreen) screen).getModel().setGalaxy(galaxy);
		game.setScreen(screen);
	}
	
	public void toPlanetScreen(Planet planet){
		AbstractScreen<?, ?> screen = screens.get(ScreenType.PLANET);
		((PlanetScreen) screen).getModel().setPlanet(planet);
		game.setScreen(screen);
	}
	
	public void toPlanetScreen(){
		AbstractScreen<?, ?> screen = screens.get(ScreenType.PLANET);
		game.setScreen(screen);
	}
	
	public Galaxy getCurrentGalaxy(){
		AbstractScreen<?, ?> screen = screens.get(ScreenType.SPACE);
		return ((SpaceScreen) screen).getModel().getGalaxy();
	}

//	public void preInitScreens(BHGame game) {
//		for(AbstractScreen<?,?> screen: screens.values()){
//			screen.preInit(game);
//		}
//		
//	}

}
