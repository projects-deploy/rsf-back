package com.aledguedes.shop.eccomerce.dtoRequest;

import com.aledguedes.shop.eccomerce.model.Customer;
import com.aledguedes.shop.eccomerce.model.Product;
import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(SnakeCaseStrategy.class)
public class CouponRequest {

    @NotNull
    private Integer discount;

    private Product product;
    private Customer customer;
}
