package com.aledguedes.shop.eccomerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aledguedes.shop.eccomerce.model.FavoriteProducts;

public interface FavoriteProductsRepository extends JpaRepository<FavoriteProducts, Long> {

	List<FavoriteProducts> findByCustomerId(Long customerId);

}
