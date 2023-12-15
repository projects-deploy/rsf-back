package com.aledguedes.shop.eccomerce.dtoResponse;

import java.time.LocalDateTime;
import java.util.List;

import com.aledguedes.shop.eccomerce.model.Category;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentResponse {
    
    private Long id;
    private String name;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
    @JsonIgnoreProperties({ "categories", "createdAt", "updatedAt" })
	private List<Category> categories;
}
