package com.aledguedes.shop.eccomerce.service;

import java.io.UnsupportedEncodingException;
import java.util.List;

import com.aledguedes.shop.eccomerce.dtoRequest.NewsletterRequest;
import com.aledguedes.shop.eccomerce.dtoResponse.NewsletterResponse;

import jakarta.mail.MessagingException;

public interface NewsletterService {

    NewsletterResponse newsletterById(Long newsletter_id);
    List<NewsletterResponse> listAll();
    NewsletterResponse createNewsletter(NewsletterRequest newsletter);
    NewsletterResponse updateNewsletter(NewsletterRequest newsletter, Long newsletter_id);
    String sendNewsletter() throws UnsupportedEncodingException, MessagingException;
    void deleteNewsletter(Long newsletter_id);
}
