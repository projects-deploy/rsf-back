package com.aledguedes.shop.eccomerce.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.aledguedes.shop.eccomerce.dtoRequest.InterestRequest;
import com.aledguedes.shop.eccomerce.dtoResponse.InterestResponse;
import com.aledguedes.shop.eccomerce.exceptions.core.InterestNotFoundException;
import com.aledguedes.shop.eccomerce.mapper.InterestMapper;
import com.aledguedes.shop.eccomerce.model.Customer;
import com.aledguedes.shop.eccomerce.model.Interest;
import com.aledguedes.shop.eccomerce.repository.InterestRepository;
import com.aledguedes.shop.eccomerce.service.InterestService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@SuppressWarnings("null")
public class InterestServiceImpl implements InterestService {

    private final InterestMapper interestMapper;
    private final InterestRepository interestRepository;

    @Override
    public List<InterestResponse> listAll() {
        return interestRepository.findAll()
                .stream()
                .map(interestMapper::toInterestResponse)
                .toList();
    }

    @Override
    public InterestResponse interestById(Long interest_id) {
        return interestRepository.findById(interest_id)
                .map(interestMapper::toInterestResponse)
                .orElseThrow(InterestNotFoundException::new);
    }

    @Override
    public InterestResponse createInterest(InterestRequest interestRequest) {
        try {
            var newInterest = interestMapper.toInterest(interestRequest);
            var createdBrand = interestRepository.save(newInterest);
            return interestMapper.toInterestResponse(createdBrand);
        } catch (Exception e) {
            System.out.println("DEBUG = " + e.getMessage());
            return null;
        }
    }

    @Override
    public void notifySubscribers(Long product_id) {
        List<Customer> subscribers = getSubscribersForProduct(product_id);

        for (Customer subscriber : subscribers) {
            // emailService.sendNotificationEmail(subscriber, product);
            System.out.println("NOTIFICAÇÃO EMAIL: "+ subscriber.getEmail());
        }
    }

    public List<Customer> getSubscribersForProduct(Long productId) {
        List<Interest> subscriptions = interestRepository.findByProductId(productId);
        List<Customer> subscribers = new ArrayList<>();

        for (Interest subscription : subscriptions) {
            subscribers.add(subscription.getCustomer());
        }

        return subscribers;
    }

}
