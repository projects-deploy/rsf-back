package com.aledguedes.shop.eccomerce.serviceImpl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.aledguedes.shop.eccomerce.dtoRequest.CustomerRequest;
import com.aledguedes.shop.eccomerce.dtoResponse.CustomerResponse;
import com.aledguedes.shop.eccomerce.exceptions.core.CustomerNotFoundException;
import com.aledguedes.shop.eccomerce.exceptions.core.UserNotFoundException;
import com.aledguedes.shop.eccomerce.mapper.CustomerMapper;
import com.aledguedes.shop.eccomerce.repository.CustomerRepository;
import com.aledguedes.shop.eccomerce.service.CustomerService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerMapper customerMapper;
    private final CustomerRepository customerRepository;

    @Override
    public List<CustomerResponse> listAll() {
        return customerRepository.findAll()
                .stream()
                .map(customerMapper::toCustomerResponse)
                .toList();
    }

	@Override
	public CustomerResponse listById(Long customer_id) {
		return customerRepository.findById(customer_id)
                .map(customerMapper::toCustomerResponse)
                .orElseThrow(CustomerNotFoundException::new);
	}

    @Override
    public CustomerResponse searchByCPF(String cpf) {
        return customerRepository.findByCpf(cpf);
    }

    @Override
    public CustomerResponse searchByPhone(String phone) {
        String strPhone = phone.replace("(", "").replace(")", "").replace(" ", "").replace("-", "");
        System.out.println(strPhone);
        return customerRepository.findByPhone(strPhone);
    }

    @Override
    public List<CustomerResponse> searchByChar(String charKey) {
        return customerRepository.findByNameStartsWith(charKey);
    }

    @Override
    public List<CustomerResponse> searchKeyword(String keyword) {
        var customers = customerRepository.findByNameContaining(keyword);
        return customers.stream()
                .map(customerMapper::toCustomerResponse)
                .toList();
    }

    @Override
    public List<CustomerResponse> searchBirthdays(int month) {
        return customerRepository.recoverBirthdays(month);
    }

	@Override
	public CustomerResponse createCustomer(CustomerRequest customerRequest) {
		var newCustomer = customerMapper.toCustomer(customerRequest);
        var createdCustomer = customerRepository.save(newCustomer);
        return customerMapper.toCustomerResponse(createdCustomer);
	}

    @Override
    public CustomerResponse updateCustomer(CustomerRequest customerRequest , Long customer_id) {
    	var user = customerRepository.findById(customer_id)
				.orElseThrow(UserNotFoundException::new);
    	BeanUtils.copyProperties(customerRequest, user, "id", "cpf", "createdAt", "updatedAt");
        var clienteAtualizado = customerRepository.save(user);
        return customerMapper.toCustomerResponse(clienteAtualizado);
    }

}
