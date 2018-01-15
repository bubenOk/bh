package com.voitov.bh.textures;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ObjectMap;

/** Служит для загрузки и управления графическими ресурсами. */

public class TextureManager extends AssetManager {
	
	
	private ObjectMap<TextureType, Texture> textureMap;
	
	public TextureManager(){
		textureMap = TextureType.loadAllTextures();
	}
	
    public Texture getTexture(TextureType texture) {
        return textureMap.get(texture);
    }
    
    public void dispose(){
    	for (Texture t : textureMap.values()) {
		    t.dispose();
        }
    }
}
