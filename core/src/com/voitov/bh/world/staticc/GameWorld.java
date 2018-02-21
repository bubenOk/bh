package com.voitov.bh.world.staticc;

import com.badlogic.gdx.utils.OrderedSet;
import com.voitov.bh.world.dynamic.User;
import com.voitov.bh.world.staticc.galaxy.Galaxy;

/** Объект, содержащий модель игрового мира. */

public class GameWorld {
	
	private OrderedSet<Galaxy> galaxies;

	GameWorld(User user, OrderedSet<Galaxy> galaxies) {
		super();
		this.galaxies = galaxies;
	}

	public OrderedSet<Galaxy> getGalaxies() {
		return galaxies;
	}

	public void setGalaxies(OrderedSet<Galaxy> galaxies) {
		this.galaxies = galaxies;
	}
	
}
