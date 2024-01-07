package com.aledguedes.shop.eccomerce.dtoResponse;

import java.util.List;

import com.aledguedes.shop.eccomerce.model.Product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductImageResponse {

    private Long id;
    private List<String> images_url;
    private Product product;

}
