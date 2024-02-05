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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.aledguedes.shop.eccomerce.dtoRequest.InCarouselRequest;
import com.aledguedes.shop.eccomerce.dtoResponse.InCarouselResponse;
import com.aledguedes.shop.eccomerce.service.InCarouselService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/api/carousel")
public class InCarouselController {
    
    private final InCarouselService inCarouselService;

    @GetMapping
    public List<InCarouselResponse> listAll() {
        return inCarouselService.listAll();
    }

    @GetMapping(value = "/{inCollection_id}")
    public InCarouselResponse inCollectionById(@PathVariable Long inCollection_id) {
        return inCarouselService.inCarouselById(inCollection_id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public InCarouselResponse createInCarousel(@RequestBody @Valid InCarouselRequest inCollection) {
        return inCarouselService.createInCarousel(inCollection);
    }

    @PostMapping(value = "/save-list")
    @ResponseStatus(HttpStatus.CREATED)
    public List<InCarouselResponse> saveInCarouselList(@RequestBody @Valid List<InCarouselRequest> inCollectionRequestList) {
        return inCarouselService.saveInCarouselList(inCollectionRequestList);
    }

    @PutMapping(value = "/{inCollection_id}")
    public InCarouselResponse updateInCarousel(@RequestBody @Valid InCarouselRequest inCollection, @PathVariable Long inCollection_id) {
        return inCarouselService.updateInCarousel(inCollection, inCollection_id);
    }
}
