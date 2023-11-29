package com.aledguedes.shop.eccomerce.dtoRequest;

import jakarta.validation.constraints.Size;

import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(SnakeCaseStrategy.class)
public class UserRequest {

    @Email
    @NotNull
    @NotEmpty
    // @UniqueEmail
    @Size(min = 3, max = 255)
    private String email;

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 100)
    private String username;

    @NotNull
    @NotEmpty
    @Size(min = 6, max = 255)
    private String password;

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 100)
    private String name;

    private Integer user_active;
}
