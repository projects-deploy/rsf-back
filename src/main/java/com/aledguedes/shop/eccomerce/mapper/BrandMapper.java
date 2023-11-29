package com.aledguedes.shop.eccomerce.mapper;

import com.aledguedes.shop.eccomerce.dtoRequest.BrandRequest;
import com.aledguedes.shop.eccomerce.dtoResponse.BrandResponse;
import com.aledguedes.shop.eccomerce.model.Brand;

public interface BrandMapper {

    Brand toBrand(BrandRequest brandRequest);
    BrandResponse toBrandResponse(Brand brand);
}