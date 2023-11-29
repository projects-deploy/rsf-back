package com.aledguedes.shop.eccomerce.service;

import java.util.List;

import com.aledguedes.shop.eccomerce.dtoRequest.BrandRequest;
import com.aledguedes.shop.eccomerce.dtoResponse.BrandResponse;

public interface BrandService {
    List<BrandResponse> listAll();
    BrandResponse brandById(Long brand_id);
    BrandResponse createBrand(BrandRequest brand);
    BrandResponse updateBrand(BrandRequest brand, Long brand_id);
}
