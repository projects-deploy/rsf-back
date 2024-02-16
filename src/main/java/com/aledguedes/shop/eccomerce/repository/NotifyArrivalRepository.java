package com.aledguedes.shop.eccomerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aledguedes.shop.eccomerce.model.NotifyArrival;
import java.util.List;


public interface NotifyArrivalRepository extends JpaRepository<NotifyArrival, Long> {

    List<NotifyArrival> findByProductId(Long productId);
    
}
