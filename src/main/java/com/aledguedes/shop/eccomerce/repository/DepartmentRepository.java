package com.aledguedes.shop.eccomerce.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aledguedes.shop.eccomerce.dtoResponse.DepartmentResponse;
import com.aledguedes.shop.eccomerce.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    
    ArrayList<DepartmentResponse> findAllByOrderById();
    ArrayList<DepartmentResponse> findByNameContaining(String name);
    List<DepartmentResponse> findDepartmentByCategoriesId(Long categoryId);
}
