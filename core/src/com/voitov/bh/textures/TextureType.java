package com.voitov.bh.textures;

import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ObjectMap;

/** Список графических ресурсов, используемых в приложении. */

public enum TextureType {
	//BlackPixel ломает логику, надо его убрать нахер!!
	
    BADLOGIC("data/space/back2.jpg"),
    BLACKPIXEL() {
        // We override the default "load by file name" get() method and return the generated Texture instead.
        @Override
        public Texture get() {
            Pixmap blackPixelPixmap = new Pixmap(1, 1, Pixmap.Format.RGB888);
            blackPixelPixmap.setColor(0f,0f,0f, 1f);
            blackPixelPixmap.fill();
            Texture blackPixel = new Texture(blackPixelPixmap);
            blackPixelPixmap.dispose();
            return blackPixel;
        }
    },
    CARNAVAL("data/texture.png");

    private String fileName = null;

    TextureType() {}

    TextureType(String fileName) {
        this.fileName = fileName;
    }

    protected Texture get() {
        if (fileName != null) {
            return new Texture(fileName);
        } else {
            throw new IllegalArgumentException("No filename for this texture.");
        }
    }

    public static ObjectMap<TextureType, Texture> loadAllTextures() {
        ObjectMap<TextureType, Texture> textureMap = new ObjectMap<TextureType, Texture>();
        for (TextureType t : TextureType.values()) {
            textureMap.put(t, t.get());
        }
        return textureMap;
    }
}
