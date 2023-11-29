package com.aledguedes.shop.eccomerce.mapperImpl;

import com.aledguedes.shop.eccomerce.dtoRequest.FavoriteProductsRequest;
import com.aledguedes.shop.eccomerce.dtoResponse.FavoriteProductsResponse;
import com.aledguedes.shop.eccomerce.mapper.FavoriteProductsMapper;
import com.aledguedes.shop.eccomerce.model.FavoriteProducts;

public class FavoriteProductsMapperImpl implements FavoriteProductsMapper {

    @Override
    public FavoriteProducts toFavoriteProducts(FavoriteProductsRequest favoritesRequest) {
        if (favoritesRequest == null) {
            return null;
        }

        return FavoriteProducts.builder()
                .product(favoritesRequest.getProduct())
                .customer(favoritesRequest.getCustomer())
                .build();
    }

    @Override
    public FavoriteProductsResponse toFavoriteProductsResponse(FavoriteProducts favorites) {
        if (favorites == null) {
            return null;
        }

        return FavoriteProductsResponse.builder()
                .id(favorites.getId())
                .added_in(favorites.getAdded_in())
                .updated_in(favorites.getUpdated_in())
                .customer(favorites.getCustomer())
                .product(favorites.getProduct())
                .build();
    }

}
