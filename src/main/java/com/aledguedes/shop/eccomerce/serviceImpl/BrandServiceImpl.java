package com.aledguedes.shop.eccomerce.serviceImpl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.aledguedes.shop.eccomerce.dtoRequest.BrandRequest;
import com.aledguedes.shop.eccomerce.dtoResponse.BrandResponse;
import com.aledguedes.shop.eccomerce.exceptions.core.BrandNotFoundException;
import com.aledguedes.shop.eccomerce.mapper.BrandMapper;
import com.aledguedes.shop.eccomerce.repository.BrandRepository;
import com.aledguedes.shop.eccomerce.service.BrandService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BrandServiceImpl implements BrandService {

    private final BrandMapper brandMapper;
    private final BrandRepository brandRepository;

    @Override
    public List<BrandResponse> listAll() {
        return brandRepository.findAll()
                .stream()
                .map(brandMapper::toBrandResponse)
                .toList();
    }

    @Override
    public BrandResponse brandById(Long brand_id) {
        return brandRepository.findById(brand_id)
                .map(brandMapper::toBrandResponse)
                .orElseThrow(BrandNotFoundException::new);
    }

    @Override
    public BrandResponse createBrand(BrandRequest brandRequest) {
        try {
            var newBrand = brandMapper.toBrand(brandRequest);
            var createdBrand = brandRepository.save(newBrand);
            return brandMapper.toBrandResponse(createdBrand);
        } catch (Exception e) {
            System.out.println("DEBUG = " + e.getMessage());
        }
        return null;
    }

    @Override
    public BrandResponse updateBrand(BrandRequest brandRequest, Long brand_id) {
        try {
			var brand = brandRepository.findById(brand_id)
					.orElseThrow(BrandNotFoundException::new);
			BeanUtils.copyProperties(brandRequest, brand, "id", "createdAt", "updatedAt");
			var brandAtualizado = brandRepository.save(brand);
			return brandMapper.toBrandResponse(brandAtualizado);
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
    }

}
