package com.aledguedes.shop.eccomerce.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.aledguedes.shop.eccomerce.dtoRequest.CategoryRequest;
import com.aledguedes.shop.eccomerce.dtoResponse.CategoryResponse;
import com.aledguedes.shop.eccomerce.exceptions.core.CategoryNotFoundException;
import com.aledguedes.shop.eccomerce.mapper.CategoryMapper;
import com.aledguedes.shop.eccomerce.model.SubCategory;
import com.aledguedes.shop.eccomerce.repository.CategoryRepository;
import com.aledguedes.shop.eccomerce.repository.SubCategoryRepository;
import com.aledguedes.shop.eccomerce.service.CategoryService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

	private final CategoryMapper categoryMapper;
	private final CategoryRepository categoryRepository;
	private final SubCategoryRepository subCategoryRepository;

	@Override
	public List<CategoryResponse> listAll() {
		return categoryRepository.findAll().stream().map(categoryMapper::toCategoryResponse).toList();
	}

	@Override
	public CategoryResponse categoryById(Long category_id) {
		return categoryRepository.findById(category_id).map(categoryMapper::toCategoryResponse)
				.orElseThrow(CategoryNotFoundException::new);
	}

	@Override
	public List<CategoryResponse> listAllOrderById() {
		return categoryRepository.findAllByOrderById();
	}

	@Override
	public CategoryResponse createCategory(CategoryRequest categoryRequest) {
		try {
			var newCategory = categoryMapper.toCategory(categoryRequest);
			var createdCategory = categoryRepository.save(newCategory);
			return categoryMapper.toCategoryResponse(createdCategory);
		} catch (Exception e) {
			System.out.println("DEBUG = " + e.getMessage());
			return null;
		}
	}

	@Override
	public CategoryResponse createCategoryWithSubCategories(CategoryRequest categoryRequest) {
		try {
			var newCategory = categoryMapper.toCategory(categoryRequest);

			List<SubCategory> subCategories = new ArrayList<>();
			for (var subCategoryRequest : categoryRequest.getSub_categories()) {
				var subCategory = new SubCategory();
				subCategory.setName(subCategoryRequest.getName());
				subCategory.addCategory(newCategory);
				subCategoryRepository.save(subCategory);
				subCategories.add(subCategory);
				System.out.println("DEBUG SUB-CATEGORY NAMES: " + subCategory.getName());
			}

			newCategory.setSubCategories(subCategories);

			var savedCategory = categoryRepository.save(newCategory);

			return categoryMapper.toCategoryResponse(savedCategory);
		} catch (Exception e) {
			System.out.println("DEBUG = " + e.getMessage());
			return null;
		}
	}

	@Override
	public CategoryResponse updateCategory(CategoryRequest categoryRequest, Long category_id) {
		try {
			var category = categoryRepository.findById(category_id).orElseThrow(CategoryNotFoundException::new);
			BeanUtils.copyProperties(categoryRequest, category, "id", "createdAt", "updatedAt");
			var categoryAtualizado = categoryRepository.save(category);
			return categoryMapper.toCategoryResponse(categoryAtualizado);
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public List<CategoryResponse> listBykey(String key) {
		if (key != null)
			return categoryRepository.findByNameContaining(key);
		return null;
	}

}
