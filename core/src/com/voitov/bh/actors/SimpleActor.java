package com.voitov.bh.actors;

import static com.badlogic.gdx.utils.Align.bottom;
import static com.badlogic.gdx.utils.Align.left;
import static com.badlogic.gdx.utils.Align.right;
import static com.badlogic.gdx.utils.Align.top;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class SimpleActor extends Actor {

    private final TextureRegion region;
    
    public SimpleActor(float x, float y, TextureRegion region) {
    	this(region);
    	
    	setPosition(x, y);
    }

    public SimpleActor(TextureRegion region) {
        this.region = region;
        setSize(region.getRegionWidth(), region.getRegionHeight());
        setBounds(0, 0, getWidth(), getHeight());
        
        addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y){
                onClick();
            };
        });
//		  Проверка коллизий:        
//        Polygon polygon = new Polygon(new float[]{0, 0, getWidth(), 0, getWidth(), getHeight(), 0, getHeight()});
//        polygon.setPosition(getX(), getY());
//        polygon.setOrigin(getOriginX(), getOriginY());
//        polygon.setScale(getScaleX(), getScaleY());
//        polygon.setRotation(getRotation());
    }
    
    protected void onClick(){}

    @Override
    public void draw(Batch batch, float parentAlpha) {
    	//TODO кусок с setColor используется только для становящихся прозрачными, 
    	//возможно стоит определить отдельный класс
		Color color = getColor();
	    batch.setColor(color.r, color.g, color.b, color.a * parentAlpha);
        batch.draw(region, getX(), getY(), getOriginX(), getOriginY(), getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());
        batch.setColor(color.r, color.g, color.b, 1f);
    }
    
    @Override
	public void setPosition (float x, float y, int alignment) {
		if ((alignment & right) != 0)
			x -= getWidth() * getScaleX();
		else if ((alignment & left) == 0) //
			x -= getWidth() * getScaleX() / 2;

		if ((alignment & top) != 0)
			y -= getHeight() * getScaleY();
		else if ((alignment & bottom) == 0) //
			y -= getHeight() * getScaleY() / 2;

		if (this.getX() != x || this.getY() != y) {
			this.setX(x);
			this.setY(y);
			positionChanged();
		}
	}
    
    public float getRealHeight(){
    	return getHeight() * getScaleY();
    }
    
    public float getRealWidth(){
    	return getWidth() * getScaleX();
    }
    
}