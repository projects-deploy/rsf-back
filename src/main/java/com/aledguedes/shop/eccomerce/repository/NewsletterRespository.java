package com.aledguedes.shop.eccomerce.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aledguedes.shop.eccomerce.model.Newsletter;

public interface NewsletterRespository extends JpaRepository<Newsletter, Long> {

	Optional<Newsletter> findByEmail(String email);
    
}
