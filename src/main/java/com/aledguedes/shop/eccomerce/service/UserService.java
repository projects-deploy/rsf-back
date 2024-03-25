package com.aledguedes.shop.eccomerce.service;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;

import com.aledguedes.shop.eccomerce.dtoRequest.UserRequest;
import com.aledguedes.shop.eccomerce.dtoResponse.UserResponse;

import jakarta.mail.MessagingException;

public interface UserService {
    List<UserResponse> listAll();
    UserResponse userById(Long user_id);
    UserDetails findUserByEmail(String email);
    UserResponse createUser(UserRequest userRequest) throws UnsupportedEncodingException, MessagingException;
    UserResponse updateUser(UserRequest userRequest, Long user_id);
    boolean verifyCodeUser(String verificationCode);
}
