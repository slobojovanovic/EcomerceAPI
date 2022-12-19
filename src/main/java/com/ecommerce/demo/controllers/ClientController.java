package com.ecommerce.demo.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.demo.dto.BuyRequest;
import com.ecommerce.demo.dto.BuyResponse;
import com.ecommerce.demo.dto.ProductDto;
import com.ecommerce.demo.dto.StoreDto;
import com.ecommerce.demo.service.ClientService;

@RestController
@EnableTransactionManagement
@RequestMapping("/api")
public class ClientController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ClientController.class);

	@Autowired
    private ClientService clientService;
	
	//search stores by name 
	//http://localhost:8080/api/stores/search/funk
	@GetMapping("/stores/search/{keywords}")
    public ResponseEntity<List<StoreDto>> searchStoresByName( 
    	@PathVariable("keywords") String keywords
    ) {
    	List<StoreDto> result = this.clientService.searchStores(keywords);
    	return new ResponseEntity<List<StoreDto>>(result, HttpStatus.OK);
    }
	
	//search products by name 
	//http://localhost:8080/api/products/search/Licensed Cotton Pants
	@GetMapping("/products/search/{keywords}")
    public ResponseEntity<List<ProductDto>> searchProductsByName( 
    	@PathVariable("keywords") String keywords
    ) {
    	List<ProductDto> result = this.clientService.searchProducts(keywords);
    	return new ResponseEntity<List<ProductDto>>(result, HttpStatus.OK);
    }
	
	
    //GET - get single product by id
	//http://localhost:8080/api/product/24
    @GetMapping("/product/{productId}")
    public ResponseEntity<ProductDto> getSingleUsers(@PathVariable String productId) {
    	//LOGGER.info(this.clientService.getProductById(productId).toString());
    	return ResponseEntity.ok(this.clientService.getProductById(productId));

    }
    
    //GET - kupovina proizvoda
    //http://localhost:8080/api/buyproducts 
    /*
     [
	    {
	    "id":"17",
	    "amount":"2"
	    }
	 ]
     */
    @GetMapping("/buyproducts") 
    public BuyResponse bayProducts(@RequestBody List<BuyRequest> request) {
    	BuyResponse byResponse = clientService.buyProducts(request);
    	LOGGER.info(byResponse.toString());
    	return byResponse;
    }
}
