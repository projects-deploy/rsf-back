package com.aledguedes.shop.eccomerce.service;

import java.util.List;

import com.aledguedes.shop.eccomerce.dtoRequest.ProductImageRequest;
import com.aledguedes.shop.eccomerce.dtoResponse.ProductImageResponse;

public interface ProductImageService {

    List<ProductImageResponse> listAll();

    ProductImageResponse productImageById(Long product_image_id);

    ProductImageResponse createroductImage(ProductImageRequest product_image);

    ProductImageResponse updateroductImage(ProductImageRequest product_image, Long product_image_id);

    void deleteProductImage(Long productImageId);

}
