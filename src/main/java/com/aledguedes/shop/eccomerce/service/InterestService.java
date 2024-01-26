package com.aledguedes.shop.eccomerce.service;

import java.util.List;

import com.aledguedes.shop.eccomerce.dtoRequest.InterestRequest;
import com.aledguedes.shop.eccomerce.dtoResponse.InterestResponse;

public interface InterestService {

    List<InterestResponse> listAll();
    InterestResponse interestById(Long interest_id);
    InterestResponse createInterest(InterestRequest interestRequest);

    void notifySubscribers(Long product_id);
}
