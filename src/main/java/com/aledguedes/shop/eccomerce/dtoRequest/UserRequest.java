package com.aledguedes.shop.eccomerce.dtoRequest;

import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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

    @NotNull(message = "O campo NAME não pode ser nulo")
    @NotBlank(message = "O NAME não pode ser vazio")
    @Size(min = 3, max = 100)
    private String name;

    @Email(message = "O campo EMAIL não pode ser nulo")
    @NotNull(message = "O campo EMAIL não pode ser nulo")
    @NotBlank(message = "O campo EMAIL não pode ser vazio")
    // @UniqueEmail
    @Size(min = 3, max = 255)
    private String email;


    @NotNull(message = "O campo PASSWORD não pode ser nulo")
    @NotBlank(message = "O campo PASSWORD não pode ser vazio")
    @Size(min = 6, max = 255)
    private String password;

    private String linkPhoto;

    @Size(min = 3, max = 100)
    private String verificationCode;

	private Boolean enabled;
}
