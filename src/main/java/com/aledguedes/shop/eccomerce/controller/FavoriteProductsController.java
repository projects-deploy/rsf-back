package com.aledguedes.shop.eccomerce.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aledguedes.shop.eccomerce.dtoResponse.FavoriteProductsResponse;
import com.aledguedes.shop.eccomerce.service.FavoriteProductsService;

import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/api/favorites")
public class FavoriteProductsController {

    private final FavoriteProductsService productsService;

    @GetMapping
    public List<FavoriteProductsResponse> listAll() {
        return productsService.listAll();
    }
    
    @GetMapping("/find")
    public List<FavoriteProductsResponse> getFavoritesByCustomerId(
    		@RequestParam(name = "q", required = false, defaultValue = "") Long customer_id) {
        return productsService.getFavoritesByCustomerId(customer_id);
    }

    @GetMapping("/create")
    public FavoriteProductsResponse createBrand(@RequestParam Long customer, @RequestParam Long product) {
        return productsService.createBrand(customer, product);
    }

    @DeleteMapping("/delete/{favorite_id}")
    public void deleteFavorite(@PathVariable Long favorite_id) {
        productsService.deleteFavorite(favorite_id);
    }

    

}
