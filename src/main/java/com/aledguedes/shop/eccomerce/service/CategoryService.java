package com.aledguedes.shop.eccomerce.service;

import java.util.List;

import com.aledguedes.shop.eccomerce.dtoRequest.CategoryRequest;
import com.aledguedes.shop.eccomerce.dtoResponse.CategoryResponse;

public interface CategoryService {
    List<CategoryResponse> listAll();
    // List<CategoryResponse> listAllOrderById();
    List<CategoryResponse> listBykey(String key);
    CategoryResponse categoryById(Long category_id);
    CategoryResponse createCategory(CategoryRequest category);
    CategoryResponse updateCategory(CategoryRequest category, Long category_id);
}
