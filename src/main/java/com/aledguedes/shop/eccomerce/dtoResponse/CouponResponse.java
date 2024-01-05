package com.aledguedes.shop.eccomerce.dtoResponse;

import java.time.LocalDateTime;

import com.aledguedes.shop.eccomerce.model.Customer;
import com.aledguedes.shop.eccomerce.model.Product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CouponResponse {

    private Long id;
    private String code;
    private double discount;
    private boolean active;
    private LocalDateTime expiration_date;
    private Product product;
    private Customer customer;
}
