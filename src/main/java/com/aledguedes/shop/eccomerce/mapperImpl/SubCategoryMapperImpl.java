package com.aledguedes.shop.eccomerce.mapperImpl;

import org.springframework.stereotype.Component;

import com.aledguedes.shop.eccomerce.dtoRequest.SubCategoryRequest;
import com.aledguedes.shop.eccomerce.dtoResponse.SubCategoryResponse;
import com.aledguedes.shop.eccomerce.mapper.SubCategoryMapper;
import com.aledguedes.shop.eccomerce.model.SubCategory;

@Component
public class SubCategoryMapperImpl implements SubCategoryMapper {

    @Override
    public SubCategory toSubCategory(SubCategoryRequest subCategoryRequest) {
        if (subCategoryRequest == null) {
            return null;
        }

        return SubCategory.builder()
                .name(subCategoryRequest.getName())
                .category(subCategoryRequest.getCategory())
                .build();
    }

    @Override
    public SubCategoryResponse toSubCategoryResponse(SubCategory subCategory) {
        if (subCategory == null) {
            return null;
        }

        return SubCategoryResponse.builder()
                .id(subCategory.getId())
                .name(subCategory.getName())
                .category(subCategory.getCategory())
                .createdAt(subCategory.getCreatedAt())
                .updatedAt(subCategory.getUpdatedAt())
                .build();
    }

}
