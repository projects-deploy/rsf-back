package com.aledguedes.shop.eccomerce.dtoRequest;

import jakarta.validation.constraints.Size;

import com.aledguedes.shop.eccomerce.model.Customer;
import com.aledguedes.shop.eccomerce.model.Product;
import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import jakarta.validation.constraints.NotEmpty;
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
public class ReviewRequest {

    @NotNull
    @NotEmpty
    @Size(max = 255)
    private String title;

    @NotNull
    private int rating;

    @NotNull
    @NotEmpty
    private String comment;

    @NotNull
    private Product product;

    @NotNull
    private Customer customer;
}
