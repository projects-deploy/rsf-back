package com.aledguedes.shop.eccomerce.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.aledguedes.shop.eccomerce.model.InCarousel;
import com.aledguedes.shop.eccomerce.mapper.InCarouselMapper;
import com.aledguedes.shop.eccomerce.service.InCarouselService;
import com.aledguedes.shop.eccomerce.dtoRequest.InCarouselRequest;
import com.aledguedes.shop.eccomerce.dtoResponse.InCarouselResponse;
import com.aledguedes.shop.eccomerce.repository.InCarouselRepository;
import com.aledguedes.shop.eccomerce.exceptions.core.InCarouselNotFoundException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@SuppressWarnings("null")
public class InCarouselServiceImpl implements InCarouselService {

    private final InCarouselMapper inCarouselMapper;
    private final InCarouselRepository inCarouselRepository;

    @Override
    public List<InCarouselResponse> listAll() {
        return inCarouselRepository.findAll()
                .stream()
                .map(inCarouselMapper::toInCarouselResponse)
                .toList();
    }

    @Override
    public InCarouselResponse inCarouselById(Long inCarousel_id) {
         return inCarouselRepository.findById(inCarousel_id)
                .map(inCarouselMapper::toInCarouselResponse)
                .orElseThrow(InCarouselNotFoundException::new);
    }

    @Override
    public InCarouselResponse createInCarousel(InCarouselRequest inCarousel) {
        try {
            var newInCarousel = inCarouselMapper.toInCarousel(inCarousel);
            var createdInCarousel = inCarouselRepository.save(newInCarousel);
            return inCarouselMapper.toInCarouselResponse(createdInCarousel);
        } catch (Exception e) {
            System.out.println("DEBUG = " + e.getMessage());
        }
        return null;
    }

    @Override
    public InCarouselResponse updateInCarousel(InCarouselRequest inCarousel, Long inCarousel_id) {
        try {
            var newInCarousel = inCarouselRepository.findById(inCarousel_id)
                    .orElseThrow(InCarouselNotFoundException::new);
            BeanUtils.copyProperties(inCarousel, newInCarousel, "id", "createdAt", "updatedAt");
            var inCarouselAtualizado = inCarouselRepository.save(newInCarousel);
            return inCarouselMapper.toInCarouselResponse(inCarouselAtualizado);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public List<InCarouselResponse> saveInCarouselList(List<InCarouselRequest> inCarouselRequestList) {
        try {
            List<InCarousel> inCarouselList = new ArrayList<>();

            for (InCarouselRequest request : inCarouselRequestList) {
                InCarousel inCarousel = inCarouselMapper.toInCarousel(request);
                inCarouselList.add(inCarousel);
            }

            var savedInCarousel = inCarouselRepository.saveAll(inCarouselList);
            return savedInCarousel.stream()
                    .map(inCarouselMapper::toInCarouselResponse)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            return null;
        }
    }

    
    
}
