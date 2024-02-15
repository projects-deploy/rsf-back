package com.aledguedes.shop.eccomerce.service;

import java.util.List;

import com.aledguedes.shop.eccomerce.dtoRequest.NotifyArrivalRequest;
import com.aledguedes.shop.eccomerce.dtoResponse.NotifyArrivalResponse;

public interface NotifyArrivalService {
    List<NotifyArrivalResponse> listAll();
    NotifyArrivalResponse notifyArrivalById(Long notifyArrival_id);
    NotifyArrivalResponse createNotifyArrival(NotifyArrivalRequest notifyArrival);
    NotifyArrivalResponse updateNotifyArrival(NotifyArrivalRequest notifyArrival, Long notifyArrival_id);
    
}
