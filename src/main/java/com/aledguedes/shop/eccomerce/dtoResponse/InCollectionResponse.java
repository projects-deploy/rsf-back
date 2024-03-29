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
public class InCollectionResponse {
    
    private Long id;
    private String description;
    private String link_photo;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
}