package com.aledguedes.shop.eccomerce.dtoRequest;

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
public class ProductRequest {

	@NotNull
	@NotEmpty
	@Size(min = 3, max = 100)
	private String name;

	@NotNull
	@NotEmpty
	@Size(min = 3, max = 100)
	private String detail;

	@NotNull
	@NotEmpty
	@Size(min = 3, max = 300)
	private String link_photo;

	@NotNull
	private double price_product;

	@NotNull
	private String product_size;

	@NotNull
	private String product_colors;

	@NotNull
	private Boolean isNew; 

	private String multipleImages;

	private Long brand_idd;
	private Long category_idd;
	private Long department_idd;

	@NotNull
	private int in_stok;
	private int discount;
	private int delivery;
}
