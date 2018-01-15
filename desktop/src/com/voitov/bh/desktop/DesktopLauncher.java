package com.voitov.bh.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.voitov.bh.BHGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		System.setProperty("user.name","Public");
		 config.title = "Black Hole";
	        config.width = 640;
	        config.height = 360;
		
		new LwjglApplication(new BHGame(), config);
	}
}
