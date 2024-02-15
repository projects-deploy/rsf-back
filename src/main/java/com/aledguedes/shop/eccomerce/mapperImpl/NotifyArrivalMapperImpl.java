package com.aledguedes.shop.eccomerce.mapperImpl;

import org.springframework.stereotype.Component;

import com.aledguedes.shop.eccomerce.dtoRequest.NotifyArrivalRequest;
import com.aledguedes.shop.eccomerce.dtoResponse.NotifyArrivalResponse;
import com.aledguedes.shop.eccomerce.mapper.NotifyArrivalMapper;
import com.aledguedes.shop.eccomerce.model.NotifyArrival;

@Component
public class NotifyArrivalMapperImpl implements NotifyArrivalMapper {

    @Override
    public NotifyArrival toNotifyArrival(NotifyArrivalRequest notifyArrivalRequest) {
        if (notifyArrivalRequest == null) {
            return null;
        }

        return NotifyArrival.builder()
                .name(notifyArrivalRequest.getName())
                .email(notifyArrivalRequest.getEmail())
                .build();
    }

    @Override
    public NotifyArrivalResponse toNotifyArrivalResponse(NotifyArrival notifyArrival) {
        if (notifyArrival == null) {
            return null;
        }

        return NotifyArrivalResponse.builder()
                .id(notifyArrival.getId())
                .name(notifyArrival.getName())
                .email(notifyArrival.getEmail())
                .createdAt(notifyArrival.getCreatedAt())
                .updatedAt(notifyArrival.getUpdatedAt())
                .build();
    }

}