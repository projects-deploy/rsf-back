package com.aledguedes.shop.eccomerce.service;

import java.util.List;

import com.aledguedes.shop.eccomerce.dtoRequest.InTabsRequest;
import com.aledguedes.shop.eccomerce.dtoResponse.InTabsResponse;
import com.aledguedes.shop.eccomerce.dtoResponse.TagProductsDTO;

public interface InTabsService {

	InTabsResponse inTabsById(Long inTabs_id);
    InTabsResponse create(InTabsRequest inTabsRequest);
    InTabsResponse update(InTabsRequest inTabsRequest, Long id);
    List<TagProductsDTO> getProductsByTag(Long inTabsId);    
}
