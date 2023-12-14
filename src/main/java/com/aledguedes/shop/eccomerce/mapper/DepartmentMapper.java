package com.aledguedes.shop.eccomerce.mapper;

import com.aledguedes.shop.eccomerce.dtoRequest.DepartmentRequest;
import com.aledguedes.shop.eccomerce.dtoResponse.DepartmentResponse;
import com.aledguedes.shop.eccomerce.model.Department;

public interface DepartmentMapper {

    Department toDepartment(DepartmentRequest departmentRequest);
    DepartmentResponse toDepartmentResponse(Department department);
}