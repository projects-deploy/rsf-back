package com.aledguedes.shop.eccomerce.dtoResponse;

import com.aledguedes.shop.eccomerce.model.Order;
import com.aledguedes.shop.eccomerce.model.Product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemOrderResponse {

	private Long id;
    private Integer qtde_item;
    private double unit_price;
    private double total_price;
    private Order order;
    private Product product;
}
