package com.aledguedes.shop.eccomerce.mapperImpl;

import org.springframework.stereotype.Component;

import com.aledguedes.shop.eccomerce.dtoRequest.ReviewRequest;
import com.aledguedes.shop.eccomerce.dtoResponse.ReviewResponse;
import com.aledguedes.shop.eccomerce.mapper.ReviewMapper;
import com.aledguedes.shop.eccomerce.model.Review;

@Component
public class ReviewMapperImpl implements ReviewMapper {

    @Override
    public Review toReview(ReviewRequest reviewRequest) {
        if (reviewRequest == null) {
            return null;
        }

        return Review.builder()
                .title(reviewRequest.getTitle())
                .rating(reviewRequest.getRating())
                .comment(reviewRequest.getComment())
                .product(reviewRequest.getProduct())
                .customer(reviewRequest.getCustomer())
                .build();
    }

    @Override
    public ReviewResponse toReviewResponse(Review review) {
        if (review == null) {
            return null;
        }

        return ReviewResponse.builder()
                .id(review.getId())
                .title(review.getTitle())
                .rating(review.getRating())
                .comment(review.getComment())
                .customer((review.getCustomer()))
                .product(review.getProduct())
                .createdAt(review.getCreatedAt())
                .updatedAt(review.getUpdatedAt())
                .build();
    }
}
