package com.aledguedes.shop.eccomerce.serviceImpl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.aledguedes.shop.eccomerce.dtoRequest.ProductImageRequest;
import com.aledguedes.shop.eccomerce.dtoResponse.ProductImageResponse;
import com.aledguedes.shop.eccomerce.exceptions.core.ProductImageNotFoundException;
import com.aledguedes.shop.eccomerce.exceptions.core.ProductNotFoundException;
import com.aledguedes.shop.eccomerce.mapper.ProductImageMapper;
import com.aledguedes.shop.eccomerce.repository.ProductImageRepository;
import com.aledguedes.shop.eccomerce.repository.ProductRepository;
import com.aledguedes.shop.eccomerce.service.ProductImageService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@SuppressWarnings("null")
public class ProductImageServiceImpl implements ProductImageService {

    private final ProductRepository productRepository;
    private final ProductImageMapper productImageMapper;
    private final ProductImageRepository productImageRepository;

    @Override
    public List<ProductImageResponse> listAll() {
        return productImageRepository.findAll()
                .stream()
                .map(productImageMapper::toProductImageResponse)
                .toList();
    }

    @Override
    public ProductImageResponse productImageById(Long product_image_id) {
        return productImageRepository.findById(product_image_id)
                .map(productImageMapper::toProductImageResponse)
                .orElseThrow(ProductImageNotFoundException::new);
    }

    @Override
    public ProductImageResponse createroductImage(ProductImageRequest request) {
        try {
            var create = productImageMapper.toProductImage(request);

            var produto = productRepository.findById(request.getProduct().getId())
                    .orElseThrow(ProductNotFoundException::new);

            create.setProduct(produto);

            var savedProductImage = productImageRepository.save(create);

            return productImageMapper.toProductImageResponse(savedProductImage);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public ProductImageResponse updateroductImage(ProductImageRequest request, Long product_image_id) {
        var prodImg = productImageRepository.findById(product_image_id)
                .orElseThrow(ProductImageNotFoundException::new);

        BeanUtils.copyProperties(request, prodImg, "id", "product");

        var prodImgAtualizado = productImageRepository.save(prodImg);
        return productImageMapper.toProductImageResponse(prodImgAtualizado);
    }

    @Override
    public void deleteProductImage(Long productImageId) {
        try {
            productImageRepository.deleteById(productImageId);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
