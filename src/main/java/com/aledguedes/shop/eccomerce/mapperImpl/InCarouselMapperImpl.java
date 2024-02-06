package com.aledguedes.shop.eccomerce.mapperImpl;

import org.springframework.stereotype.Component;

import com.aledguedes.shop.eccomerce.dtoRequest.InCarouselRequest;
import com.aledguedes.shop.eccomerce.dtoResponse.InCarouselResponse;
import com.aledguedes.shop.eccomerce.mapper.InCarouselMapper;
import com.aledguedes.shop.eccomerce.model.InCarousel;

@Component
public class InCarouselMapperImpl implements InCarouselMapper  {

    @Override
    public InCarousel toInCarousel(InCarouselRequest inCarouselRequest) {
         if (inCarouselRequest == null) {
            return null;
        }

        return InCarousel.builder()
                .links(inCarouselRequest.getLinks())
                .build();
    }

    @Override
    public InCarouselResponse toInCarouselResponse(InCarousel inCarousel) {
       if (inCarousel == null) {
            return null;
        }

        return InCarouselResponse.builder()
                .id(inCarousel.getId())
                .links(inCarousel.getLinks())
                .createdAt(inCarousel.getCreatedAt())
                .updatedAt(inCarousel.getUpdatedAt())
                .build();
    }
    
}
