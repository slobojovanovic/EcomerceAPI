package com.ecommerce.demo.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.ecommerce.demo.entities.Product;
import com.ecommerce.demo.entities.Store;
import com.ecommerce.demo.repositories.ProductRepo;
import com.ecommerce.demo.repositories.StoreRepo;

class ConsumerServiceImplTest {
	
	@InjectMocks
	ConsumerServiceImpl consumerServiceImpl;

	@Mock
	ProductRepo productRepo;
	
	@Mock
	StoreRepo storeRepo;
	
	@SuppressWarnings("deprecation")
	@BeforeEach
	void setUp()  {
		MockitoAnnotations.initMocks(this);
	}
	
	
	@Test
	public void verifyFindOneProductRecord() {
	
			Product[] product;
			product = new Product[1];
			
			product[0] = new Product("1","Licensed Cotton Pants","Image","100","100","Link","Description",new java.sql.Date(System.currentTimeMillis()));
				
			when(productRepo.saveAll(anyList())).thenReturn(Arrays.asList(product));
			  
			List<Product> list = consumerServiceImpl.saveProducts();
			
			assertNotNull(list);
			//assertEquals(product[0].getName(), list.get(0).name.toString());
			assertEquals("Licensed Cotton Pants", list.get(0).name.toString());

	}
	@Test
	public void productApiNullPointerException() {
		Product[] product;
		product = new Product[1];
		
		product[0] = new Product("1","Licensed Cotton Pants","Image","100","100","Link","Description",new java.sql.Date(System.currentTimeMillis()));
			
		when(productRepo.saveAll(anyList())).thenReturn(null);
		 
		 assertThrows(NullPointerException.class, () -> {
			
			 consumerServiceImpl.saveProducts();
		 });
	}
	
	@Test
	public void verifyFindOneStoreRecord() {
	
			Store[] store;
			store = new Store[1];
			
			store[0] = new Store("1", "The Football Is Good For Training And Recreational Purposes", "https://loremflickr.com/640/480/technics", new java.sql.Date(System.currentTimeMillis()));
				
			when(storeRepo.saveAll(anyList())).thenReturn(Arrays.asList(store));
			  
			List<Store> list = consumerServiceImpl.saveStores();
			
			assertNotNull(list);
			//assertEquals(product[0].getName(), list.get(0).name.toString());
			assertEquals(store[0].getName(), list.get(0).getName());
	}
	
	@Test
	public void storeApiNullPointerException() {
		Store[] store;
		store = new Store[1];
		
		store[0] = new Store("1", "The Football Is Good For Training And Recreational Purposes", "https://loremflickr.com/640/480/technics", new java.sql.Date(System.currentTimeMillis()));
			
		when(storeRepo.saveAll(anyList())).thenReturn(null);
		 
		 assertThrows(NullPointerException.class, () -> {
			
			 consumerServiceImpl.saveStores();
		 });
	}
}
