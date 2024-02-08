package com.aledguedes.shop.eccomerce.mapper;

import com.aledguedes.shop.eccomerce.dtoRequest.InTabsRequest;
import com.aledguedes.shop.eccomerce.dtoResponse.InTabsResponse;
import com.aledguedes.shop.eccomerce.model.InTabs;

public interface InTabsMapper {
    
    InTabs toInTabs(InTabsRequest inTabsRequest);
    InTabsResponse toInTabsResponse(InTabs inTabs);
}
