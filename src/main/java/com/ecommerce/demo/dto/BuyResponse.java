package com.ecommerce.demo.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BuyResponse {

	private String totalListProduct;
	private String totalAmount;
	private String totalPrice;
	private String time;
	
	@Override
	public String toString() {
		return "Total List Product: " + totalListProduct + " ; Total Amount: " + totalAmount 
				+ ";  Total Price: " + totalPrice + "; Time: " + time;
	}
}
