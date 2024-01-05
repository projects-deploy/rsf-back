package com.aledguedes.shop.eccomerce.dtoRequest;

import java.time.LocalDateTime;

import com.aledguedes.shop.eccomerce.model.Customer;
import com.aledguedes.shop.eccomerce.model.Product;
import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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

    @NotEmpty
    @Size(min = 3, max = 100)
    @NotNull(message = "Code é um dado obrigatório!")
    private String code;

    @NotNull
    @NotEmpty
    private double discount;

    @NotNull
    @NotEmpty
    private LocalDateTime expiration_date;

    private Product product;
    private Customer customer;
}
