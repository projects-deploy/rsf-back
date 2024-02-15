package com.aledguedes.shop.eccomerce.serviceImpl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.aledguedes.shop.eccomerce.dtoRequest.NotifyArrivalRequest;
import com.aledguedes.shop.eccomerce.dtoResponse.NotifyArrivalResponse;
import com.aledguedes.shop.eccomerce.exceptions.core.NotifyArrivalNotFoundException;
import com.aledguedes.shop.eccomerce.mapper.NotifyArrivalMapper;
import com.aledguedes.shop.eccomerce.repository.NotifyArrivalRepository;
import com.aledguedes.shop.eccomerce.service.NotifyArrivalService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@SuppressWarnings("null")
public class NotifyArrivalServiceImpl implements NotifyArrivalService {

    private final NotifyArrivalMapper notifyArrivalMapper;
    private final NotifyArrivalRepository notifyArrivalRepository;

    @Override
    public List<NotifyArrivalResponse> listAll() {
        return notifyArrivalRepository.findAll()
                .stream()
                .map(notifyArrivalMapper::toNotifyArrivalResponse)
                .toList();
    }

    @Override
    public NotifyArrivalResponse notifyArrivalById(Long notifyArrival_id) {
        return notifyArrivalRepository.findById(notifyArrival_id)
                .map(notifyArrivalMapper::toNotifyArrivalResponse)
                .orElseThrow(NotifyArrivalNotFoundException::new);
    }

    @Override
    public NotifyArrivalResponse createNotifyArrival(NotifyArrivalRequest notifyArrivalRequest) {
        try {
            var newNotifyArrival = notifyArrivalMapper.toNotifyArrival(notifyArrivalRequest);
            var createdNotifyArrival = notifyArrivalRepository.save(newNotifyArrival);
            return notifyArrivalMapper.toNotifyArrivalResponse(createdNotifyArrival);
        } catch (Exception e) {
            System.out.println("DEBUG = " + e.getMessage());
        }
        return null;
    }

    @Override
    public NotifyArrivalResponse updateNotifyArrival(NotifyArrivalRequest notifyArrivalRequest, Long notifyArrival_id) {
        try {
			var notifyArrival = notifyArrivalRepository.findById(notifyArrival_id)
					.orElseThrow(NotifyArrivalNotFoundException::new);
			BeanUtils.copyProperties(notifyArrivalRequest, notifyArrival, "id", "createdAt", "updatedAt");
			var notifyArrivalAtualizado = notifyArrivalRepository.save(notifyArrival);
			return notifyArrivalMapper.toNotifyArrivalResponse(notifyArrivalAtualizado);
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
    }

}
