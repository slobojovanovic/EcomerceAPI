package com.ecommerce.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BuyRequest {
	
	private String id;
	private String amount;
	
	
	
}
