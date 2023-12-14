package com.aledguedes.shop.eccomerce.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.aledguedes.shop.eccomerce.dtoRequest.CategoryRequest;
import com.aledguedes.shop.eccomerce.dtoResponse.CategoryResponse;
import com.aledguedes.shop.eccomerce.service.CategoryService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/api/category")
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public List<CategoryResponse> listAll() {
        return categoryService.listAll();
    }

    @GetMapping(value = "/{category_id}")
    public CategoryResponse categoryById(@PathVariable Long category_id) {
        return categoryService.categoryById(category_id);
    }

    @GetMapping(value = "/search")
    public List<CategoryResponse> listBykey(@RequestParam(name = "q", required = false, defaultValue = "") String key) {
        return categoryService.listBykey(key);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CategoryResponse createCategory(@RequestBody @Valid CategoryRequest category) {
        return categoryService.createCategory(category);
    }

    @PutMapping(value = "/{category_id}")
    public CategoryResponse updateDepartment(@RequestBody @Valid CategoryRequest category, @PathVariable Long category_id) {
        return categoryService.updateCategory(category, category_id);
    }
    
}
