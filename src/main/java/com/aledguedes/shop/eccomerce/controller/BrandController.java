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

import com.aledguedes.shop.eccomerce.dtoRequest.BrandRequest;
import com.aledguedes.shop.eccomerce.dtoResponse.BrandResponse;
import com.aledguedes.shop.eccomerce.service.BrandService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/api/brand")
public class BrandController {

    private final BrandService brandService;

    @GetMapping
    public List<BrandResponse> listAll() {
        return brandService.listAll();
    }

    @GetMapping(value = "/{brand_id}")
    public BrandResponse brandById(@PathVariable Long brand_id) {
        return brandService.brandById(brand_id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BrandResponse createBrand(@RequestBody @Valid BrandRequest brand) {
        return brandService.createBrand(brand);
    }

    @PutMapping(value = "/{brand_id}")
    public BrandResponse updateBrand(@RequestBody @Valid BrandRequest brand, @PathVariable Long brand_id) {
        return brandService.updateBrand(brand, brand_id);
    }
}
