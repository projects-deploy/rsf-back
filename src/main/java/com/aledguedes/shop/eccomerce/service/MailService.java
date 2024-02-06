package com.aledguedes.shop.eccomerce.service;

import java.io.UnsupportedEncodingException;
import java.util.List;

import com.aledguedes.shop.eccomerce.dtoResponse.NewsletterResponse;
import com.aledguedes.shop.eccomerce.model.User;

import jakarta.mail.MessagingException;

public interface MailService {

	void sendVerificationEmail(User user) throws UnsupportedEncodingException, MessagingException;
	void sendNewsletter(List<NewsletterResponse> newsletterResponse) throws UnsupportedEncodingException, MessagingException;
}