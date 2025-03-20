package com.example.flipkart;

import com.example.flipkart.enums.SelectionStrategy;
import com.example.flipkart.model.Customer;
import com.example.flipkart.model.Dish;
import com.example.flipkart.model.Item;
import com.example.flipkart.model.Order;
import com.example.flipkart.model.Restaurant;
import com.example.flipkart.selectionStrategy.HighestRatingSelectionStrategy;
import com.example.flipkart.selectionStrategy.LowestCostSelectionStrategy;
import com.example.flipkart.selectionStrategy.RestaurantSelectionStrategy;
import com.example.flipkart.service.OrderService;
import com.example.flipkart.service.RestaurantService;
import com.example.flipkart.service.impl.OrderServiceImpl;
import com.example.flipkart.service.impl.RestaurantServiceImpl;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class FoodDeliveryLLDTest {

	public static void main(String[] args) {
		RestaurantService restaurantService = new RestaurantServiceImpl();

		Map<String, RestaurantSelectionStrategy> restaurantSelectionStrategy = new HashMap<>();
		restaurantSelectionStrategy.put(SelectionStrategy.RATING.name(), new HighestRatingSelectionStrategy());
		restaurantSelectionStrategy.put(SelectionStrategy.LOW_COST.name(), new LowestCostSelectionStrategy());
		OrderService orderService = new OrderServiceImpl(restaurantService, restaurantSelectionStrategy);

		FoodDeliverySystem foodDeliverySystem = new FoodDeliverySystem(restaurantService, orderService);

		Customer customer1 = new Customer("Aman", 1);
		Customer customer2 = new Customer("Akash", 2);

		foodDeliverySystem.addCustomer(customer1);
		foodDeliverySystem.addCustomer(customer2);

		Dish dish1 = new Dish("Chicken Biryani", 100, 1);
		Dish dish2 = new Dish("Idli", 30, 1);
		Dish dish3 = new Dish("Dosa", 50, 1);
		Dish dish4 = new Dish("Paneer Tikka", 200, 1);

		Map<Integer, Dish> menuR1 = new HashMap<>();
		menuR1.put(dish1.getId(), dish1);
		menuR1.put(dish2.getId(), dish2);

		Map<Integer, Dish> menuR2 = new HashMap<>();
		menuR2.put(dish3.getId(), dish3);
		menuR2.put(dish4.getId(), dish4);

		Restaurant restaurant1 = new Restaurant("R1", 4.5, 1, 1);
		Restaurant restaurant2 = new Restaurant("R2", 3.5, 1, 2);

		foodDeliverySystem.addRestaurant(restaurant1, menuR1);
		foodDeliverySystem.addRestaurant(restaurant2, menuR2);

		Item item1 = new Item(dish1, 1);
		Item item2 = new Item(dish2, 2);
		List<Item> itemsList = new LinkedList<>();
		itemsList.add(item1);
		itemsList.add(item2);

		Order order = new Order(customer1, 1, itemsList, SelectionStrategy.RATING);
		foodDeliverySystem.placeOrder(order);
		Order order2 = new Order(customer2, 2, itemsList, SelectionStrategy.LOW_COST);
		foodDeliverySystem.placeOrder(order2);
	}
}
