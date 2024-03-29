package com.aledguedes.shop.eccomerce.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.aledguedes.shop.eccomerce.dtoRequest.CategoryRequest;
import com.aledguedes.shop.eccomerce.dtoResponse.CategoryResponse;
import com.aledguedes.shop.eccomerce.exceptions.core.DepartmentNotFoundException;
import com.aledguedes.shop.eccomerce.exceptions.core.CategoryNotFoundException;
import com.aledguedes.shop.eccomerce.mapper.CategoryMapper;
import com.aledguedes.shop.eccomerce.model.Department;
import com.aledguedes.shop.eccomerce.repository.DepartmentRepository;
import com.aledguedes.shop.eccomerce.repository.CategoryRepository;
import com.aledguedes.shop.eccomerce.service.CategoryService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@SuppressWarnings("null")
public class CategoryServiceImpl implements CategoryService {

    private final CategoryMapper categoryMapper;
    private final CategoryRepository categoryRepository;
    private final DepartmentRepository departmentRepository;

    @Override
    public List<CategoryResponse> listAll() {
        return categoryRepository.findAll()
                .stream()
                .map(categoryMapper::toCategoryResponse)
                .toList();
    }

    @Override
    public List<CategoryResponse> listBykey(String key) {
        if (key != null)
            return categoryRepository.findByNameContaining(key);
        return null;
    }

    @Override
    public CategoryResponse categoryById(Long category_id) {
        return categoryRepository.findById(category_id)
                .map(categoryMapper::toCategoryResponse)
                .orElseThrow(DepartmentNotFoundException::new);
    }

    @Override
    public CategoryResponse createCategory(CategoryRequest categoryRequest) {
        var newCategory = categoryMapper.toCategory(categoryRequest);

        List<Department> departments = new ArrayList<>();
        for (Long department_id : categoryRequest.getDepartment_ids()) {
            Department department = departmentRepository.findById(department_id)
                    .orElseThrow(DepartmentNotFoundException::new);
            departments.add(department);
        }

        newCategory.setDepartment(departments);
        var createdCategory = categoryRepository.save(newCategory);

        return categoryMapper.toCategoryResponse(createdCategory);
    }

    @Override
    public CategoryResponse updateCategory(CategoryRequest categoryRequest, Long category_id) {
        try {
            var category = categoryRepository.findById(category_id)
                    .orElseThrow(CategoryNotFoundException::new);
            BeanUtils.copyProperties(categoryRequest, category, "id", "createdAt", "updatedAt");
            var departmentAtualizado = categoryRepository.save(category);
            return categoryMapper.toCategoryResponse(departmentAtualizado);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

}
