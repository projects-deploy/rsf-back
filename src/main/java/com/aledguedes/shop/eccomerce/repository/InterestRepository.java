package com.aledguedes.shop.eccomerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aledguedes.shop.eccomerce.model.Interest;

public interface InterestRepository extends JpaRepository<Interest, Long> {
    List<Interest> findByProductId(Long productId);
}
