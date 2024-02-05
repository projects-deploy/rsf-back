package com.aledguedes.shop.eccomerce.mapper;

import com.aledguedes.shop.eccomerce.dtoRequest.InCarouselRequest;
import com.aledguedes.shop.eccomerce.dtoResponse.InCarouselResponse;
import com.aledguedes.shop.eccomerce.model.InCarousel;

public interface InCarouselMapper {

    InCarousel toInCarousel(InCarouselRequest inCarouselRequest);
    InCarouselResponse toInCarouselResponse(InCarousel inCarousel);
}
