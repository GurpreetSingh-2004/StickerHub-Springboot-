package com.eazybytes.eazystore.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.processing.Generated;
import java.math.BigDecimal;
import java.time.Instant;

@Getter //lombok annotation it means there will be getter methods for all the fields present here and can
// also be used, although they are invisible, but they will be present in compiled code
@Setter
@Entity
@Table(name = "Products")
public class Product extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id", nullable = false)
    private Long productId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @Column(name = "popularity", nullable = false)
    private Integer popularity;

    @Column(name = "image_url", nullable = true)
    private String imageUrl;

}



