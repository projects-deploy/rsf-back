package com.aledguedes.shop.eccomerce.service;

import java.io.UnsupportedEncodingException;

import com.aledguedes.shop.eccomerce.model.User;

import jakarta.mail.MessagingException;

public interface MailService {

	void sendVerificationEmail(User user) throws UnsupportedEncodingException, MessagingException;
}