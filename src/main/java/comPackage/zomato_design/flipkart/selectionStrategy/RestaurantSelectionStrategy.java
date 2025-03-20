package com.example.flipkart.selectionStrategy;

import com.example.flipkart.model.Item;
import com.example.flipkart.model.Restaurant;

import java.util.List;
import java.util.Optional;

public interface RestaurantSelectionStrategy {

	Optional<Restaurant> getRestaurant(List<Restaurant> restaurants, List<Item> items);
}
