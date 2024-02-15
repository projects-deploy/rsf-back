package com.aledguedes.shop.eccomerce.mapper;

import com.aledguedes.shop.eccomerce.dtoRequest.NotifyArrivalRequest;
import com.aledguedes.shop.eccomerce.dtoResponse.NotifyArrivalResponse;
import com.aledguedes.shop.eccomerce.model.NotifyArrival;

public interface NotifyArrivalMapper {

    NotifyArrival toNotifyArrival(NotifyArrivalRequest notifyArrivalRequest);
    NotifyArrivalResponse toNotifyArrivalResponse(NotifyArrival notifyArrival);
}
