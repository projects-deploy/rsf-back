package com.aledguedes.shop.eccomerce.serviceImpl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.aledguedes.shop.eccomerce.dtoRequest.ReviewRequest;
import com.aledguedes.shop.eccomerce.dtoResponse.ReviewByProductResponse;
import com.aledguedes.shop.eccomerce.dtoResponse.ReviewResponse;
import com.aledguedes.shop.eccomerce.exceptions.core.CustomerNotFoundException;
import com.aledguedes.shop.eccomerce.exceptions.core.ProductNotFoundException;
import com.aledguedes.shop.eccomerce.exceptions.core.ReviewNotFoundException;
import com.aledguedes.shop.eccomerce.mapper.ReviewMapper;
import com.aledguedes.shop.eccomerce.repository.CustomerRepository;
import com.aledguedes.shop.eccomerce.repository.ProductRepository;
import com.aledguedes.shop.eccomerce.repository.ReviewRepository;
import com.aledguedes.shop.eccomerce.service.ReviewService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final ReviewMapper reviewMapper;
    private final ReviewRepository reviewRepository;
    private final ProductRepository productRepository;
    private final CustomerRepository customerRepository;

    @Override
    public List<ReviewResponse> listAll() {
        return reviewRepository.findAll()
                .stream()
                .map(reviewMapper::toReviewResponse)
                .toList();
    }

    @Override
    public ReviewResponse reviewById(Long review_id) {
        return reviewRepository.findById(review_id)
                .map(reviewMapper::toReviewResponse)
                .orElseThrow(ReviewNotFoundException::new);
    }

    @Override
    public List<ReviewByProductResponse> getReviewsByProductId(Long product_id) {
        var reviews = reviewRepository.findByProduct_Id(product_id);

        return reviews.stream()
                .map(reviewMapper::toReviewByProductResponse)
                .toList();
    }

    @Override
    public ReviewResponse createReview(ReviewRequest reviewRequest) {
        try {

            var customer = customerRepository.findById(reviewRequest.getCustomer().getId())
                    .orElseThrow(CustomerNotFoundException::new);

            var product = productRepository.findById(reviewRequest.getProduct().getId())
                    .orElseThrow(ProductNotFoundException::new);

            var newReview = reviewMapper.toReview(reviewRequest);

            newReview.setCustomer(customer);
            newReview.setProduct(product);

            var createdReview = reviewRepository.save(newReview);

            // Atualiza a média e a quantidade de comentários do produto
            product.getReviews().add(createdReview);
            product.updateRatingAndReviewCount();
            productRepository.save(product);

            return reviewMapper.toReviewResponse(createdReview);
        } catch (Exception e) {
            System.out.println("DEBUG = " + e.getMessage());
        }
        return null;
    }

    @Override
    public ReviewResponse updateReview(ReviewRequest reviewRequest, Long review_id) {
        try {
            var review = reviewRepository.findById(review_id)
                    .orElseThrow(ReviewNotFoundException::new);
            BeanUtils.copyProperties(reviewRequest, review, "id", "product", "customer", "createdAt", "updatedAt");
            var reviewAtualizado = reviewRepository.save(review);
            return reviewMapper.toReviewResponse(reviewAtualizado);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public void deleteReview(Long review_id) {
        try {
            reviewRepository.deleteById(review_id);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
