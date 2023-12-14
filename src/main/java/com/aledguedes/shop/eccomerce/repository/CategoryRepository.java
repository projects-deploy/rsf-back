package com.aledguedes.shop.eccomerce.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aledguedes.shop.eccomerce.dtoResponse.CategoryResponse;
import com.aledguedes.shop.eccomerce.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    
    ArrayList<CategoryResponse> findByNameContaining(String name);
    ArrayList<CategoryResponse> findAllByOrderById();
}
