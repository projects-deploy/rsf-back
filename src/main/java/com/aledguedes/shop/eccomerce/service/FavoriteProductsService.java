package com.aledguedes.shop.eccomerce.service;

import java.util.List;

import com.aledguedes.shop.eccomerce.dtoResponse.FavoriteProductsResponse;

public interface FavoriteProductsService {

    List<FavoriteProductsResponse> listAll();
    FavoriteProductsResponse createBrand(Long customer_id, Long product_id);
    void deleteFavorite(Long favorite_id);
}
