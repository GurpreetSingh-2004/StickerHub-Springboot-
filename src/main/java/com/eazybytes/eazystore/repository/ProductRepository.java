package com.eazybytes.eazystore.repository;

import com.eazybytes.eazystore.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository//for bean creation
public interface ProductRepository extends JpaRepository<Product, Long> {

}
