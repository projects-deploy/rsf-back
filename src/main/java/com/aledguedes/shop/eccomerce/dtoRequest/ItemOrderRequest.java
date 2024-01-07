package com.aledguedes.shop.eccomerce.dtoRequest;

import com.aledguedes.shop.eccomerce.model.Order;
import com.aledguedes.shop.eccomerce.model.Product;
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
public class ItemOrderRequest {

    private Integer qtde_item;
    private double unit_price;
    private double amount;
    private Order order;
    private Product product;
}
