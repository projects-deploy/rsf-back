package com.aledguedes.shop.eccomerce.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.aledguedes.shop.eccomerce.dtoRequest.ProductImageRequest;
import com.aledguedes.shop.eccomerce.dtoResponse.ProductImageResponse;
import com.aledguedes.shop.eccomerce.service.ProductImageService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/api/product-image")
public class ProductImageController {

    private final ProductImageService prodImageService;

    @GetMapping
    public List<ProductImageResponse> listAll() {
        return prodImageService.listAll();
    }

    @GetMapping(value = "/{product_image_id}")
    public ProductImageResponse productImageById(@PathVariable Long product_image_id) {
        return prodImageService.productImageById(product_image_id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductImageResponse createroductImage(@RequestBody @Valid ProductImageRequest product_image) {
        return prodImageService.createroductImage(product_image);
    }

    @PutMapping(value = "/{product_image_id}")
    public ProductImageResponse updateroductImage(
            @RequestBody @Valid ProductImageRequest product_image,
            @PathVariable Long product_image_id) {
        return prodImageService.updateroductImage(product_image, product_image_id);
    }

    @DeleteMapping(value = "/{product_image_id}")
    public void deleteProductImage(@PathVariable Long product_image_id) {
        prodImageService.deleteProductImage(product_image_id);
    }

}
