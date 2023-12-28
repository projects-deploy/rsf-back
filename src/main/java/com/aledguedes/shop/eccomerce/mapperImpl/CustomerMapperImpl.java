package com.aledguedes.shop.eccomerce.mapperImpl;

import org.springframework.stereotype.Component;

import com.aledguedes.shop.eccomerce.dtoRequest.CustomerRequest;
import com.aledguedes.shop.eccomerce.dtoResponse.CustomerResponse;
import com.aledguedes.shop.eccomerce.mapper.CustomerMapper;
import com.aledguedes.shop.eccomerce.model.Customer;

@Component
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public Customer toCustomer(CustomerRequest customerRequest) {
        if (customerRequest == null) {
            return null;
        }

        return Customer.builder()
                .email(customerRequest.getEmail())
                .name(customerRequest.getName())
                .uf(customerRequest.getUf())
                .cpf(customerRequest.getCpf())
                .cep(customerRequest.getCep())
                .surname(customerRequest.getSurname())
                .email(customerRequest.getEmail())
                .phone(customerRequest.getPhone())
                .numero(customerRequest.getNumero())
                .bairro(customerRequest.getBairro())
                .localidade(customerRequest.getLocalidade())
                .logradouro(customerRequest.getLogradouro())
                .complemento(customerRequest.getComplemento())
                .birth_date(customerRequest.getBirth_date())
                .build();
    }

    @Override
    public CustomerResponse toCustomerResponse(Customer customer) {
        if (customer == null) {
            return null;
        }

        return CustomerResponse.builder()
                .id(customer.getId())
                .email(customer.getEmail())
                .name(customer.getName())
                .uf(customer.getUf())
                .cpf(customer.getCpf())
                .cep(customer.getCep())
                .surname(customer.getSurname())
                .email(customer.getEmail())
                .phone(customer.getPhone())
                .numero(customer.getNumero())
                .bairro(customer.getBairro())
                .localidade(customer.getLocalidade())
                .logradouro(customer.getLogradouro())
                .complemento(customer.getComplemento())
                .birth_date(customer.getBirth_date())
	            .createdAt(customer.getCreatedAt())
	            .updatedAt(customer.getUpdatedAt())
	            .favorites(customer.getFavorites())
                .build();
    }
    
}
