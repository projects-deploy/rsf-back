package com.aledguedes.shop.eccomerce.service;

import java.util.List;

import com.aledguedes.shop.eccomerce.dtoRequest.HighlightsRequest;
import com.aledguedes.shop.eccomerce.dtoResponse.HighlightsResponse;

public interface HighlightsService {

    List<HighlightsResponse> listAll();
    HighlightsResponse highlightsById(Long highlights_id);
    HighlightsResponse createHighlights(HighlightsRequest highlights);
    List<HighlightsResponse> saveHighlightsList(List<HighlightsRequest> highlightsRequestList);
    HighlightsResponse updateHighlights(HighlightsRequest highlights, Long highlights_id);
}
