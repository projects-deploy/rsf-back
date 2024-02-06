package com.aledguedes.shop.eccomerce.mapper;

import com.aledguedes.shop.eccomerce.dtoRequest.InCollectionRequest;
import com.aledguedes.shop.eccomerce.dtoResponse.InCollectionResponse;
import com.aledguedes.shop.eccomerce.model.InCollection;

public interface InCollectionMapper {

    InCollection toInCollection(InCollectionRequest inCollectionRequest);
    InCollectionResponse toInCollectionResponse(InCollection inCollection);
}