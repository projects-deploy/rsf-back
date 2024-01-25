package com.aledguedes.shop.eccomerce.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.aledguedes.shop.eccomerce.dtoRequest.InterestRequest;
import com.aledguedes.shop.eccomerce.dtoResponse.InterestResponse;
import com.aledguedes.shop.eccomerce.service.InterestService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/api/interest")
public class InterestController {

    private final InterestService interestService;

    @GetMapping
    public List<InterestResponse> listAll() {
        return interestService.listAll();
    }

    @GetMapping(value = "/{interest_id}")
    public InterestResponse interestById(@PathVariable Long interest_id) {
        return interestService.interestById(interest_id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public InterestResponse createInterest(@RequestBody @Valid InterestRequest interestRequest) {
        return interestService.createInterest(interestRequest);
    }
    @GetMapping(value = "/find/by-interest-product")
    public void notifySubscribers(
        @RequestParam(name = "q", required = true, defaultValue = "0") Long product_id) {
        interestService.notifySubscribers(product_id);
    }

}
