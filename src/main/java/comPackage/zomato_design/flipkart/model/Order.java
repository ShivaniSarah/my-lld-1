package com.example.flipkart.model;

import com.example.flipkart.enums.SelectionStrategy;
import com.example.flipkart.enums.Status;
import lombok.Getter;

import java.util.List;

@Getter
public class Order {

	private final Customer customer;
	private final Integer orderNumber;
	private final List<Item> items;
	private final SelectionStrategy selectionStrategy;
	private Status status;


	public Order(Customer customer, Integer orderNumber, List<Item> items, SelectionStrategy selectionStrategy) {
		this.customer = customer;
		this.orderNumber = orderNumber;
		this.items = items;
		this.selectionStrategy = selectionStrategy;
		this.status = Status.CREATED;
	}

	public void updateOrderStatus(Status status) {
		this.status = status;
	}
}
