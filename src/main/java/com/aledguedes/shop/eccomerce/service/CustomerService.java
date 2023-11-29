package com.aledguedes.shop.eccomerce.service;

import java.util.List;

import com.aledguedes.shop.eccomerce.dtoRequest.CustomerRequest;
import com.aledguedes.shop.eccomerce.dtoResponse.CustomerResponse;

public interface CustomerService {

	List<CustomerResponse> listAll();
    CustomerResponse searchByCPF(String cpf);
	CustomerResponse searchByPhone(String phone);
	List<CustomerResponse> searchByChar(String charKey);
	List<CustomerResponse> searchKeyword(String keyword);
	List<CustomerResponse> searchBirthdays(int month);
	CustomerResponse createCustomer(CustomerRequest customerRequest);
	CustomerResponse updateCustomer(CustomerRequest customerRequest, Long user_id);
	// List<CompradorDTO> searchBuyers(int id_procuct);
}
