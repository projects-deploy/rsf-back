package com.aledguedes.shop.eccomerce.serviceImpl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.aledguedes.shop.eccomerce.dtoResponse.FavoriteProductsResponse;
import com.aledguedes.shop.eccomerce.exceptions.core.CustomerNotFoundException;
import com.aledguedes.shop.eccomerce.exceptions.core.FavoriteProductsNotFoundException;
import com.aledguedes.shop.eccomerce.exceptions.core.ProductNotFoundException;
import com.aledguedes.shop.eccomerce.mapper.FavoriteProductsMapper;
import com.aledguedes.shop.eccomerce.model.FavoriteProducts;
import com.aledguedes.shop.eccomerce.repository.CustomerRepository;
import com.aledguedes.shop.eccomerce.repository.FavoriteProductsRepository;
import com.aledguedes.shop.eccomerce.repository.ProductRepository;
import com.aledguedes.shop.eccomerce.service.FavoriteProductsService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@SuppressWarnings("null")
public class FavoriteProductsServiceImpl implements FavoriteProductsService {

    private final FavoriteProductsMapper favoriteProductsMapper;

    private final ProductRepository productRepository;
    private final CustomerRepository customerRepository;
    private final FavoriteProductsRepository favoriteRepository;

    @Override
    public List<FavoriteProductsResponse> listAll() {
        return favoriteRepository.findAll()
                .stream()
                .map(favoriteProductsMapper::toFavoriteProductsResponse)
                .toList();
    }

    @Override
    public FavoriteProductsResponse createBrand(Long customer_id, Long product_id) {
        try {
            var customer = customerRepository.findById(customer_id)
                    .orElseThrow(CustomerNotFoundException::new);

            var product = productRepository.findById(product_id)
                    .orElseThrow(ProductNotFoundException::new);

            var newFavorite = new FavoriteProducts();
            newFavorite.setCustomer(customer);
            newFavorite.setProduct(product);
            newFavorite.setAdded_in(LocalDateTime.now());
            
            favoriteRepository.save(newFavorite);

            return favoriteProductsMapper.toFavoriteProductsResponse(newFavorite);
        } catch (Exception e) {
            System.out.println("DEBUG = " + e.getMessage());
            return null;
        }
    }

    @Override
    public void deleteFavorite(Long favorite_id) {
        try {
            var existingFavorite = favoriteRepository.findById(favorite_id)
                    .orElseThrow(FavoriteProductsNotFoundException::new);

            favoriteRepository.delete(existingFavorite);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
