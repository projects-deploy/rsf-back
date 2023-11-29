package com.aledguedes.shop.eccomerce.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.aledguedes.shop.eccomerce.dtoRequest.CustomerRequest;
import com.aledguedes.shop.eccomerce.dtoResponse.CustomerResponse;
import com.aledguedes.shop.eccomerce.service.CustomerService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/api/customer")
public class CustomerController {

	private final CustomerService customerService;

	@GetMapping
	public List<CustomerResponse> listAll() {
		return customerService.listAll();
	}

	@GetMapping(value = "/find/cpf")
	public CustomerResponse searchByCPF(@RequestParam(name = "q", required = false, defaultValue = "") String cpf) {
		return customerService.searchByCPF(cpf);
	}

	@GetMapping(value = "/find/phone")
	public CustomerResponse searchByPhone(@RequestParam(name = "q", required = false, defaultValue = "") String phone) {
		return customerService.searchByPhone(phone);
	}

	@GetMapping(value = "/find/key")
	public List<CustomerResponse> searchByChar(
			@RequestParam(name = "q", required = false, defaultValue = "") String charKey) {
		return customerService.searchByChar(charKey);
	}

	@GetMapping(value = "/find/keywod")
	public List<CustomerResponse> searchKeyword(
			@RequestParam(name = "q", required = false, defaultValue = "") String keyword) {
		return customerService.searchKeyword(keyword);
	}

	@GetMapping(value = "/find/birth-day")
	public List<CustomerResponse> searchBirthdays(
			@RequestParam(name = "q", required = false, defaultValue = "") int month) {
		return customerService.searchBirthdays(month);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public CustomerResponse createCustomer(@RequestBody @Valid CustomerRequest customerRequest) {
		return customerService.createCustomer(customerRequest);
	}

	@PutMapping(value = "/{customer_id}")
	public CustomerResponse createCustomer(
			@RequestBody @Valid CustomerRequest customerRequest,
			@PathVariable Long customer_id) {
		return customerService.updateCustomer(customerRequest, customer_id);
	}

}
