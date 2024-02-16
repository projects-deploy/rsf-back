package com.aledguedes.shop.eccomerce.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.aledguedes.shop.eccomerce.dtoRequest.NotifyArrivalRequest;
import com.aledguedes.shop.eccomerce.dtoResponse.NotifyArrivalResponse;
import com.aledguedes.shop.eccomerce.service.NotifyArrivalService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/api/arrived")
public class NotifyArrivalController {

    private final NotifyArrivalService notifyArrivalService;

    @GetMapping
    public List<NotifyArrivalResponse> listAll() {
        return notifyArrivalService.listAll();
    }

    @GetMapping(value = "/{notifyArrival_id}")
    public NotifyArrivalResponse notifyArrivalById(@PathVariable Long notifyArrival_id) {
        return notifyArrivalService.notifyArrivalById(notifyArrival_id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public NotifyArrivalResponse createNotifyArrival(@RequestBody @Valid NotifyArrivalRequest notifyArrival) {
        return notifyArrivalService.createNotifyArrival(notifyArrival);
    }

    @PutMapping(value = "/{notifyArrival_id}")
    public NotifyArrivalResponse updateNotifyArrival(@RequestBody @Valid NotifyArrivalRequest notifyArrival,
            @PathVariable Long notifyArrival_id) {
        return notifyArrivalService.updateNotifyArrival(notifyArrival, notifyArrival_id);
    }

    @GetMapping(value = "/find/by-product")
    public List<NotifyArrivalResponse> findByProductId(
            @RequestParam(name = "p", required = false, defaultValue = "") Long product_id) {
        return notifyArrivalService.findByProductId(product_id);
    }
}
