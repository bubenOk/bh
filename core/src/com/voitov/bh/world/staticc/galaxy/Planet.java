package com.voitov.bh.world.staticc.galaxy;

public class Planet{
	
	public enum PlanetType{green, red, blue}
	
	private PlanetType type;
	
	private float startPosition;// between 0 and 2PI
	
	private String name;
	
	public Planet(PlanetType type, float startPosition, String name) {
		this.type = type;
		this.startPosition = startPosition;
		this.name = name;
	}

	public PlanetType getType() {
		return type;
	}

	public float getStartPosition() {
		return startPosition;
	}

	public String getName() {
		return name;
	}
	
}
