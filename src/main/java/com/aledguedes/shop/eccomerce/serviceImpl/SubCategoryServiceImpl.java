package com.aledguedes.shop.eccomerce.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.aledguedes.shop.eccomerce.dtoRequest.SubCategoryRequest;
import com.aledguedes.shop.eccomerce.dtoResponse.SubCategoryResponse;
import com.aledguedes.shop.eccomerce.exceptions.core.CategoryNotFoundException;
import com.aledguedes.shop.eccomerce.exceptions.core.SubCategoryNotFoundException;
import com.aledguedes.shop.eccomerce.mapper.SubCategoryMapper;
import com.aledguedes.shop.eccomerce.model.Category;
import com.aledguedes.shop.eccomerce.repository.CategoryRepository;
import com.aledguedes.shop.eccomerce.repository.SubCategoryRepository;
import com.aledguedes.shop.eccomerce.service.SubCategoryService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SubCategoryServiceImpl implements SubCategoryService {

    private final SubCategoryMapper subCategoryMapper;
    private final CategoryRepository categoryRepository;
    private final SubCategoryRepository subCategoryRepository;

    @Override
    public List<SubCategoryResponse> listAll() {
        return subCategoryRepository.findAll()
                .stream()
                .map(subCategoryMapper::toSubCategoryResponse)
                .toList();
    }

    @Override
    public List<SubCategoryResponse> listBykey(String key) {
        if (key != null)
            return subCategoryRepository.findByNameContaining(key);
        return null;
    }

    @Override
    public SubCategoryResponse subCategoryById(Long sub_category_id) {
        return subCategoryRepository.findById(sub_category_id)
                .map(subCategoryMapper::toSubCategoryResponse)
                .orElseThrow(CategoryNotFoundException::new);
    }

    @Override
    public SubCategoryResponse createSubCategory(SubCategoryRequest subCategoryRequest) {
        try {
            var newCategory = subCategoryMapper.toSubCategory(subCategoryRequest);
            var createdCategory = subCategoryRepository.save(newCategory);
            return subCategoryMapper.toSubCategoryResponse(createdCategory);
        } catch (Exception e) {
            System.out.println("DEBUG = " + e.getMessage());
            return null;
        }
    }

    @Override
    public SubCategoryResponse createSubCategoryWithCategories(SubCategoryRequest subCategoryRequest) {
        var newCategory = subCategoryMapper.toSubCategory(subCategoryRequest);

        List<Category> categories = new ArrayList<>();
        for (Long category_id : subCategoryRequest.getCategory_ids()) {
            Category category = categoryRepository.findById(category_id)
                    .orElseThrow(CategoryNotFoundException::new);
            categories.add(category);
        }

        newCategory.setCategories(categories);
        var createdCategory = subCategoryRepository.save(newCategory);
        return subCategoryMapper.toSubCategoryResponse(createdCategory);
    }

    @Override
    public SubCategoryResponse updateSubCategory(SubCategoryRequest subCategoryRequest, Long sub_category_id) {
        try {
            var subCategory = subCategoryRepository.findById(sub_category_id)
                    .orElseThrow(SubCategoryNotFoundException::new);
            BeanUtils.copyProperties(subCategoryRequest, subCategory, "id", "createdAt", "updatedAt");
            var categoryAtualizado = subCategoryRepository.save(subCategory);
            return subCategoryMapper.toSubCategoryResponse(categoryAtualizado);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

}
