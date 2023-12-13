package com.aledguedes.shop.eccomerce.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aledguedes.shop.eccomerce.dtoResponse.CategoryResponse;
import com.aledguedes.shop.eccomerce.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    
    ArrayList<CategoryResponse> findAllByOrderById();
    ArrayList<CategoryResponse> findByNameContaining(String name);
    List<CategoryResponse> findCategoryBySubCategoriesId(Long subCategoryId);
}
