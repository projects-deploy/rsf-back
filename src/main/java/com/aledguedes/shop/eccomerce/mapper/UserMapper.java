package com.aledguedes.shop.eccomerce.mapper;

import com.aledguedes.shop.eccomerce.dtoRequest.UserRequest;
import com.aledguedes.shop.eccomerce.dtoResponse.UserResponse;
import com.aledguedes.shop.eccomerce.model.User;

public interface UserMapper {
    User toUser(UserRequest userRequest);
    UserResponse toUserResponse(User user);
}
