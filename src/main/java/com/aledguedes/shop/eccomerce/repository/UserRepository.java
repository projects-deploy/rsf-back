package com.aledguedes.shop.eccomerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.aledguedes.shop.eccomerce.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);
    UserDetails findByEmail(String email);
	User findByVerificationCode(String verificationCode);
}
