package com.aledguedes.shop.eccomerce.mapper;

import com.aledguedes.shop.eccomerce.dtoRequest.HighlightsRequest;
import com.aledguedes.shop.eccomerce.dtoResponse.HighlightsResponse;
import com.aledguedes.shop.eccomerce.model.Highlights;

public interface HighlightsMapper {

    Highlights toHighlights(HighlightsRequest highlightsRequest);
    HighlightsResponse toHighlightsResponse(Highlights highlights);
}