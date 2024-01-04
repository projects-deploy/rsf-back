package com.aledguedes.shop.eccomerce.dtoRequest;

import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

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
public class CustomerRequest {

    @NotNull
    @NotEmpty
    private String uf;

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 25)
    @CPF(message = "cpf inválido")
    private String cpf;

    @NotNull
    private String cep;

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 100)
    private String name;

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 100)
    private String surname;
    
    @Email
    @NotNull
    @NotEmpty
    // @UniqueEmail
    @Size(min = 3, max = 255)
    private String email;
    
    @NotEmpty
    private String link_photo;

    @NotNull
    private String phone;

    @NotNull
    private String numero;

    @NotNull
    private String bairro;

    @NotNull
    private String localidade;
    
    @NotNull
    private String logradouro;
    
    @NotNull
    private String complemento;

    @NotNull
    @DateTimeFormat(iso = ISO.DATE_TIME)
    private LocalDateTime birth_date;

}
