package com.voitov.bh.desktop;

import com.badlogic.gdx.tools.texturepacker.TexturePacker;

public class PackTextures{

    public static void main(String[] args) {
        TexturePacker.Settings s = new TexturePacker.Settings();
        TexturePacker.process(s, "../desktop/workfiles/loading", "../android/assets/data", "loading");
        TexturePacker.process(s, "../desktop/workfiles/main", "../android/assets/data", "main");
    }
}
