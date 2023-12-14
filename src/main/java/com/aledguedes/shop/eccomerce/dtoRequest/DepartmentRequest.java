package com.aledguedes.shop.eccomerce.dtoRequest;

import jakarta.validation.constraints.Size;

import java.util.List;

import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(SnakeCaseStrategy.class)
public class DepartmentRequest {

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 100)
    private String name;

    private List<CategoryRequest> sub_categories;
}
