package com.aledguedes.shop.eccomerce.service;

import java.util.List;

import com.aledguedes.shop.eccomerce.dtoRequest.DepartmentRequest;
import com.aledguedes.shop.eccomerce.dtoResponse.DepartmentResponse;

public interface DepartmentService {
    DepartmentResponse departmentById(Long department_id);
    List<DepartmentResponse> listAll();
    List<DepartmentResponse> listAllOrderById();
    DepartmentResponse createDepartment(DepartmentRequest department);
    DepartmentResponse updateDepartment(DepartmentRequest department, Long department_id);
    List<DepartmentResponse> listBykey(String key);
}
