package com.aledguedes.shop.eccomerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aledguedes.shop.eccomerce.config.auth.TokenService;
import com.aledguedes.shop.eccomerce.dtoRequest.AuthenticationRequest;
import com.aledguedes.shop.eccomerce.dtoResponse.AuthenticationResponse;
import com.aledguedes.shop.eccomerce.model.User;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/auth")
public class AuthController {

	@Autowired private TokenService tokenService;
	@Autowired private AuthenticationManager authenticationManager;
	
	@PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody @Valid AuthenticationRequest data){
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.email(), data.password());
        
        System.out.println("DEBUG: PASSW: "+data.email());

        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((User) auth.getPrincipal());

        return ResponseEntity.ok(new AuthenticationResponse(token));
    }

}
