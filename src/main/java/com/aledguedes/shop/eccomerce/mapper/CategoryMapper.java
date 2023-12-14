package com.aledguedes.shop.eccomerce.mapper;

import com.aledguedes.shop.eccomerce.dtoRequest.CategoryRequest;
import com.aledguedes.shop.eccomerce.dtoResponse.CategoryResponse;
import com.aledguedes.shop.eccomerce.model.Category;

public interface CategoryMapper {

    Category toCategory(CategoryRequest departmentRequest);
    CategoryResponse toCategoryResponse(Category department);
}