package com.aledguedes.shop.eccomerce.mapper;

import com.aledguedes.shop.eccomerce.dtoRequest.ReviewRequest;
import com.aledguedes.shop.eccomerce.dtoResponse.ReviewByProductResponse;
import com.aledguedes.shop.eccomerce.dtoResponse.ReviewResponse;
import com.aledguedes.shop.eccomerce.model.Review;

public interface ReviewMapper {

    Review toReview(ReviewRequest reviewRequest);
    ReviewResponse toReviewResponse(Review review);
    ReviewByProductResponse toReviewByProductResponse(Review review);
}