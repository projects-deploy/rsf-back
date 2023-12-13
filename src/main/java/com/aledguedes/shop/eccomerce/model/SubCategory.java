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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
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
@Table(name = "tbl_subcategory")
@ToString(onlyExplicitlyIncluded = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class SubCategory extends Auditable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "name")
	private String name;

	// @ManyToMany(mappedBy = "subCategories")
	// @Builder.Default
	@ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "category_subcategory", joinColumns = @JoinColumn(name = "subcategory_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
	@Builder.Default
	private List<Category> categories = new ArrayList<>();

	public void addCategory(Category category) {
		this.categories.add(category);
		category.getSubCategories().add(this);
	}

	public void removeCategory(long category_id) {
		var category = this.categories.stream().filter(t -> t.getId() == category_id).findFirst().orElse(null);
		if (category != null) {
			this.categories.remove(category);
			category.getSubCategories().remove(this);
		}
	}
}
