package com.voitov.bh.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.voitov.bh.textures.TextureManager;
import com.voitov.bh.textures.TextureType;
import com.voitov.bh.world.GameWorld;

/** Экран звёздной системы. Здесь игрок может
 *  лететь вокруг звезды и приземляться на планеты. */

public class SpaceScreen extends AbstractScreen {
	
	private Stage stage;

    public SpaceScreen(ScreenManager stageManager, TextureManager textureManager,	GameWorld gameWorld) {
    	super(stageManager, textureManager, gameWorld);
    	
    	stage = new Stage();
        Table table = new Table();
        table.setFillParent(true);
        table.center();
        Image image = new Image(textureManager.getTexture(TextureType.BADLOGIC));
        table.add(image);
        stage.addActor(table);
    }

	@Override
	public void show() {
		Gdx.input.setInputProcessor(stage);
	}

	@Override
	public void render(float delta) {
		stage.act();
		stage.draw();		
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
		stage.dispose();		
	}

}
