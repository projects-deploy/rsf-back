package com.aledguedes.shop.eccomerce.dtoRequest;

import java.time.LocalDateTime;
import java.util.List;

import com.aledguedes.shop.eccomerce.model.Customer;
import com.aledguedes.shop.eccomerce.model.ItemOrder;
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
public class OrderRequest {

    private LocalDateTime date_order;
    private double value_total;
    private String shipping;
    private String comments;
    private Integer status;
    private String payment;
    private Customer customer;
    private List<ItemOrder> items;
}
