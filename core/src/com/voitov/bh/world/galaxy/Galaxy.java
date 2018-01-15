package com.voitov.bh.world.galaxy;

import com.badlogic.gdx.utils.OrderedSet;

/** Объект, содержащий модель статичной части игрового мира. */

//TODO добавить транспортную информацию 

public class Galaxy {
	
	private Star star;
	
	private OrderedSet<Planet> planets;
	
	public Galaxy(Star star, OrderedSet<Planet> planets) {
		this.star = star;
		this.planets = planets;
	}

	public OrderedSet<Planet> getPlanets() {
		return planets;
	}

	public Star getStar() {
		return star;
	}

}
