package com.example.flipkart.service;

import com.example.flipkart.model.Dish;
import com.example.flipkart.model.Restaurant;

import java.util.List;
import java.util.Map;

public interface RestaurantService {

	void addRestaurant(Restaurant restaurant);

	void addMenuToRestaurant(Integer id, Map<Integer, Dish> menu);

	void updateMenuItem(Integer id, Dish dish);

	List<Restaurant> getRestaurant();
}
