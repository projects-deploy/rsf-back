package com.aledguedes.shop.eccomerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aledguedes.shop.eccomerce.model.ItemOrder;

public interface ItemOrderRepository extends JpaRepository<ItemOrder, Long> {

}
