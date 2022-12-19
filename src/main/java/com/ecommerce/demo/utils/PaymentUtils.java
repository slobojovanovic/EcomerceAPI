package com.ecommerce.demo.utils;


import com.ecommerce.demo.entities.Product;
import com.ecommerce.demo.exceptions.ExceedAmountException;

public class PaymentUtils {

	public static boolean validateLimit(Product product, String requestAmount) {
		
		if(Integer.parseInt(requestAmount)>Integer.parseInt(product.amount)) {
			throw new ExceedAmountException("OVERSTOCKED PRODUCT IN THE STORE. PRODUCT WITH ID " + product.getId() + " IS NOT IN STOCK !!!"); 
		} else {
			return true;
		}
	}
}
