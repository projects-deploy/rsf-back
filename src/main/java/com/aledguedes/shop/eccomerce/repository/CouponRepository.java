package com.aledguedes.shop.eccomerce.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aledguedes.shop.eccomerce.model.Coupon;

public interface CouponRepository extends JpaRepository<Coupon, Long> {

    Optional<Coupon> findByCode(String code);

    // CouponResponse findByCode(String code);

    // Busca cupons por código e data de expiração
    // List<CouponResponse> findByCodeAndExpirationDateGreaterThanEqual(String code, LocalDateTime expirationDate);

    // Busca cupons por cliente
    // List<CouponResponse> findByCustomer(Customer customer);

    // Busca cupons por produto
    // List<CouponResponse> findByProduct(Product product);

    // Busca cupons por cliente e produto
    // List<CouponResponse> findByCustomerAndProduct(Customer customer, Product product);

    // Busca cupons por código, cliente e produto
    // List<CouponResponse> findByCodeAndCustomerAndProduct(String code, Customer customer, Product product);

}
