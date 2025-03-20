package com.example.flipkart.model;

import lombok.Getter;

@Getter
public class Dish {

	private final String name;
	private final Integer price;
	private final Integer id;

	public Dish(String name, Integer price, Integer id) {
		this.name = name;
		this.price = price;
		this.id = id;
	}
}
