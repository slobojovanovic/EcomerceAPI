package com.ecommerce.demo.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.ecommerce.demo.entities.Product;
import com.ecommerce.demo.entities.Store;
import com.ecommerce.demo.exceptions.ApiIsNotAvailable;
import com.ecommerce.demo.repositories.ProductRepo;
import com.ecommerce.demo.repositories.StoreRepo;
import com.ecommerce.demo.service.ConsumerService;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class ConsumerServiceImpl implements ConsumerService {
	
	@Autowired
	private StoreRepo storeRepo;
	
	@Autowired
	private ProductRepo productRepo;

	@Override
	public List<Store> saveStores() {

		try {
			String uri = "https://63875e3ae399d2e473fcf3f6.mockapi.io/api/v1/stores";
			RestTemplate restTemplate = new RestTemplate();
			
			Store[] result = restTemplate.getForObject(uri, Store[].class);
			
			List<Store> storeList = Arrays.asList(result);
			
			storeList = storeRepo.saveAll(storeList);
			log.info("{} Sacuvano STORE zapisa ", storeList.size());
			return storeList;
		} catch (RestClientException e) {
			throw new ApiIsNotAvailable("Stores API provajder nije dostupan!!! ");
		}
		
	}

	@Override
	public List<Product> saveProducts() {

		String uri = "https://63875e3ae399d2e473fcf3f6.mockapi.io/api/v1/products";
		RestTemplate restTemplate = new RestTemplate();
		
		try {
			Product[] result = restTemplate.getForObject(uri, Product[].class);
			
			List<Product> productList = Arrays.asList(result);
			
			productList = productRepo.saveAll(productList);
			log.info("{} Sacuvano PRODUCT zapisa ", productList.size());
			return productList;
		} catch (RestClientException e) {
			 throw new ApiIsNotAvailable("Products API provajder nije dostupan!!! ");
		}
		
		
	}

}
