package com.aledguedes.shop.eccomerce.service;

import java.util.List;

import com.aledguedes.shop.eccomerce.dtoRequest.InCollectionRequest;
import com.aledguedes.shop.eccomerce.dtoResponse.InCollectionResponse;

public interface InCollectionService {

    List<InCollectionResponse> listAll();
    InCollectionResponse inCollectionById(Long inCollection_id);
    InCollectionResponse createInCollection(InCollectionRequest inCollection);
    List<InCollectionResponse> saveInCollectionList(List<InCollectionRequest> inCollectionRequestList);
    InCollectionResponse updateInCollection(InCollectionRequest inCollection, Long inCollection_id);
}