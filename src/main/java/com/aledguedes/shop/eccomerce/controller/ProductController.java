package com.aledguedes.shop.eccomerce.controller;

import java.util.List;

import org.springframework.data.domain.Page;
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

import com.aledguedes.shop.eccomerce.dtoRequest.ProductRequest;
import com.aledguedes.shop.eccomerce.dtoResponse.ProductResponse;
import com.aledguedes.shop.eccomerce.exceptions.core.CategoryNotFoundException;
import com.aledguedes.shop.eccomerce.mapper.CategoryMapper;
import com.aledguedes.shop.eccomerce.repository.CategoryRepository;
import com.aledguedes.shop.eccomerce.service.ProductService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/api/product")
public class ProductController {

    private final ProductService productService;
    private final CategoryMapper categoryMapper;
    private final CategoryRepository categoryRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponse createProduct(@RequestBody @Valid ProductRequest productRequest) {

		System.out.println("DEBUG MARCA: "+productRequest.getCategory().getId());
		System.out.println("DEBUG MARCA: "+productRequest.getBrand().getId());
        return productService.createProduct(productRequest);
    }

    @PutMapping(value = "/{product_id}")
    public ProductResponse updateProduct(
    		@RequestBody @Valid ProductRequest productRequest,
    		@PathVariable Long product_id) {
        return productService.updateProduct(productRequest, product_id);
    }

    @GetMapping
    public List<ProductResponse> listAll() {
        return productService.listAll();
    }

    @GetMapping(value = "/by-available")
    public Page<ProductResponse> listarDisponiveis(@RequestParam (name="page") Integer page) {
        return productService.listarDisponiveis(page);
    }

    @GetMapping(value = "/by-destaks")
    public Page<ProductResponse> listarDestaques(@RequestParam (name="page") Integer page) {
        return productService.listarDestaques(page);
    }

    @GetMapping(value = "/by-unavailable")
    public List<ProductResponse> listaIndisponiveis() {
        return productService.listaIndisponiveis();
    }

    @GetMapping(value = "/by-category/{category_id}")
    public List<ProductResponse> listByCategory(@PathVariable(name = "id") Long category_id) {
        var category = categoryRepository.findById(category_id)
                .map(categoryMapper::toCategoryResponse)
                .orElseThrow(CategoryNotFoundException::new);
        if (category != null)
            return productService.listByCategory(category);

        return null;
    }

    @GetMapping(value = "/find")
    public Page<ProductResponse> listarPorPalavraChave(@RequestParam (name="key") String key, Integer page) {
        return productService.listarPorPalavraChave(key, page);
    }

    @GetMapping(value = "/{product_id}")
    public ProductResponse listById(@PathVariable Long product_id) {
        return productService.listById(product_id);
    }

}
