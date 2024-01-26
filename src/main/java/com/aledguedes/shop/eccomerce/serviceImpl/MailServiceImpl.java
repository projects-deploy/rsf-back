package com.aledguedes.shop.eccomerce.serviceImpl;

import java.io.UnsupportedEncodingException;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.spring6.SpringTemplateEngine;

import com.aledguedes.shop.eccomerce.model.User;
import com.aledguedes.shop.eccomerce.service.MailService;
import org.thymeleaf.context.Context;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@SuppressWarnings("null")
public class MailServiceImpl implements MailService {

	private final JavaMailSender emailSender;
	private final SpringTemplateEngine templateEngine;
	private String verifyURL = "https://shopfashion.vercel.app/verify?code=";

	@Override
	public void sendVerificationEmail(User user) throws UnsupportedEncodingException, MessagingException {

		String toAddres = user.getEmail();
		String fromAddres = "aledguedes@gmail.com";
		String senderName = "ShopFashion";
		String subject = "Please verify your registration";

		MimeMessage message = emailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);

		String confirmationLink = generateConfirmationLink(user);
		String emailContent = getEmailContent(user, confirmationLink);

		helper.setTo(toAddres);
		helper.setSubject(subject);
		helper.setFrom(fromAddres, senderName);;
		helper.setText(emailContent, true);

		emailSender.send(message);
	}
	
	private String generateConfirmationLink(User user) {
        return verifyURL + user.getVerificationCode();
    }

    private String getEmailContent(User user, String confirmationLink) {
    	
    	Context context = new Context();
        context.setVariable("user", user);
        context.setVariable("confirmationLink", confirmationLink);
        
        return templateEngine.process("email-template", context);
    }

}
