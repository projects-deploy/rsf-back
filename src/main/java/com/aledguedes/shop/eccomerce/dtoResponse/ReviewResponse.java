package com.aledguedes.shop.eccomerce.dtoResponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import com.aledguedes.shop.eccomerce.model.Customer;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReviewResponse {

    private Long id;
    private int rating;
    private String title;
    private String comment;
    private Customer customer;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
