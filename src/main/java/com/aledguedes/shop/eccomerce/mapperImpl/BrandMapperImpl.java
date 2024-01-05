package com.aledguedes.shop.eccomerce.mapperImpl;

import org.springframework.stereotype.Component;

import com.aledguedes.shop.eccomerce.dtoRequest.BrandRequest;
import com.aledguedes.shop.eccomerce.dtoResponse.BrandResponse;
import com.aledguedes.shop.eccomerce.mapper.BrandMapper;
import com.aledguedes.shop.eccomerce.model.Brand;

@Component
public class BrandMapperImpl implements BrandMapper {

    @Override
    public Brand toBrand(BrandRequest brandRequest) {
        if (brandRequest == null) {
            return null;
        }

        return Brand.builder()
                .name(brandRequest.getName())
                .link_photo(brandRequest.getLink_photo())
                .build();
    }

    @Override
    public BrandResponse toBrandResponse(Brand brand) {
        if (brand == null) {
            return null;
        }

        return BrandResponse.builder()
                .id(brand.getId())
                .name(brand.getName())
                .link_photo(brand.getLink_photo())
                .createdAt(brand.getCreatedAt())
                .updatedAt(brand.getUpdatedAt())
                .build();
    }
}
