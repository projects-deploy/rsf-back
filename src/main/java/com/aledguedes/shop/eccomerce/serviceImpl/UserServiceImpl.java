package com.aledguedes.shop.eccomerce.serviceImpl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.aledguedes.shop.eccomerce.dtoRequest.UserRequest;
import com.aledguedes.shop.eccomerce.dtoResponse.UserResponse;
import com.aledguedes.shop.eccomerce.exceptions.core.UserNotFoundException;
import com.aledguedes.shop.eccomerce.mapper.UserMapper;
import com.aledguedes.shop.eccomerce.repository.UserRepository;
import com.aledguedes.shop.eccomerce.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	private final UserMapper userMapper;
	private final UserRepository userRepository;

	@Override
	public List<UserResponse> listAll() {
		return userRepository.findAll().stream().map(userMapper::toUserResponse).toList();
	}

	@Override
	public UserResponse userById(Long user_id) {
		return userRepository.findById(user_id).map(userMapper::toUserResponse).orElseThrow(UserNotFoundException::new);
	}

	@Override
	public UserResponse findUserByEmail(String email) {
		return userRepository.findByEmail(email).map(userMapper::toUserResponse)
				.orElseThrow(UserNotFoundException::new);
	}

	@Override
	public UserResponse createUser(UserRequest userRequest) {
		try {
			var newUser = userMapper.toUser(userRequest);
			var createdUser = userRepository.save(newUser);
			return userMapper.toUserResponse(createdUser);
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public UserResponse updateUser(UserRequest userRequest, Long user_id) {
		try {
			var user = userRepository.findById(user_id).orElseThrow(UserNotFoundException::new);
			BeanUtils.copyProperties(userRequest, user, "id", "email", "password", "createdAt", "updatedAt");
			var userAtualizado = userRepository.save(user);
			return userMapper.toUserResponse(userAtualizado);
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
}
