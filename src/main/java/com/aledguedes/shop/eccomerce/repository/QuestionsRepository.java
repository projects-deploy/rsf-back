package com.aledguedes.shop.eccomerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aledguedes.shop.eccomerce.model.Questions;

public interface QuestionsRepository extends JpaRepository<Questions, Long> {
    
    List<Questions> findByCustomerId(Long customer_id);

    List<Questions> findByProductId(Long product_id);
}
