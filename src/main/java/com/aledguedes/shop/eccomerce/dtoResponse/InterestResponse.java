package com.aledguedes.shop.eccomerce.dtoResponse;

import java.time.LocalDateTime;

import com.aledguedes.shop.eccomerce.model.Customer;
import com.aledguedes.shop.eccomerce.model.Product;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InterestResponse {

    private Long id;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;

    @JsonIgnoreProperties({ "category", "department", "brand", "reviews", "createdAt", "updatedAt" })
    private Product product;

    @JsonIgnoreProperties({ "favorites", "reviews", "createdAt", "updatedAt" })
    private Customer customer;


}
