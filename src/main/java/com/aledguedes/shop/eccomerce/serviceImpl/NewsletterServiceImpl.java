package com.aledguedes.shop.eccomerce.serviceImpl;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.aledguedes.shop.eccomerce.dtoRequest.NewsletterRequest;
import com.aledguedes.shop.eccomerce.dtoResponse.NewsletterResponse;
import com.aledguedes.shop.eccomerce.exceptions.core.NotFoundException;
import com.aledguedes.shop.eccomerce.mapper.NewsletterMapper;
import com.aledguedes.shop.eccomerce.repository.NewsletterRespository;
import com.aledguedes.shop.eccomerce.service.MailService;
import com.aledguedes.shop.eccomerce.service.NewsletterService;

import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@SuppressWarnings("null")
public class NewsletterServiceImpl implements NewsletterService {

    private final MailService mailService;
    private final NewsletterMapper newsletterMapper;
    private final NewsletterRespository newsletterRepository;

    @Override
    public NewsletterResponse newsletterById(Long newsletter_id) {
        return newsletterRepository.findById(newsletter_id).map(newsletterMapper::toNewsletterResponse)
                .orElseThrow(NotFoundException::new);
    }

    @Override
    public List<NewsletterResponse> listAll() {
        return newsletterRepository.findAll().stream().map(newsletterMapper::toNewsletterResponse).toList();
    }

    @Override
    public NewsletterResponse createNewsletter(NewsletterRequest newsletter) {
        try {
        	var existsEmail = newsletterRepository.findByEmail(newsletter.getEmail()).orElse(null);
        	System.out.println(("DEBUG EMAIL NEWSLETTER: "+existsEmail));
        	if (existsEmail != null) {
        		return null;                
        	}
        	var newNewsletter = newsletterMapper.toNewsletter(newsletter);
            var savedNewsletter = newsletterRepository.save(newNewsletter);
            return newsletterMapper.toNewsletterResponse(savedNewsletter);
        } catch (Exception e) {
            System.out.println("DEBUG = " + e.getMessage());
            return null;
        }
    }

    @Override
    public NewsletterResponse updateNewsletter(NewsletterRequest newsletterRequest, Long newsletter_id) {
        try {
            var newsletter = newsletterRepository.findById(newsletter_id).orElseThrow(NotFoundException::new);
            BeanUtils.copyProperties(newsletterRequest, newsletter, "id", "createdAt", "updatedAt");
            var newsletterAtualizado = newsletterRepository.save(newsletter);
            return newsletterMapper.toNewsletterResponse(newsletterAtualizado);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public void deleteNewsletter(Long newsletter_id) {
        try {
            newsletterRepository.deleteById(newsletter_id);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public String sendNewsletter() throws UnsupportedEncodingException, MessagingException {

        List<NewsletterResponse> newsletter = newsletterRepository.findAll()
                .stream()
                .map(newsletterMapper::toNewsletterResponse)
                .toList();
        if (!newsletter.isEmpty()) {
            mailService.sendNewsletter(newsletter);
            return "E-mails enviados com sucesso";
        }
        return "Nenhum usuário cadastrado para envio";
    }

}
