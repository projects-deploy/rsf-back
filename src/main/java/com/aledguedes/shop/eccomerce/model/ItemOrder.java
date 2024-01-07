package com.aledguedes.shop.eccomerce.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
@Table(name = "tbl_item_order")
@ToString(onlyExplicitlyIncluded = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)

public class ItemOrder {
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "qtde_item")
	private int qtde_item;
	
	@Column(name = "amount")
	private double amount;
	
	@ManyToOne
	@JoinColumn(name = "order_id")
	@JsonIgnoreProperties("items")
	private Order order;
	
	@ManyToOne
	@JoinColumn(name = "product_id")
    @JsonIgnoreProperties({"brand", "images"})
	private Product product;
}

