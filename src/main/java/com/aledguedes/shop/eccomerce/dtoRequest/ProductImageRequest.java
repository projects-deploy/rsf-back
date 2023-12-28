package com.aledguedes.shop.eccomerce.dtoRequest;

import java.util.List;

import com.aledguedes.shop.eccomerce.model.Product;
import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(SnakeCaseStrategy.class)
public class ProductImageRequest {

    @NotEmpty
    @Size(max = 6, message = "A lista de imagens deve ter no máximo 6 elementos.")
    private List<String> images_url;

    @NotNull
    private Product product;
}
