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
public class UserResponse {
    
    private Long id;
    private String email;
    private String username;
    private String name;
    private Integer user_active;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
}
