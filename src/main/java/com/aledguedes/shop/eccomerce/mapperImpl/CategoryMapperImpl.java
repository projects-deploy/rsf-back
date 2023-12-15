package com.aledguedes.shop.eccomerce.mapperImpl;

import org.springframework.stereotype.Component;

import com.aledguedes.shop.eccomerce.dtoRequest.CategoryRequest;
import com.aledguedes.shop.eccomerce.dtoResponse.CategoryResponse;
import com.aledguedes.shop.eccomerce.mapper.CategoryMapper;
import com.aledguedes.shop.eccomerce.model.Category;

@Component
public class CategoryMapperImpl implements CategoryMapper {

    @Override
    public Category toCategory(CategoryRequest categoryRequest) {
        if (categoryRequest == null) {
            return null;
        }

        return Category.builder()
                .name(categoryRequest.getName())
                .build();
    }

    @Override
    public CategoryResponse toCategoryResponse(Category category) {
        if (category == null) {
            return null;
        }

        return CategoryResponse.builder()
                .id(category.getId())
                .name(category.getName())
                .department(category.getCategories())
                .createdAt(category.getCreatedAt())
                .updatedAt(category.getUpdatedAt())
                .build();
    }

}
