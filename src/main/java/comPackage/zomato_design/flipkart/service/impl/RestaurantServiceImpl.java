package com.example.flipkart.service.impl;

import com.example.flipkart.model.Dish;
import com.example.flipkart.model.Restaurant;
import com.example.flipkart.service.RestaurantService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RestaurantServiceImpl implements RestaurantService {

	private final Map<Integer, Restaurant> restaurants;

	public RestaurantServiceImpl() {
		this.restaurants = new HashMap<>();
	}

	@Override
	public void addRestaurant(Restaurant restaurant) {
		if (!restaurants.containsKey(restaurant.getId())) {
			restaurants.put(restaurant.getId(), restaurant);
		}
	}

	@Override
	public void addMenuToRestaurant(Integer id, Map<Integer, Dish> menu) {
		if (!restaurants.containsKey(id)) {
			throw new IllegalArgumentException("No restaurant present");
		}
		restaurants.get(id).updateMenu(menu);
	}

	@Override
	public void updateMenuItem(Integer id, Dish dish) {
		restaurants.get(id).updateDish(dish);
	}

	@Override
	public List<Restaurant> getRestaurant() {
		return new ArrayList<>(restaurants.values());
	}
}
