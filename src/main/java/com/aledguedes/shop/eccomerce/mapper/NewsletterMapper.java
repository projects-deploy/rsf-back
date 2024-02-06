package com.aledguedes.shop.eccomerce.mapper;

import com.aledguedes.shop.eccomerce.dtoRequest.NewsletterRequest;
import com.aledguedes.shop.eccomerce.dtoResponse.NewsletterResponse;
import com.aledguedes.shop.eccomerce.model.Newsletter;

public interface NewsletterMapper {

    Newsletter toNewsletter(NewsletterRequest newsletterRequest);
    NewsletterResponse toNewsletterResponse(Newsletter newsletter);
}
