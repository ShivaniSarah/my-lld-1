package com.example.flipkart;

import com.example.flipkart.model.Customer;
import com.example.flipkart.model.Dish;
import com.example.flipkart.model.Order;
import com.example.flipkart.model.Restaurant;
import com.example.flipkart.service.OrderService;
import com.example.flipkart.service.RestaurantService;

import java.util.HashMap;
import java.util.Map;


public class FoodDeliverySystem {
	private final Map<Integer, Customer> customers;
	private final RestaurantService restaurantService;
	private final OrderService orderService;

	FoodDeliverySystem(RestaurantService restaurantService, OrderService orderService) {
		this.restaurantService = restaurantService;
		this.orderService = orderService;
		this.customers = new HashMap<>();
	}

	public void addCustomer(Customer customer) {
		customers.putIfAbsent(customer.getCustomerID(), customer);
	}

	public void addRestaurant(Restaurant restaurant, Map<Integer, Dish> menu) {
		restaurantService.addRestaurant(restaurant);
		addMenuToRestaurant(restaurant.getId(), menu);
	}

	public void updateDishForRestaurant(Restaurant restaurant, Dish dish) {
		restaurantService.updateMenuItem(restaurant.getId(), dish);
	}

	private void addMenuToRestaurant(Integer id, Map<Integer, Dish> menu) {
		restaurantService.addMenuToRestaurant(id, menu);
	}

	public void placeOrder(Order order) {
		orderService.placeOrder(order);
	}
}
