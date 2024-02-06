package com.aledguedes.shop.eccomerce.dtoResponse;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InCarouselResponse {
    
    private Long id;
    private String links;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
