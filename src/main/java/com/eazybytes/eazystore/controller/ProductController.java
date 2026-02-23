package com.eazybytes.eazystore.controller;


import com.eazybytes.eazystore.dto.ProductDto;
import com.eazybytes.eazystore.entities.Product;
import com.eazybytes.eazystore.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//@CrossOrigin(origins = "http://localhost:5173")
//@EnableJpaRepositories  can pass the repo path
//@EntityScan can pass the file path of entity
@RestController
//@RequiredArgsConstructor // if this is used no need of constructor in the class
@RequestMapping("api/v1/products")
public class ProductController {

    private final IProductService iProductService;

    @Autowired //constructor dependency optional because if there is only one constructor then no need to mention
    // autowired framework can itself resolve where to inject dependencies
    public ProductController(IProductService iProductService) {
        this.iProductService = iProductService;
    }

    @GetMapping
    public ResponseEntity<List<ProductDto>> getProducts() {
        List<ProductDto> productList = iProductService.getProducts();
        return ResponseEntity.status(HttpStatus.OK).body(productList);
    }
}
