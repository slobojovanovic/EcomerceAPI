package com.ecommerce.demo.dto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Box {
	String id; String name; String amount;
	 
	 @Override
	public String toString() {
		return id + " : " + name + " x " + amount;
	}
}
