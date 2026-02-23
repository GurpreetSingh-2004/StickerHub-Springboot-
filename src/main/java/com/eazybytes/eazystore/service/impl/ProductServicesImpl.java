package com.eazybytes.eazystore.service.impl;

import com.eazybytes.eazystore.dto.ProductDto;
import com.eazybytes.eazystore.entities.Product;
import com.eazybytes.eazystore.repository.ProductRepository;
import com.eazybytes.eazystore.service.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor //lombok
public class ProductServicesImpl implements IProductService {
    private final ProductRepository productRepository;

//    @Autowired
//    public ProductServicesImpl(ProductRepository productRepository){
//        this.productRepository = productRepository;
//    }

    @Override
    public List<ProductDto> getProducts() {
        return productRepository.findAll()
                .stream().map(this::transformToDto).collect(Collectors.toList());
    }

    private ProductDto transformToDto(Product product) {
        ProductDto productDto = new ProductDto();
        //productDto.setProductId(product.getProductId()); //or i can use bean util method
        // if names in productDto and product fields are same

        BeanUtils.copyProperties(product, productDto);//it just copyies all the content of product
        // to productDto
        return productDto;
    }
}
