package com.aledguedes.shop.eccomerce.service;

import java.util.List;

import com.aledguedes.shop.eccomerce.dtoRequest.InCarouselRequest;
import com.aledguedes.shop.eccomerce.dtoResponse.InCarouselResponse;

public interface InCarouselService {

    List<InCarouselResponse> listAll();
    InCarouselResponse inCarouselById(Long inCarousel_id);
    InCarouselResponse createInCarousel(InCarouselRequest inCarousel);
    InCarouselResponse updateInCarousel(InCarouselRequest inCarousel, Long inCarousel_id);
    List<InCarouselResponse> saveInCarouselList(List<InCarouselRequest> inCarouselRequestList);
}
