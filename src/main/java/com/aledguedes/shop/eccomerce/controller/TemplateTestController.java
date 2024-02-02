package com.aledguedes.shop.eccomerce.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aledguedes.shop.eccomerce.exceptions.core.UserNotFoundException;
import com.aledguedes.shop.eccomerce.mapper.UserMapper;
import com.aledguedes.shop.eccomerce.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
public class TemplateTestController {

    private final UserMapper userMapper;
    private final UserRepository userRepository;

    @GetMapping("/test-template")
    public String testTemplate(Model model) {

        long user_id = 1;

        var user = userRepository.findById(user_id)
                .map(userMapper::toUserResponse)
                .orElseThrow(UserNotFoundException::new);

        String code = user.getVerificationCode();
        String verifyURL =  "http://localhost:8080/api/user/verify?code=";

        String confirmationLink = verifyURL + code;

        model.addAttribute("user", user);
        model.addAttribute("confirmationLink", confirmationLink);

        return "confirmation-email - 2";
    }
}
