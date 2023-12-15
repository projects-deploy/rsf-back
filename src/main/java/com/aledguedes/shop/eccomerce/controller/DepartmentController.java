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

import com.aledguedes.shop.eccomerce.dtoRequest.DepartmentRequest;
import com.aledguedes.shop.eccomerce.dtoResponse.DepartmentResponse;
import com.aledguedes.shop.eccomerce.service.DepartmentService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/api/department")
public class DepartmentController {

    private final DepartmentService departmentService;

    @GetMapping
    public List<DepartmentResponse> listAll() {
        return departmentService.listAll();
    }

    @GetMapping(value = "/order-by-id")
    public List<DepartmentResponse> listAllOrderById() {
        return departmentService.listAllOrderById();
    }

    @GetMapping(value = "/{department_id}")
    public DepartmentResponse departmentById(@PathVariable Long department_id) {
        return departmentService.departmentById(department_id);
    }

    @GetMapping(value = "/search")
    public List<DepartmentResponse> listBykey(@RequestParam(name = "q", required = false, defaultValue = "") String key) {
        return departmentService.listBykey(key);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DepartmentResponse createDepartment(@RequestBody @Valid DepartmentRequest department) {
        return departmentService.createDepartment(department);
    }

    @PutMapping(value = "/{department_id}")
    public DepartmentResponse updateDepartment(@RequestBody @Valid DepartmentRequest department, @PathVariable Long department_id) {
        return departmentService.updateDepartment(department, department_id);
    }
}
