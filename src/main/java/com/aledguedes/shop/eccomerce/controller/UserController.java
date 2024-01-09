package com.aledguedes.shop.eccomerce.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.aledguedes.shop.eccomerce.dtoRequest.UserRequest;
import com.aledguedes.shop.eccomerce.dtoResponse.UserResponse;
import com.aledguedes.shop.eccomerce.service.UserService;

import jakarta.mail.MessagingException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {

	private final UserService userService;

	@GetMapping
	public List<UserResponse> listAll() {
		return userService.listAll();
	}

	@GetMapping(value = "/{user_id}")
	public UserResponse userById(@PathVariable Long user_id) {
		return userService.userById(user_id);
	}

	@GetMapping(value = "/find")
	public UserResponse findUserByEmail(@RequestParam(name = "q", required = false, defaultValue = "") String email) {
		return userService.findUserByEmail(email);
	}

	@GetMapping("/verify")
	public String verifyUser(@Param("code") String code) {
		if (userService.verifyCodeUser(code)) {
			return "verify_success";
		} else {
			return "verify_fail";
		}
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public UserResponse createUser(@RequestBody @Valid UserRequest userRequest)
			throws UnsupportedEncodingException, MessagingException {
		System.out.println("DEBUG CONTROLLER " + userRequest.getEmail());
		return userService.createUser(userRequest);
	}

	@PutMapping(value = "/{user_id}")
	public UserResponse updateUser(@RequestBody @Valid UserRequest userRequest, @PathVariable Long user_id) {
		return userService.updateUser(userRequest, user_id);
	}

}
