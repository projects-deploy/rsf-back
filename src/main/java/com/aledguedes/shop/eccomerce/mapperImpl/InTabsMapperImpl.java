package com.aledguedes.shop.eccomerce.mapperImpl;

import org.springframework.stereotype.Component;

import com.aledguedes.shop.eccomerce.dtoRequest.InTabsRequest;
import com.aledguedes.shop.eccomerce.dtoResponse.InTabsResponse;
import com.aledguedes.shop.eccomerce.mapper.InTabsMapper;
import com.aledguedes.shop.eccomerce.model.InTabs;

@Component
public class InTabsMapperImpl implements InTabsMapper {

    @Override
    public InTabs toInTabs(InTabsRequest inTabsRequest) {
       if (inTabsRequest == null) {
            return null;
        }

        return InTabs.builder()
                .tabs(inTabsRequest.getTags())
                .build();
    }

    @Override
    public InTabsResponse toInTabsResponse(InTabs inTabs) {
        if (inTabs == null) {
            return null;
        }

        return InTabsResponse.builder()
                .id(inTabs.getId())
                .tabs(inTabs.getTabs())
                .build();
    }
    
}
