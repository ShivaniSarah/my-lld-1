package com.example.flipkart.model;

import lombok.Getter;

@Getter
public class Customer {

	private final String name;
	private final Integer customerID;

	public Customer(String name, Integer customerID) {
		this.name = name;
		this.customerID = customerID;
	}
}
