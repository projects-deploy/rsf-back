package com.aledguedes.shop.eccomerce.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.aledguedes.shop.eccomerce.dtoRequest.InTabsRequest;
import com.aledguedes.shop.eccomerce.dtoResponse.InTabsResponse;
import com.aledguedes.shop.eccomerce.dtoResponse.TagProductsDTO;
import com.aledguedes.shop.eccomerce.service.InTabsService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/api/tabs")
public class InTabsController {
    
    private final InTabsService inTabsService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public InTabsResponse create(@RequestBody @Valid InTabsRequest inTabsRequest) {
        return inTabsService.create(inTabsRequest);
    }

    @PutMapping(value = "/{inTab_id}")
    public InTabsResponse update(@RequestBody @Valid InTabsRequest inTabsRequest, @PathVariable Long inTab_id) {
        return inTabsService.update(inTabsRequest, inTab_id);
    }

    @GetMapping(value = "/products-tabs/{inTab_id}")
    public List<TagProductsDTO> getProductsByTag(@PathVariable Long inTab_id) {
        return inTabsService.getProductsByTag(inTab_id);
    }
    
    @GetMapping(value = "/{inTab_id}")
    public InTabsResponse inTabsById(@PathVariable Long inTab_id) {
        return inTabsService.inTabsById(inTab_id);
    }

    
}
