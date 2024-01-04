package com.aledguedes.shop.eccomerce.dtoResponse;

import java.time.LocalDateTime;
import java.util.List;

import com.aledguedes.shop.eccomerce.model.Brand;
import com.aledguedes.shop.eccomerce.model.Category;
import com.aledguedes.shop.eccomerce.model.Department;
import com.aledguedes.shop.eccomerce.model.Review;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(SnakeCaseStrategy.class)
public class ProductResponse {

	private Long id;
	private String name;
	private String detail;
	private String link_photo;
	private double price_product;
	private double price_promo;
	private int in_stok;
	private int available;
	private int delivery;
	private double discount;
	private Double average_rating;
	private Integer review_count;
	private String product_size;
	private String product_colors;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;

	@JsonIgnoreProperties({ "brand", "createdAt", "updatedAt" })
	private Brand brand;

	@JsonIgnoreProperties({ "department", "products", "createdAt", "updatedAt" })
	private Category category;

	@JsonIgnoreProperties({ "categories", "products", "createdAt", "updatedAt" })
	private Department department;

//    private List<ProductImage> images;

	@JsonIgnoreProperties({ "customer", "product" })
	private List<Review> reviews;
}
