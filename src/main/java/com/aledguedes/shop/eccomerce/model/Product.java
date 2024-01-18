package com.aledguedes.shop.eccomerce.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_product")
@ToString(onlyExplicitlyIncluded = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class Product extends Auditable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "detail")
	private String detail;

	@Column(name = "link_photo")
	private String link_photo;

	@Column(name = "price_product")
	private double price_product;

	@Column(name = "price_promo")
	private double price_promo;

	@Column(name = "available")
	private int available;

	@Column(name = "discount")
	private int discount;

	@Column(name = "delivery")
	private int delivery;

	@Column(name = "in_stok")
	private int in_stok;

	@Column(name = "average_rating")
	private Double average_rating;

	@Column(name = "review_count")
	private Integer review_count;

	@Column(name = "product_size")
	private String product_size;

	@Column(name = "product_colors")
	private String product_colors;

	@Column(name = "multiple_images")
	private String multipleImages;

	@Column(name = "is_new")
	private Boolean isNew;

	@ManyToOne
	@JoinColumn(name = "category_id")
	@JsonIgnore
	private Category category;

	@ManyToOne
	@JoinColumn(name = "department_id")
	@JsonIgnore
	private Department department;

	@ManyToOne
	@JoinColumn(name = "brand_id")
	@JsonIgnore
	private Brand brand;

	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Review> reviews;

	@Transient
	public double getAverageRating() {
		if (reviews == null || reviews.isEmpty()) {
			return 0.0;
		}

		double sum = 0.0;
		for (Review review : reviews) {
			sum += review.getRating();
		}

		double average = sum / reviews.size();
		BigDecimal roundedAverage = BigDecimal.valueOf(average).setScale(1, RoundingMode.HALF_UP);

		return roundedAverage.doubleValue();
	}

	public void updateRatingAndReviewCount() {
		this.average_rating = getAverageRating();
		this.review_count = reviews.size();
	}
}
