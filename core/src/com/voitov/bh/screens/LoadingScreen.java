package com.voitov.bh.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.voitov.bh.actors.LoadingBar;
import com.voitov.bh.screens.ScreenManager.StageType;
import com.voitov.bh.textures.TextureManager;
import com.voitov.bh.world.GameWorld;

public class LoadingScreen extends AbstractScreen {

    private Stage stage;

    private Image logo;
    private Image loadingFrame;
    private Image loadingBarHidden;
    private Image screenBg;
    private Image loadingBg;

    private float startX, endX;
    private float percent;
    
    private float time = 0.0000000001f;

    private Actor loadingBar;

    public LoadingScreen(ScreenManager screenManager, TextureManager textureManager, GameWorld gameWorld) {
        super(screenManager, textureManager, gameWorld);
    }

    @Override
    public void show() {
    	textureManager.load("data/loading.atlas", TextureAtlas.class);
    	textureManager.finishLoading();

        TextureAtlas atlas = textureManager.get("data/loading.atlas", TextureAtlas.class);

        logo = new Image(atlas.findRegion("libgdx-logo"));
        loadingFrame = new Image(atlas.findRegion("loading-frame"));
        loadingBarHidden = new Image(atlas.findRegion("loading-bar-hidden"));
        screenBg = new Image(atlas.findRegion("screen-bg"));
        loadingBg = new Image(atlas.findRegion("loading-frame-bg"));

        // Add the loading bar animation
        Animation<AtlasRegion> anim = new Animation<AtlasRegion>(0.05f, atlas.findRegions("loading-bar-anim") );
        anim.setPlayMode(Animation.PlayMode.LOOP_REVERSED);
        loadingBar = new LoadingBar(anim);
        // Or if you only need a static bar, you can do
        // loadingBar = new Image(atlas.findRegion("loading-bar1"));

        stage = new Stage();
        stage.addActor(screenBg);
        stage.addActor(loadingBar);
        stage.addActor(loadingBg);
        stage.addActor(loadingBarHidden);
        stage.addActor(loadingFrame);
        stage.addActor(logo);
        
        textureManager.load("data/other.atlas", TextureAtlas.class);
    }

    @Override
    public void resize(int width, int height) {
        // Set our screen to always be xxx x 480 in size
        width = 480 * width / height;
        height = 480;
        //stage.setViewport(width , height, false);

        // Make the background fill the screen
        screenBg.setSize(width, height);

        // Place the logo in the middle of the screen and 100 px up
        logo.setX((width - logo.getWidth()) / 2);
        logo.setY((height - logo.getHeight()) / 2 + 100);

        // Place the loading frame in the middle of the screen
        loadingFrame.setX((stage.getWidth() - loadingFrame.getWidth()) / 2);
        loadingFrame.setY((stage.getHeight() - loadingFrame.getHeight()) / 2);

        // Place the loading bar at the same spot as the frame, adjusted a few px
        loadingBar.setX(loadingFrame.getX() + 15);
        loadingBar.setY(loadingFrame.getY() + 5);

        // Place the image that will hide the bar on top of the bar, adjusted a few px
        loadingBarHidden.setX(loadingBar.getX() + 35);
        loadingBarHidden.setY(loadingBar.getY() - 3);
        // The start position and how far to move the hidden loading bar
        startX = loadingBarHidden.getX();
        endX = 440;

        // The rest of the hidden bar
        loadingBg.setSize(450, 50);
        loadingBg.setX(loadingBarHidden.getX() + 30);
        loadingBg.setY(loadingBarHidden.getY() + 3);
    }

    @Override
    public void render(float delta) {
    	
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        if (textureManager.update()) { // Load some, will return true if done loading
        	 if(time != 0){
        		 Gdx.app.log("loading time", String.valueOf(time));
        		 time = 0;
             }
        	
            if (Gdx.input.isTouched()) { // If the screen is touched after the game is done loading, go to the main menu screen
                screenManager.toStage(StageType.SPACE);
            }
        }
        
        if(time != 0){
        	time+= delta;
        }
        percent = Interpolation.linear.apply(percent, textureManager.getProgress(), 0.1f);

        loadingBarHidden.setX(startX + endX * percent);
        loadingBg.setX(loadingBarHidden.getX() + 30);
        loadingBg.setWidth(450 - 450 * percent);
        loadingBg.invalidate();

        stage.act();
        stage.draw();
    }

    @Override
    public void hide() {
    	textureManager.unload("data/loading.atlas");
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
	public void dispose() {
		stage.dispose();
	}
}
