package com.aledguedes.shop.eccomerce.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.aledguedes.shop.eccomerce.dtoResponse.ProductResponse;
import com.aledguedes.shop.eccomerce.model.Product;
import com.aledguedes.shop.eccomerce.model.Category;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Page<ProductResponse> findAllByAvailable(int i, PageRequest pageable);

    List<ProductResponse> findAllByAvailableAndCategory(int i, Category category);

    Page<ProductResponse> findAllByAvailableAndNameContainingOrAvailableAndDetailContaining(int i, String key, int j,
            String key2, PageRequest pageable);

    Page<ProductResponse> findAllByDeliveryAndAvailable(int i, int j, PageRequest pageable);

	List<Product> findByBrandId(Long brandId);
    
    Page<Product> findByIsNewTrue(Pageable pageable);
    
    List<Product> findAllByBrandId(Long brand_id);
    List<Product> findAllByCategoryId(Long category_id);

    @Query(value = "SELECT * FROM tbl_product p WHERE p.tags LIKE %:tag% ORDER BY RAND() LIMIT 8", nativeQuery = true)
    List<Product> findByTagsContaining(String tag);
    
}
