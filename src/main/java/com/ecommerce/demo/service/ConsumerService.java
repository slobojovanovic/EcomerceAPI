package com.ecommerce.demo.service;


import java.util.List;

import org.springframework.stereotype.Component;

import com.ecommerce.demo.entities.Product;
import com.ecommerce.demo.entities.Store;

@Component
public interface ConsumerService {
	
	//vraća sve prodavnice
	//void saveStores();
	List<Store> saveStores();
	
	//vraća sve proizvode
	//void saveProducts();
	List<Product> saveProducts();
	
}
