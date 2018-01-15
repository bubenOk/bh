package com.voitov.bh.world;

import com.badlogic.gdx.utils.OrderedSet;
import com.voitov.bh.world.galaxy.Planet;
import com.voitov.bh.world.user.User;

/** Объект, содержащий модель игрового мира. */

public class GameWorld {
	
	private User user;
	
	private OrderedSet<Planet> galaxies;

	public GameWorld(User user, OrderedSet<Planet> galaxies) {
		super();
		this.user = user;
		this.galaxies = galaxies;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public OrderedSet<Planet> getGalaxies() {
		return galaxies;
	}

	public void setGalaxies(OrderedSet<Planet> galaxies) {
		this.galaxies = galaxies;
	}
	
}
