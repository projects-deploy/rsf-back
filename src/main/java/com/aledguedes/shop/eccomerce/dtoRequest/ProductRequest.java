package com.aledguedes.shop.eccomerce.dtoRequest;

import com.aledguedes.shop.eccomerce.model.Brand;
import com.aledguedes.shop.eccomerce.model.SubCategory;
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
public class ProductRequest {

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 100)
    private String name;

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 100)
    private String detail;

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 300)
    private String link_photo;

    @NotNull
    private double price_product;

    @NotNull
    private int in_stok;
    private int discount;
    private int delivery;
    private Brand brand;
    private SubCategory sub_category;
}
