package com.aledguedes.shop.eccomerce.mapperImpl;

import org.springframework.stereotype.Component;

import com.aledguedes.shop.eccomerce.dtoRequest.InterestRequest;
import com.aledguedes.shop.eccomerce.dtoResponse.InterestResponse;
import com.aledguedes.shop.eccomerce.mapper.InterestMapper;
import com.aledguedes.shop.eccomerce.model.Interest;

@Component
public class InterestMapperImpl implements InterestMapper {

    @Override
    public Interest toInterest(InterestRequest interestRequest) {
        if (interestRequest == null) {
            return null;
        }

        return Interest.builder()
                .product(interestRequest.getProduct())
                .customer(interestRequest.getCustomer())
                .build();
    }

    @Override
    public InterestResponse toInterestResponse(Interest interest) {
        if (interest == null) {
            return null;
        }

        return InterestResponse.builder()
                .id(interest.getId())
                .product(interest.getProduct())
                .customer(interest.getCustomer())
	            .createdAt(interest.getCreatedAt())
	            .updatedAt(interest.getUpdatedAt())
                .build();
    }

}
