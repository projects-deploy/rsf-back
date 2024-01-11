package com.aledguedes.shop.eccomerce.dtoResponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import com.aledguedes.shop.eccomerce.model.Customer;
import com.aledguedes.shop.eccomerce.model.Product;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReviewResponse {

    private Long id;
    private int rating;
    private String title;
    private String comment;
    @JsonIgnoreProperties({"reviews", "favorites"})
    private Customer customer;
    @JsonIgnoreProperties({"images"})
    private Product product;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
