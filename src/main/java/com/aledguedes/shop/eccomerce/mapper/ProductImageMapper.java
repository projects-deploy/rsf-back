package com.aledguedes.shop.eccomerce.mapper;

import com.aledguedes.shop.eccomerce.dtoRequest.ProductImageRequest;
import com.aledguedes.shop.eccomerce.dtoResponse.ProductImageResponse;
import com.aledguedes.shop.eccomerce.model.ProductImage;

public interface ProductImageMapper {

    ProductImage toProductImage(ProductImageRequest productImageRequest);
    ProductImageResponse toProductImageResponse(ProductImage productImage);
}