package com.aledguedes.shop.eccomerce.dtoResponse;

import java.time.LocalDateTime;
import java.util.List;

import com.aledguedes.shop.eccomerce.model.FavoriteProducts;
import com.aledguedes.shop.eccomerce.model.Review;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerResponse {

    private Long id;
    private String uf;
    private String cpf;
    private String cep;
    private String name;
    private String surname;
    private String email;
    private String phone;
    private String numero;
    private String bairro;
    private String localidade;
    private String logradouro;
    private String complemento;
    private LocalDateTime birth_date;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    @JsonIgnoreProperties("customer")
    private List<FavoriteProducts> favorites;
    @JsonIgnoreProperties({"customer"})
    private List<Review> reviews;
}
