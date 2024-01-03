package com.aledguedes.shop.eccomerce.service;

import java.util.List;

import com.aledguedes.shop.eccomerce.dtoRequest.ReviewRequest;
import com.aledguedes.shop.eccomerce.dtoResponse.ReviewResponse;

public interface ReviewService {
    
    List<ReviewResponse> listAll();
    ReviewResponse reviewById(Long review_id);
    List<ReviewResponse> getReviewsByProductId(Long product_id);
    ReviewResponse createReview(ReviewRequest review);
    ReviewResponse updateReview(ReviewRequest review, Long review_id);
    void deleteReview(Long review_id);
}
