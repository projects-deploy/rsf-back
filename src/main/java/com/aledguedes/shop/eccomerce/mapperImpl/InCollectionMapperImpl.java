package com.aledguedes.shop.eccomerce.mapperImpl;

import org.springframework.stereotype.Component;

import com.aledguedes.shop.eccomerce.dtoRequest.InCollectionRequest;
import com.aledguedes.shop.eccomerce.dtoResponse.InCollectionResponse;
import com.aledguedes.shop.eccomerce.mapper.InCollectionMapper;
import com.aledguedes.shop.eccomerce.model.InCollection;

@Component
public class InCollectionMapperImpl implements InCollectionMapper {

    @Override
    public InCollection toInCollection(InCollectionRequest inCollectionRequest) {
        if (inCollectionRequest == null) {
            return null;
        }

        return InCollection.builder()
                .link_photo(inCollectionRequest.getLink_photo())
                .description(inCollectionRequest.getDescription())
                .build();
    }

    @Override
    public InCollectionResponse toInCollectionResponse(InCollection inCollection) {
        if (inCollection == null) {
            return null;
        }

        return InCollectionResponse.builder()
                .id(inCollection.getId())
                .link_photo(inCollection.getLink_photo())
                .description(inCollection.getDescription())
                .createdAt(inCollection.getCreatedAt())
                .updatedAt(inCollection.getUpdatedAt())
                .build();
    }
}
