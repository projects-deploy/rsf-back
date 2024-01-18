package com.aledguedes.shop.eccomerce.dtoResponse;

import java.time.LocalDateTime;
import java.util.List;

import com.aledguedes.shop.eccomerce.model.Customer;
import com.aledguedes.shop.eccomerce.model.ItemOrder;
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
public class OrderResponse {

    private Long id;
    private LocalDateTime date_order;
    private double value_total;
    private String shipping; // retirar
    private String comments;
    private Integer status;
    private String payment;
	private String receiptNumber;
    @JsonIgnoreProperties("favorites")
    private Customer customer;
    @JsonIgnoreProperties("order")
    private List<ItemOrder> items;
}
