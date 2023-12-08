package com.aledguedes.shop.eccomerce.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aledguedes.shop.eccomerce.dtoResponse.SubCategoryResponse;
import com.aledguedes.shop.eccomerce.model.SubCategory;

public interface SubCategoryRepository extends JpaRepository<SubCategory, Long> {
    
    ArrayList<SubCategoryResponse> findByNameContaining(String name);
    ArrayList<SubCategoryResponse> findAllByOrderById();
}
