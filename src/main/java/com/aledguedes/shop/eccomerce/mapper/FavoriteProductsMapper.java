package com.aledguedes.shop.eccomerce.mapper;

import com.aledguedes.shop.eccomerce.dtoRequest.FavoriteProductsRequest;
import com.aledguedes.shop.eccomerce.dtoResponse.FavoriteProductsResponse;
import com.aledguedes.shop.eccomerce.model.FavoriteProducts;

public interface FavoriteProductsMapper {

    FavoriteProducts toFavoriteProducts(FavoriteProductsRequest favoritesRequest);
    FavoriteProductsResponse toFavoriteProductsResponse(FavoriteProducts favorites);
}