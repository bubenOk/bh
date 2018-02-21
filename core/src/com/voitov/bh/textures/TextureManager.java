package com.voitov.bh.textures;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/** Служит для загрузки и управления графическими ресурсами. */

public class TextureManager extends AssetManager {
// надо сделать синонимизацию ресурсов
	
	public TextureRegion getTexture(String name){
		return get("data/main.atlas", TextureAtlas.class).findRegion(name);
	}
	
}

//Пример создания текстуры программно:
//Pixmap blackPixelPixmap = new Pixmap(1, 1, Pixmap.Format.RGB888);
//blackPixelPixmap.setColor(0f,0f,0f, 1f);
//blackPixelPixmap.fill();
//Texture blackPixel = new Texture(blackPixelPixmap);
//blackPixelPixmap.dispose();
//return blackPixel;