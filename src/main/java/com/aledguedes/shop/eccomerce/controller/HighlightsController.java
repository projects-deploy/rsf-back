package com.aledguedes.shop.eccomerce.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.aledguedes.shop.eccomerce.dtoRequest.HighlightsRequest;
import com.aledguedes.shop.eccomerce.dtoResponse.HighlightsResponse;
import com.aledguedes.shop.eccomerce.service.HighlightsService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/api/highlights")
public class HighlightsController {

    private final HighlightsService highlightsService;

    @GetMapping
    public List<HighlightsResponse> listAll() {
        return highlightsService.listAll();
    }

    @GetMapping(value = "/{highlights_id}")
    public HighlightsResponse highlightsById(@PathVariable Long highlights_id) {
        return highlightsService.highlightsById(highlights_id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public HighlightsResponse createHighlights(@RequestBody @Valid HighlightsRequest highlights) {
        return highlightsService.createHighlights(highlights);
    }

    @PostMapping(value = "/save-list")
    @ResponseStatus(HttpStatus.CREATED)
    public List<HighlightsResponse> saveHighlightsList(@RequestBody @Valid List<HighlightsRequest> highlightsRequestList) {
        return highlightsService.saveHighlightsList(highlightsRequestList);
    }

    @PutMapping(value = "/{highlights_id}")
    public HighlightsResponse updateHighlights(@RequestBody @Valid HighlightsRequest highlights, @PathVariable Long highlights_id) {
        return highlightsService.updateHighlights(highlights, highlights_id);
    }

    
    
}