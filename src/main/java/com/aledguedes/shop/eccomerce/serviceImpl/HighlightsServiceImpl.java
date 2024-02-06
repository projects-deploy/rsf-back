package com.aledguedes.shop.eccomerce.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

import com.aledguedes.shop.eccomerce.dtoRequest.HighlightsRequest;
import com.aledguedes.shop.eccomerce.dtoResponse.HighlightsResponse;
import com.aledguedes.shop.eccomerce.exceptions.core.HighlightsNotFoundException;
import com.aledguedes.shop.eccomerce.mapper.HighlightsMapper;
import com.aledguedes.shop.eccomerce.model.Highlights;
import com.aledguedes.shop.eccomerce.repository.HighlightsRepository;
import com.aledguedes.shop.eccomerce.service.HighlightsService;

@Service
@RequiredArgsConstructor
@SuppressWarnings("null")
public class HighlightsServiceImpl implements HighlightsService {

    private final HighlightsMapper highlightsMapper;
    private final HighlightsRepository highlightsRepository;

    @Override
    public List<HighlightsResponse> listAll() {
        return highlightsRepository.findAll()
                .stream()
                .map(highlightsMapper::toHighlightsResponse)
                .toList();
    }

    @Override
    public HighlightsResponse highlightsById(Long highlights_id) {
        return highlightsRepository.findById(highlights_id)
                .map(highlightsMapper::toHighlightsResponse)
                .orElseThrow(HighlightsNotFoundException::new);
    }

    @Override
    public HighlightsResponse createHighlights(HighlightsRequest highlights) {
        try {
            var newHighlights = highlightsMapper.toHighlights(highlights);
            var createdHighlights = highlightsRepository.save(newHighlights);
            return highlightsMapper.toHighlightsResponse(createdHighlights);
        } catch (Exception e) {
            System.out.println("DEBUG = " + e.getMessage());
        }
        return null;
    }

    @Override
    public HighlightsResponse updateHighlights(HighlightsRequest highlights, Long highlights_id) {
        try {
            var newHighlights = highlightsRepository.findById(highlights_id)
                    .orElseThrow(HighlightsNotFoundException::new);
            BeanUtils.copyProperties(highlights, newHighlights, "id", "createdAt", "updatedAt");
            var highlightsAtualizado = highlightsRepository.save(newHighlights);
            return highlightsMapper.toHighlightsResponse(highlightsAtualizado);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public List<HighlightsResponse> saveHighlightsList(List<HighlightsRequest> highlightsRequestList) {
        try {
            List<Highlights> highlightsList = new ArrayList<>();

            for (HighlightsRequest request : highlightsRequestList) {
                Highlights highlights = highlightsMapper.toHighlights(request);
                highlightsList.add(highlights);
            }

            var savedHighlights = highlightsRepository.saveAll(highlightsList);
            return savedHighlights.stream()
                    .map(highlightsMapper::toHighlightsResponse)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            return null;
        }
    }

}