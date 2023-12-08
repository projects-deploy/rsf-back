package com.aledguedes.shop.eccomerce.mapper;

import com.aledguedes.shop.eccomerce.dtoRequest.SubCategoryRequest;
import com.aledguedes.shop.eccomerce.dtoResponse.SubCategoryResponse;
import com.aledguedes.shop.eccomerce.model.SubCategory;

public interface SubCategoryMapper {

    SubCategory toSubCategory(SubCategoryRequest categoryRequest);
    SubCategoryResponse toSubCategoryResponse(SubCategory category);
}