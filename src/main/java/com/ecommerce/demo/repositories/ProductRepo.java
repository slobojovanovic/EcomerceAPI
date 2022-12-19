package com.ecommerce.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ecommerce.demo.entities.Product;
//REPLACE(TRIM(p.name),' ', '%20')
public interface ProductRepo extends JpaRepository<Product, String> {

	@Query("select p from Product p where UPPER(p.name) = UPPER(:key)")
    List<Product> searchByName(@Param("key") String title);
}
