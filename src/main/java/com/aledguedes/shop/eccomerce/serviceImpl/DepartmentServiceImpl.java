package com.aledguedes.shop.eccomerce.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.aledguedes.shop.eccomerce.dtoRequest.DepartmentRequest;
import com.aledguedes.shop.eccomerce.dtoResponse.DepartmentResponse;
import com.aledguedes.shop.eccomerce.exceptions.core.DepartmentNotFoundException;
import com.aledguedes.shop.eccomerce.mapper.DepartmentMapper;
import com.aledguedes.shop.eccomerce.model.Category;
import com.aledguedes.shop.eccomerce.repository.DepartmentRepository;
import com.aledguedes.shop.eccomerce.repository.CategoryRepository;
import com.aledguedes.shop.eccomerce.service.DepartmentService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

	private final DepartmentMapper departmentMapper;
	private final DepartmentRepository departmentRepository;
	private final CategoryRepository categoryRepository;

	@Override
	public List<DepartmentResponse> listAll() {
		return departmentRepository.findAll().stream().map(departmentMapper::toDepartmentResponse).toList();
	}

	@Override
	public DepartmentResponse departmentById(Long department_id) {
		return departmentRepository.findById(department_id).map(departmentMapper::toDepartmentResponse)
				.orElseThrow(DepartmentNotFoundException::new);
	}

	@Override
	public List<DepartmentResponse> listAllOrderById() {
		return departmentRepository.findAllByOrderById();
	}

	@Override
	public DepartmentResponse createDepartment(DepartmentRequest departmentRequest) {
		try {
			var newDepartment = departmentMapper.toDepartment(departmentRequest);
			var createdDepartment = departmentRepository.save(newDepartment);
			return departmentMapper.toDepartmentResponse(createdDepartment);
		} catch (Exception e) {
			System.out.println("DEBUG = " + e.getMessage());
			return null;
		}
	}

	@Override
	public DepartmentResponse createDepartmentWithSubCategories(DepartmentRequest departmentRequest) {
		try {
			var newDepartment = departmentMapper.toDepartment(departmentRequest);

			List<Category> subCategories = new ArrayList<>();
			for (var categoryRequest : departmentRequest.getSub_categories()) {
				var category = new Category();
				category.setName(categoryRequest.getName());
				category.addDepartment(newDepartment);
				categoryRepository.save(category);
				subCategories.add(category);
				System.out.println("DEBUG SUB-CATEGORY NAMES: " + category.getName());
			}

			newDepartment.setSubCategories(subCategories);

			var savedDepartment = departmentRepository.save(newDepartment);

			return departmentMapper.toDepartmentResponse(savedDepartment);
		} catch (Exception e) {
			System.out.println("DEBUG = " + e.getMessage());
			return null;
		}
	}

	@Override
	public DepartmentResponse updateDepartment(DepartmentRequest departmentRequest, Long department_id) {
		try {
			var department = departmentRepository.findById(department_id).orElseThrow(DepartmentNotFoundException::new);
			BeanUtils.copyProperties(departmentRequest, department, "id", "createdAt", "updatedAt");
			var departmentAtualizado = departmentRepository.save(department);
			return departmentMapper.toDepartmentResponse(departmentAtualizado);
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public List<DepartmentResponse> listBykey(String key) {
		if (key != null)
			return departmentRepository.findByNameContaining(key);
		return null;
	}

}
