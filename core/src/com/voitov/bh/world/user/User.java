package com.voitov.bh.world.user;

import com.badlogic.gdx.utils.OrderedSet;

/** Объект, содержащий модель изменяемой части игрового мира. */

//TODO добавить логику сохранения в память

public class User {
	
	private String name;
	
	private int money;
	
	private int gelly;
	
	private OrderedSet<Item> equippedItems;
	
	private OrderedSet<Item> ownedItems;
	
	public User(String name, int money, int gelly,
			OrderedSet<Item> equippedItems, OrderedSet<Item> ownedItems) {
		this.name = name;
		this.money = money;
		this.gelly = gelly;
		this.equippedItems = equippedItems;
		this.ownedItems = ownedItems;
	}

	public String getName() {
		return name;
	}

	public int getMoney() {
		return money;
	}

	public int getGelly() {
		return gelly;
	}

	public OrderedSet<Item> getEquippedItems() {
		return equippedItems;
	}

	public OrderedSet<Item> getOwnedItems() {
		return ownedItems;
	}
	
}
