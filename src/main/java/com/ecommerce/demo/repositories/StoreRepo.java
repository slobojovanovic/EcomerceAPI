package com.ecommerce.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ecommerce.demo.entities.Store;

public interface StoreRepo extends JpaRepository<Store, String> {
    
    @Query("select p from Store p where UPPER(p.name) like UPPER(:key)")
    List<Store> searchByName(@Param("key") String title);
}
