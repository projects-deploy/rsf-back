package com.aledguedes.shop.eccomerce.mapperImpl;

import org.springframework.stereotype.Component;

import com.aledguedes.shop.eccomerce.dtoRequest.DepartmentRequest;
import com.aledguedes.shop.eccomerce.dtoResponse.DepartmentResponse;
import com.aledguedes.shop.eccomerce.mapper.DepartmentMapper;
import com.aledguedes.shop.eccomerce.model.Department;

@Component
public class DepartmentMapperImpl implements DepartmentMapper {

    @Override
    public Department toDepartment(DepartmentRequest departmentRequest) {
        if (departmentRequest == null) {
            return null;
        }

        return Department.builder()
                .name(departmentRequest.getName())
                .build();
    }

    @Override
    public DepartmentResponse toDepartmentResponse(Department department) {
        if (department == null) {
            return null;
        }

        return DepartmentResponse.builder()
                .id(department.getId())
                .name(department.getName())
                .categories(department.getCategories())
                .createdAt(department.getCreatedAt())
                .updatedAt(department.getUpdatedAt())
                .build();
    }

}
