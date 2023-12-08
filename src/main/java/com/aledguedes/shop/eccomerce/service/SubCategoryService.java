package com.aledguedes.shop.eccomerce.service;

import java.util.List;

import com.aledguedes.shop.eccomerce.dtoRequest.SubCategoryRequest;
import com.aledguedes.shop.eccomerce.dtoResponse.SubCategoryResponse;

public interface SubCategoryService {
    List<SubCategoryResponse> listAll();
    // List<SubCategoryResponse> listAllOrderById();
    List<SubCategoryResponse> listBykey(String key);
    SubCategoryResponse subCategoryById(Long sub_category_id);
    SubCategoryResponse createSubCategory(SubCategoryRequest sub_category);
    SubCategoryResponse updateSubCategory(SubCategoryRequest sub_category, Long sub_category_id);
}
