package com.aledguedes.shop.eccomerce.dtoResponse;

import java.time.LocalDateTime;
import java.util.List;

import com.aledguedes.shop.eccomerce.model.Department;
import com.aledguedes.shop.eccomerce.model.Product;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryResponse {
    
    private Long id;
    private String name;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
    @JsonIgnoreProperties({ "categories", "products", "createdAt", "updatedAt" })
	private List<Department> department;
    @JsonIgnoreProperties({ "department", "createdAt", "updatedAt" })
    private List<Product> products;
}
