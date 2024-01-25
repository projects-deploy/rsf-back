package com.aledguedes.shop.eccomerce.mapper;

import com.aledguedes.shop.eccomerce.dtoRequest.InterestRequest;
import com.aledguedes.shop.eccomerce.dtoResponse.InterestResponse;
import com.aledguedes.shop.eccomerce.model.Interest;

public interface InterestMapper {

    Interest toInterest(InterestRequest interestRequest);
    InterestResponse toInterestResponse(Interest interest);
}
