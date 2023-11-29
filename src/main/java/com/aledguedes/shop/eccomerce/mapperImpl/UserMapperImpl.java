package com.aledguedes.shop.eccomerce.mapperImpl;

import org.springframework.stereotype.Component;

import com.aledguedes.shop.eccomerce.dtoRequest.UserRequest;
import com.aledguedes.shop.eccomerce.dtoResponse.UserResponse;
import com.aledguedes.shop.eccomerce.mapper.UserMapper;
import com.aledguedes.shop.eccomerce.model.User;

@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User toUser(UserRequest userRequest) {
        if (userRequest == null) {
            return null;
        }

        return User.builder()
                .email(userRequest.getEmail())
                .name(userRequest.getName())
                .password(userRequest.getPassword())
                .username(userRequest.getUsername())
                .user_active(userRequest.getUser_active())
                .build();
    }

    @Override
    public UserResponse toUserResponse(User user) {
        if (user == null) {
            return null;
        }
		
		return UserResponse.builder()
				.id(user.getId())
				.email(user.getEmail())
                .name(user.getName())
                .username(user.getUsername())
                .user_active(user.getUser_active())
	            .createdAt(user.getCreatedAt())
	            .updatedAt(user.getUpdatedAt())
	            .build();
    }

}
