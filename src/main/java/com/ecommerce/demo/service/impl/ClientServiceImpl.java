package com.ecommerce.demo.service.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.demo.dto.Box;
import com.ecommerce.demo.dto.BuyRequest;
import com.ecommerce.demo.dto.BuyResponse;
import com.ecommerce.demo.dto.ProductDto;
import com.ecommerce.demo.dto.StoreDto;
import com.ecommerce.demo.entities.Product;
import com.ecommerce.demo.entities.Store;
import com.ecommerce.demo.exceptions.ResourceNotFounfException;
import com.ecommerce.demo.repositories.ProductRepo;
import com.ecommerce.demo.repositories.StoreRepo;
import com.ecommerce.demo.service.ClientService;
import com.ecommerce.demo.utils.PaymentUtils;

import jakarta.transaction.Transactional;

@Service
public class ClientServiceImpl implements ClientService {
	
	@Autowired
	private StoreRepo storeRepo;
	
	@Autowired
    private ModelMapper modelMaper;
	
	@Autowired
	private ProductRepo productRepo;

	@Override
	public List<StoreDto> searchStores(String keyword) {
    	
    	List<Store> stores = this.storeRepo.searchByName("%"+keyword+"%");
        
        List<StoreDto> storeDtos = stores.stream().map((store) -> this.modelMaper
        		.map(store, StoreDto.class))
        		.collect(Collectors.toList());
        
        return storeDtos;
	}

	@Override
	public List<ProductDto> searchProducts(String keyword) {
		
		List<Product> products = this.productRepo.searchByName(keyword);
        
        List<ProductDto> productDtos = products.stream().map((product) -> this.modelMaper
        		.map(product, ProductDto.class))
        		.collect(Collectors.toList());
        
        return productDtos;
	}

	@Override
	public ProductDto getProductById(String productId) {
		
		 Product product = this.productRepo.findById(productId)
						  .orElseThrow(() -> 
						  new ResourceNotFounfException("Product", "id", productId));
		 ProductDto productDto = this.modelMaper.map(product, ProductDto.class);
		 return productDto;
	}
	
	@Override
	@Transactional
	public BuyResponse buyProducts(List<BuyRequest> request) {
	
		var finalAmount = new Object(){ int ordinal = 0; };
		var finalPrice = new Object(){ Double ordinal = 0.00; };
		
		List<Box> arrFoos = new ArrayList<Box>();

        request.forEach((temp) -> {
            System.out.println(temp);
        
			String requestId = temp.getId();
			String requestAmount = temp.getAmount();
			
			Product product = this.productRepo.findById(requestId)
							.orElseThrow(() -> 
							  new ResourceNotFounfException("Product", "id", requestId));
			
			//System.out.println(product.toString());
			
			if(PaymentUtils.validateLimit(product, requestAmount)) {
				
				Integer resultAmount = Integer.parseInt(product.getAmount()) - Integer.parseInt(requestAmount);  
				
				product.setAmount(Integer.toString(resultAmount));
				
				this.productRepo.save(product);
			
				finalAmount.ordinal += Integer.parseInt(requestAmount);
				finalPrice.ordinal += Double.parseDouble(product.getPrice())*Double.parseDouble(requestAmount);
				
				arrFoos.add(new Box(requestId, product.getName(), requestAmount));
				/*
				System.out.println("New amount : " + product.getAmount() +
						" : " + finalAmount.ordinal +" : " + finalPrice.ordinal);*/
	
			}
			
			System.out.println(requestAmount + " : " +
					Double.toString(Double.parseDouble(product.getPrice())*Double.parseDouble(requestAmount)) + " : " + 
					LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss")));

        });

        //System.out.println(arrFoos.toString());
        
        return new BuyResponse(arrFoos.toString(), Integer.toString(finalAmount.ordinal), 
        		Double.toString(finalPrice.ordinal),
				LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss")));
	}

}
