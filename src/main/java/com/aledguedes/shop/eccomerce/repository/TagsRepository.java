package com.aledguedes.shop.eccomerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aledguedes.shop.eccomerce.model.Tags;

public interface TagsRepository extends JpaRepository<Tags, Long> {
    
}
