package com.aledguedes.shop.eccomerce.mapperImpl;

import org.springframework.stereotype.Component;

import com.aledguedes.shop.eccomerce.dtoRequest.NewsletterRequest;
import com.aledguedes.shop.eccomerce.dtoResponse.NewsletterResponse;
import com.aledguedes.shop.eccomerce.mapper.NewsletterMapper;
import com.aledguedes.shop.eccomerce.model.Newsletter;

@Component
public class NewsletterMapperImpl  implements NewsletterMapper {

    @Override
    public Newsletter toNewsletter(NewsletterRequest newsletterRequest) {
        if (newsletterRequest == null) {
            return null;
        }

        return Newsletter.builder()
                .username(newsletterRequest.getUsername())
                .email(newsletterRequest.getEmail())
                .build();
    }

    @Override
    public NewsletterResponse toNewsletterResponse(Newsletter newsletter) {
        if (newsletter == null) {
            return null;
        }

        return NewsletterResponse.builder()
                .id(newsletter.getId())
                .username(newsletter.getUsername())
                .email(newsletter.getEmail())
                .createdAt(newsletter.getCreatedAt())
                .updatedAt(newsletter.getUpdatedAt())
                .build();
    }

}