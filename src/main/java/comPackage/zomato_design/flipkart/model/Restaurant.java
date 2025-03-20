package com.example.flipkart.model;

import com.example.flipkart.enums.Status;
import lombok.Getter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Getter
public class Restaurant {

	private final String name;
	private final Double rating;
	private final AtomicInteger maxNumberOfOrders;
	private final AtomicInteger currentOrderCount;
	private final Map<Integer, Dish> menu;
	private final Map<Integer, Order> orders;
	private final Integer id;

	public Restaurant(String name, Double rating, Integer maxNumberOfOrders, Integer id) {
		this.name = name;
		this.rating = rating;
		this.maxNumberOfOrders = new AtomicInteger(maxNumberOfOrders);
		this.id = id;
		this.menu = new HashMap<>();
		this.orders = new HashMap<>();
		this.currentOrderCount = new AtomicInteger(0);
	}

	public void updateDish(Dish dish) {
		menu.put(dish.getId(), dish);
	}

	public void updateMenu(Map<Integer, Dish> m) {
		menu.putAll(m);
	}

	public void addOrder(Order order) {
		orders.put(order.getOrderNumber(), order);
		this.currentOrderCount.incrementAndGet();
	}

	public void updateOrderStatus(Integer orderNumber) {
		orders.get(orderNumber).updateOrderStatus(Status.COMPLETED);
		this.currentOrderCount.decrementAndGet();
	}

	public boolean isMaxCapacityNotBreached() {
		return currentOrderCount.get() < maxNumberOfOrders.get();
	}

	public boolean canFulfillOrder(List<Item> items) {
		List<String> dishes = menu.values().stream().map(Dish::getName).toList();
		return items.stream().allMatch(i -> dishes.contains(i.getDish().getName()));
	}

	public int getCostOfItems(List<Item> items) {
		Map<String, Integer> dishPriceMap = menu.values().stream().collect(Collectors.toMap(Dish::getName, Dish::getPrice));
		return items.stream().mapToInt(item -> dishPriceMap.getOrDefault(item.getDish().getName(), 0)).sum();
	}
}
