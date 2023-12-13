package com.aledguedes.shop.eccomerce.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
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
@Table(name = "tbl_category")
@ToString(onlyExplicitlyIncluded = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class Category extends Auditable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "name")
	private String name;

	// @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	// @JoinTable(
	// name = "category_subcategory",
	// joinColumns = @JoinColumn(name = "category_id"),
	// inverseJoinColumns = @JoinColumn(name = "subcategory_id")
	// )
	// @Builder.Default
	@ManyToMany(fetch = FetchType.EAGER, cascade = {
			CascadeType.PERSIST,
			CascadeType.MERGE
	}, mappedBy = "categories")
	@Builder.Default
	private List<SubCategory> subCategories = new ArrayList<>();
}