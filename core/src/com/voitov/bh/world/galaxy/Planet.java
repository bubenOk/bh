package com.voitov.bh.world.galaxy;

public class Planet{
	
	public enum PlanetType{GREEN, RED, GRAY}
	
	private PlanetType type;
	
	private float startPosition;// between 0 and 2PI
	
	public Planet(PlanetType type, float startPosition) {
		this.type = type;
		this.startPosition = startPosition;
	}

	public PlanetType getType() {
		return type;
	}

	public float getStartPosition() {
		return startPosition;
	}
	
}
