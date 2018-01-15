package com.voitov.bh.world.galaxy;

public class Star{
	public enum StarType{COLD, HOT}
	
	private StarType type;

	public Star(StarType type) {
		super();
		this.type = type;
	}

	public StarType getType() {
		return type;
	}
	
}
