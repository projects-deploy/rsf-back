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

import com.aledguedes.shop.eccomerce.dtoRequest.SubCategoryRequest;
import com.aledguedes.shop.eccomerce.dtoResponse.SubCategoryResponse;
import com.aledguedes.shop.eccomerce.service.SubCategoryService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/api/sub-subCategory")
public class SubCategoryController {

    private final SubCategoryService subCategoryService;

    @GetMapping
    public List<SubCategoryResponse> listAll() {
        return subCategoryService.listAll();
    }

    @GetMapping(value = "/{subCategory_id}")
    public SubCategoryResponse subCategoryById(@PathVariable Long subCategory_id) {
        return subCategoryService.subCategoryById(subCategory_id);
    }

    @GetMapping(value = "/search")
    public List<SubCategoryResponse> listBykey(@RequestParam(name = "q", required = false, defaultValue = "") String key) {
        return subCategoryService.listBykey(key);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SubCategoryResponse createSubCategory(@RequestBody @Valid SubCategoryRequest subCategory) {
        return subCategoryService.createSubCategory(subCategory);
    }

    @PutMapping(value = "/{subCategory_id}")
    public SubCategoryResponse updateCategory(@RequestBody @Valid SubCategoryRequest subCategory, @PathVariable Long subCategory_id) {
        return subCategoryService.updateSubCategory(subCategory, subCategory_id);
    }
    
}
