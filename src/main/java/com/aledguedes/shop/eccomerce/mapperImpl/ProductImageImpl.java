package com.aledguedes.shop.eccomerce.mapperImpl;

import org.springframework.stereotype.Component;

import com.aledguedes.shop.eccomerce.dtoRequest.ProductImageRequest;
import com.aledguedes.shop.eccomerce.dtoResponse.ProductImageResponse;
import com.aledguedes.shop.eccomerce.mapper.ProductImageMapper;
import com.aledguedes.shop.eccomerce.model.ProductImage;

@Component
public class ProductImageImpl implements ProductImageMapper {

    @Override
    public ProductImage toProductImage(ProductImageRequest productImageRequest) {
        if (productImageRequest == null) {
            return null;
        }

        return ProductImage.builder()
                .images_url(productImageRequest.getImages_url())
                .product(productImageRequest.getProduct())
                .build();
    }

    @Override
    public ProductImageResponse toProductImageResponse(ProductImage productImage) {
        if (productImage == null) {
            return null;
        }

        return ProductImageResponse.builder()
        		.id(productImage.getId())
                .images_url(productImage.getImages_url())
                .product(productImage.getProduct())
                .build();
    }

}
