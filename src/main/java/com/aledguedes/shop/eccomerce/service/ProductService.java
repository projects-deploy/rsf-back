package com.aledguedes.shop.eccomerce.service;

// import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;

import com.aledguedes.shop.eccomerce.dtoRequest.ProductRequest;
import com.aledguedes.shop.eccomerce.dtoResponse.ProductResponse;

public interface ProductService {

    ProductResponse createProduct(ProductRequest productRequest);
    ProductResponse updateProduct(ProductRequest productRequest, Long product_id);
    List<ProductResponse> listAll();
    Page<ProductResponse> listarDisponiveis(Integer page);
    Page<ProductResponse> listarDestaques(Integer page);
    List<ProductResponse> listaIndisponiveis();
    List<ProductResponse> listByDepartment(Long category_id);
    Page<ProductResponse> listarPorPalavraChave(String key, Integer page); 
    ProductResponse listById(Long id);
    List<ProductResponse> searchByTag(String tag);
    
    Page<ProductResponse> getLatestProducts(int page, int size);
    
    List<ProductResponse> getAllProductsByBrandId(Long brand_id);
    List<ProductResponse> getAllProductsByCategoryId(Long category_id);
    List<ProductResponse> getAllProductsByDepartmentId(Long department_id);
}
