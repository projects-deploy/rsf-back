package com.aledguedes.shop.eccomerce.service;

// import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;

import com.aledguedes.shop.eccomerce.dtoRequest.ProductRequest;
import com.aledguedes.shop.eccomerce.dtoResponse.CategoryResponse;
import com.aledguedes.shop.eccomerce.dtoResponse.ProductResponse;

public interface ProductService {

    public ProductResponse createProduct(ProductRequest productRequest);
    public ProductResponse updateProduct(ProductRequest productRequest, Long product_id);
    public List<ProductResponse> listAll();
    public Page<ProductResponse> listarDisponiveis(Integer page);
    public Page<ProductResponse> listarDestaques(Integer page);
    public List<ProductResponse> listaIndisponiveis();
    public List<ProductResponse> listByCategory(CategoryResponse category);
    public Page<ProductResponse> listarPorPalavraChave(String key, Integer page);
    public ProductResponse listById(Long id);
}
