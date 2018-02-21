package com.voitov.bh.screens;

import com.voitov.bh.BHGame;
import com.voitov.bh.screens.controller.SpaceController;
import com.voitov.bh.screens.model.SpaceModel;
import com.voitov.bh.stages.SpaceStage;
import com.voitov.bh.stages.SpaceUiStage;

public class SpaceScreen extends AbstractScreen<SpaceModel, SpaceController> implements SpaceController {
	
	private SpaceModel model = new SpaceModel(gameWorld.getGalaxies().first());
	
    public SpaceScreen(final BHGame game) {
    	super(game);
    }
    
	@Override
	public void init() {
		resetStage(new SpaceStage(game, model, this));
    	resetStage(new SpaceUiStage(game, model, this));
	}
	
	@Override
	public SpaceModel getModel(){
		return model;
	}

	@Override
	public SpaceController getController() {
		return this;
	}
	
}
