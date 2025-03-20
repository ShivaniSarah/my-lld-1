package com.example.flipkart.model;

import lombok.Getter;

@Getter
public class Item {

	private final Dish dish;
	private final Integer quantity;

	public Item(Dish dish, Integer quantity) {
		this.dish = dish;
		this.quantity = quantity;
	}
}
