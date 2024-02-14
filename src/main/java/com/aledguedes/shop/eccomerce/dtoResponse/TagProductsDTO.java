package com.aledguedes.shop.eccomerce.dtoResponse;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TagProductsDTO {

    private String nameTag;
    @JsonIgnoreProperties({ "department", "category", "brand", "reviews" })
    private List<ProductResponse> products;
}
