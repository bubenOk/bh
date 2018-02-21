package com.voitov.bh.world.staticc.galaxy;

public class Star{
	public enum StarType{cold, hot}
	
	private StarType type;
	
	private String name;

	public Star(StarType type, String name) {
		super();
		this.type = type;
		this.name = name;
	}

	public StarType getType() {
		return type;
	}

	public String getName() {
		return name;
	}
	
}
