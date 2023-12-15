package com.aledguedes.shop.eccomerce.dtoResponse;

import java.time.LocalDateTime;

import com.aledguedes.shop.eccomerce.model.Brand;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(SnakeCaseStrategy.class)
public class ProductResponse {

    private Long id;
    private String name;
    private String detail;
    private String link_photo;
    private double price_product;
    private double price_promo;
    private int in_stok;
    private int available;
    private int delivery;
    private double discount;
    private Long category_idd;
    private Long department_idd;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    
    @JsonIgnoreProperties({"createdAt", "updatedAt"})
    private Brand brand;
}
