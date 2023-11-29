package com.aledguedes.shop.eccomerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aledguedes.shop.eccomerce.model.FavoriteProducts;

public interface FavoriteProductsRepository extends JpaRepository<FavoriteProducts, Long> {

}
