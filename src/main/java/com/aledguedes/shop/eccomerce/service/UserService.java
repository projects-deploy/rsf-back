package com.aledguedes.shop.eccomerce.service;

import java.util.List;

import com.aledguedes.shop.eccomerce.dtoRequest.UserRequest;
import com.aledguedes.shop.eccomerce.dtoResponse.UserResponse;

public interface UserService {
    List<UserResponse> listAll();
    UserResponse userById(Long user_id);
    UserResponse findUserByEmail(String email);
    UserResponse createUser(UserRequest userRequest);
    UserResponse updateUser(UserRequest userRequest, Long user_id);
}
