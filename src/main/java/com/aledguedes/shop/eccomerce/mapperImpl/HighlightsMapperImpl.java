package com.aledguedes.shop.eccomerce.mapperImpl;

import org.springframework.stereotype.Component;

import com.aledguedes.shop.eccomerce.dtoRequest.HighlightsRequest;
import com.aledguedes.shop.eccomerce.dtoResponse.HighlightsResponse;
import com.aledguedes.shop.eccomerce.mapper.HighlightsMapper;
import com.aledguedes.shop.eccomerce.model.Highlights;

@Component
public class HighlightsMapperImpl implements HighlightsMapper {

    @Override
    public Highlights toHighlights(HighlightsRequest highlightsRequest) {
        if (highlightsRequest == null) {
            return null;
        }

        return Highlights.builder()
                .link_photo(highlightsRequest.getLink_photo())
                .description(highlightsRequest.getDescription())
                .build();
    }

    @Override
    public HighlightsResponse toHighlightsResponse(Highlights highlights) {
        if (highlights == null) {
            return null;
        }

        return HighlightsResponse.builder()
                .id(highlights.getId())
                .link_photo(highlights.getLink_photo())
                .description(highlights.getDescription())
                .createdAt(highlights.getCreatedAt())
                .updatedAt(highlights.getUpdatedAt())
                .build();
    }
}
