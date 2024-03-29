package com.aledguedes.shop.eccomerce.serviceImpl;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.aledguedes.shop.eccomerce.dtoRequest.UserRequest;
import com.aledguedes.shop.eccomerce.dtoResponse.UserResponse;
import com.aledguedes.shop.eccomerce.exceptions.core.UserNotFoundException;
import com.aledguedes.shop.eccomerce.mapper.UserMapper;
import com.aledguedes.shop.eccomerce.model.User;
import com.aledguedes.shop.eccomerce.repository.UserRepository;
import com.aledguedes.shop.eccomerce.service.UserService;
import com.aledguedes.shop.eccomerce.util.RandomString;

import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@SuppressWarnings("null")
public class UserServiceImpl implements UserService {

	private final UserMapper userMapper;
	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;

	@Override
	public List<UserResponse> listAll() {
		return userRepository.findAll().stream().map(userMapper::toUserResponse).toList();
	}

	@Override
	public UserResponse userById(Long user_id) {
		return userRepository.findById(user_id).map(userMapper::toUserResponse).orElseThrow(UserNotFoundException::new);
	}

	@Override
	public UserDetails findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public boolean verifyCodeUser(String verificationCode) {

		try {
			User user = userRepository.findByVerificationCode(verificationCode);

			if (user == null || user.isEnabled()) {
				return false;
			} else {
				user.setVerificationCode(null);
				user.setEnabled(true);
				userRepository.save(user);

				return true;
			}
		} catch (Exception e) {
			throw new RuntimeException("Usuário não encontrado pelo código de verificação", e);
		}
	}

	@Override
	public UserResponse createUser(UserRequest userRequest) throws UnsupportedEncodingException, MessagingException {
		var existsEmail = userRepository.findByEmail(userRequest.getEmail());
		if (existsEmail != null) {
			throw new RuntimeException("Email já cadastrado!!!");
		} else {
			var newUser = userMapper.toUser(userRequest);
			String encodedPassword = passwordEncoder.encode(newUser.getPassword());

			String randomCode = RandomString.generateRandomString(64);
			newUser.setEnabled(false);
			newUser.setPassword(encodedPassword);
			newUser.setVerificationCode(randomCode);

			var createdUser = userRepository.save(newUser);

			return userMapper.toUserResponse(createdUser);
		}
	}

	@Override
	public UserResponse updateUser(UserRequest userRequest, @PathVariable Long user_id) {
		try {
			var user = userRepository.findById(user_id).orElseThrow(UserNotFoundException::new);
			BeanUtils.copyProperties(userRequest, user, "id", "email", "createdAt", "updatedAt");
			var userAtualizado = userRepository.save(user);
			return userMapper.toUserResponse(userAtualizado);
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
}
