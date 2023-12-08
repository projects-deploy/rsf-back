package com.aledguedes.shop.eccomerce.dtoResponse;

import java.time.LocalDateTime;
import java.util.List;

import com.aledguedes.shop.eccomerce.model.SubCategory;
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
    @JsonIgnoreProperties("category")
    private List<SubCategory> sub_category;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
}
