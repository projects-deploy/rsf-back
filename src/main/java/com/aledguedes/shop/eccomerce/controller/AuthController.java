package com.aledguedes.shop.eccomerce.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import com.aledguedes.shop.eccomerce.config.auth.TokenService;
import com.aledguedes.shop.eccomerce.dtoRequest.AuthenticationRequest;
import com.aledguedes.shop.eccomerce.dtoResponse.AuthenticationResponse;
import com.aledguedes.shop.eccomerce.model.User;

import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {

	private final TokenService tokenService;
	private final AuthenticationManager authenticationManager;

	@PostMapping("/login")
	public AuthenticationResponse login(@RequestBody AuthenticationRequest authenticationRequest) {
		UsernamePasswordAuthenticationToken usernamePassword = new UsernamePasswordAuthenticationToken(
				authenticationRequest.email(), authenticationRequest.password());

		var auth = authenticationManager.authenticate(usernamePassword);
		System.out.println("DEBUG: " + auth);
		System.out.println("DEBUG: " + authenticationRequest.password());
		var token = tokenService.generateToken((User) auth.getPrincipal());

		return new AuthenticationResponse(token);
	}

}
