package com.aledguedes.shop.eccomerce.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.aledguedes.shop.eccomerce.dtoRequest.NewsletterRequest;
import com.aledguedes.shop.eccomerce.dtoResponse.NewsletterResponse;
import com.aledguedes.shop.eccomerce.service.NewsletterService;

import jakarta.mail.MessagingException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;


@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/api/newsletter")
public class NewsletterController {

    private final NewsletterService newsletterService;

    @GetMapping(value = "/{newsletter_id}")
    public NewsletterResponse newsletterById(@PathVariable Long newsletter_id) {
        return newsletterService.newsletterById(newsletter_id);
    }

    @GetMapping
    public List<NewsletterResponse> listAll() {
        return newsletterService.listAll();
    }

    @GetMapping(value = "/send-email")
    public String sendNewsletterUsers() throws UnsupportedEncodingException, MessagingException {
        return newsletterService.sendNewsletter();
    }
    

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public NewsletterResponse createNewsletter(@RequestBody @Valid NewsletterRequest newsletter) {
        return newsletterService.createNewsletter(newsletter);
    }

    @PutMapping(value = "/{newsletter_id}")
    public NewsletterResponse updateNewsletter(@RequestBody @Valid NewsletterRequest newsletter, Long newsletter_id) {
        return newsletterService.updateNewsletter(newsletter, newsletter_id);
    }

    @DeleteMapping("/{newsletter_id}")
    public void deleteNewsletter(@PathVariable Long newsletter_id) {
        newsletterService.deleteNewsletter(newsletter_id);
    }

}
