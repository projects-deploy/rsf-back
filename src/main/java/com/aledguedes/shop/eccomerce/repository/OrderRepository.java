package com.aledguedes.shop.eccomerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aledguedes.shop.eccomerce.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
