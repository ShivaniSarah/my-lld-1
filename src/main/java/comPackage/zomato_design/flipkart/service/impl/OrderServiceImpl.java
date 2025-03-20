package com.example.flipkart.service.impl;

import com.example.flipkart.enums.Status;
import com.example.flipkart.model.Order;
import com.example.flipkart.model.Restaurant;
import com.example.flipkart.selectionStrategy.RestaurantSelectionStrategy;
import com.example.flipkart.service.OrderService;
import com.example.flipkart.service.RestaurantService;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class OrderServiceImpl implements OrderService {

	private final RestaurantService restaurantService;

	private final Map<String, RestaurantSelectionStrategy> restaurantSelectionStrategy;

	private final Map<Integer, Order> orders;

	public OrderServiceImpl(RestaurantService restaurantService, Map<String, RestaurantSelectionStrategy> restaurantSelectionStrategy) {
		this.restaurantService = restaurantService;
		this.restaurantSelectionStrategy = restaurantSelectionStrategy;
		this.orders = new ConcurrentHashMap<>();
	}

	@Override
	public void placeOrder(Order order) {
		List<Restaurant> restaurants = restaurantService.getRestaurant();
		RestaurantSelectionStrategy selectionStrategy = restaurantSelectionStrategy.get(order.getSelectionStrategy().name());
		Optional<Restaurant> restaurant = selectionStrategy.getRestaurant(restaurants, order.getItems());
		if (restaurant.isPresent()) {
			order.updateOrderStatus(Status.ACCEPTED);
			restaurant.get().addOrder(order);
			orders.put(order.getOrderNumber(), order);
		} else {
			System.out.println("Restaurant not available to accept order");
		}
	}
}
