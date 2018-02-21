package com.voitov.bh.world.staticc.galaxy;

import com.badlogic.gdx.utils.OrderedSet;

/** Объект, содержащий модель статичной части игрового мира. */

//TODO добавить транспортную информацию (куда можно попасть)

public class Galaxy {
	
	public enum GalaxyType{back, back2}
	
	private GalaxyType type;
	
	private Star star;
	
	private OrderedSet<Planet> planets;
	
	public Galaxy(Star star, OrderedSet<Planet> planets, GalaxyType type) {
		this.star = star;
		this.planets = planets;
		this.type = type;
	}

	public OrderedSet<Planet> getPlanets() {
		return planets;
	}

	public Star getStar() {
		return star;
	}

	public GalaxyType getType() {
		return type;
	}
}
