package com.voitov.bh.actors;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class SimpleActor extends Actor {

    private final TextureRegion region;

    public SimpleActor(TextureRegion region) {
        this.region = region;
        setSize(region.getRegionWidth(), region.getRegionHeight());
        setBounds(0, 0, getWidth(), getHeight());
        
//		  Проверка коллизий:        
//        Polygon polygon = new Polygon(new float[]{0, 0, getWidth(), 0, getWidth(), getHeight(), 0, getHeight()});
//        polygon.setPosition(getX(), getY());
//        polygon.setOrigin(getOriginX(), getOriginY());
//        polygon.setScale(getScaleX(), getScaleY());
//        polygon.setRotation(getRotation());
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(region, getX(), getY(), getOriginX(), getOriginY(), getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());
    }
}