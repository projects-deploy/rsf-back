package com.aledguedes.shop.eccomerce.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.aledguedes.shop.eccomerce.dtoRequest.ReviewRequest;
import com.aledguedes.shop.eccomerce.dtoResponse.ReviewResponse;
import com.aledguedes.shop.eccomerce.service.ReviewService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/api/review")
public class ReviewController {

    private final ReviewService reviewService;

    @GetMapping
    public List<ReviewResponse> listAll() {
        return reviewService.listAll();
    }

    @GetMapping(value = "/{review_id}")
    public ReviewResponse reviewById(@PathVariable Long review_id) {
        return reviewService.reviewById(review_id);
    }

    @GetMapping(value = "/by-product/{product_id}")
    public List<ReviewResponse> getReviewsByProductId(@PathVariable Long product_id) {
        return reviewService.getReviewsByProductId(product_id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ReviewResponse createReview(@RequestBody @Valid ReviewRequest review) {
        return reviewService.createReview(review);
    }

    @PutMapping(value = "/{review_id}")
    public ReviewResponse updateReview(@RequestBody @Valid ReviewRequest review, @PathVariable Long review_id) {
        return reviewService.updateReview(review, review_id);
    }

    @DeleteMapping("/{review_id}")
    public void deleteReview(@PathVariable Long review_id) {
        reviewService.deleteReview(review_id);
    }

}
