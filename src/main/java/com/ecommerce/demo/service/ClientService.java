package com.ecommerce.demo.service;

import java.util.List;

import com.ecommerce.demo.dto.BuyRequest;
import com.ecommerce.demo.dto.BuyResponse;
import com.ecommerce.demo.dto.ProductDto;
import com.ecommerce.demo.dto.StoreDto;

public interface ClientService {

	//Pretraživanje prodavnica po nazivu 
    List<StoreDto> searchStores(String keyword);
    
    //Pretraživanje proizvoda po nazivu (full-fext)
    List<ProductDto> searchProducts(String keyword);
    
    //Dohvatanje podataka o proizvodu preko ID-a
    ProductDto getProductById(String productId);
    
    //Kupovina proizvoda List<BuyRequest>
    //BuyResponse buyProducts(BuyRequest buyRequest);
    BuyResponse buyProducts(List<BuyRequest> buyRequest);
}
