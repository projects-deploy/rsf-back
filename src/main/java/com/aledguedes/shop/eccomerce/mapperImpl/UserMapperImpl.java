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
                .linkPhoto(userRequest.getLinkPhoto())
                .password(userRequest.getPassword())
                .build();
    }

    @Override
    public UserResponse toUserResponse(User user) {
        if (user == null) {
            return null;
        }
		
		return UserResponse.builder()
				.id(user.getId())
				.name(user.getName())
				.email(user.getEmail())
                .enabled(user.getEnabled())
                .linkPhoto(user.getLinkPhoto())
	            .createdAt(user.getCreatedAt())
	            .updatedAt(user.getUpdatedAt())
	            .build();
    }

}
