package com.aledguedes.shop.eccomerce.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import com.aledguedes.shop.eccomerce.dtoResponse.ProductResponse;
import com.aledguedes.shop.eccomerce.model.Product;
import com.aledguedes.shop.eccomerce.model.SubCategory;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Page<ProductResponse> findAllByAvailable(int i, PageRequest pageable);

    List<ProductResponse> findAllByAvailableAndSubCategory(int i, SubCategory subCategory);

    Page<ProductResponse> findAllByAvailableAndNameContainingOrAvailableAndDetailContaining(int i, String key, int j,
            String key2, PageRequest pageable);

    Page<ProductResponse> findAllByDeliveryAndAvailable(int i, int j, PageRequest pageable);
    
}
