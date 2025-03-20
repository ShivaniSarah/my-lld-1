package com.example.flipkart.selectionStrategy;

import com.example.flipkart.model.Item;
import com.example.flipkart.model.Restaurant;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class HighestRatingSelectionStrategy implements RestaurantSelectionStrategy {

	@Override
	public Optional<Restaurant> getRestaurant(List<Restaurant> restaurants, List<Item> items) {
		return restaurants.stream().filter(Restaurant::isMaxCapacityNotBreached)
				.filter(r -> r.canFulfillOrder(items)).max(Comparator.comparing(Restaurant::getRating));
	}
}
