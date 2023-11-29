package com.aledguedes.shop.eccomerce.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.aledguedes.shop.eccomerce.dtoResponse.CustomerResponse;
import com.aledguedes.shop.eccomerce.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    CustomerResponse findByCpf(String cpf);

    boolean existsByEmail(String email);

    Optional<Customer> findByEmail(String email);

    List<Customer> findAllByOrderByNameAsc();

    @Query("SELECT com.aledguedes.shop.eccomerce.model.Customer(cli.name, cli.birth_date, cli.phone)"
            + " from Customer cli WHERE month(cli.birth_date) = :month ORDER BY day(cli.birth_date)")
    public List<CustomerResponse> recoverBirthdays(@Param("month") int month);

    CustomerResponse findByPhone(String strPhone);

    List<CustomerResponse> findByNameStartsWith(String charKey);

    List<Customer> findByNameContaining(String keyword);
}
