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

import com.aledguedes.shop.eccomerce.dtoRequest.InCollectionRequest;
import com.aledguedes.shop.eccomerce.dtoResponse.InCollectionResponse;
import com.aledguedes.shop.eccomerce.service.InCollectionService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/api/inCollection")
public class InCollectionController {

    private final InCollectionService inCollectionService;

    @GetMapping
    public List<InCollectionResponse> listAll() {
        return inCollectionService.listAll();
    }

    @GetMapping(value = "/{inCollection_id}")
    public InCollectionResponse inCollectionById(@PathVariable Long inCollection_id) {
        return inCollectionService.inCollectionById(inCollection_id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public InCollectionResponse createInCollection(@RequestBody @Valid InCollectionRequest inCollection) {
        return inCollectionService.createInCollection(inCollection);
    }

    @PostMapping(value = "/save-list")
    @ResponseStatus(HttpStatus.CREATED)
    public List<InCollectionResponse> saveInCollectionList(@RequestBody @Valid List<InCollectionRequest> inCollectionRequestList) {
        return inCollectionService.saveInCollectionList(inCollectionRequestList);
    }

    @PutMapping(value = "/{inCollection_id}")
    public InCollectionResponse updateInCollection(@RequestBody @Valid InCollectionRequest inCollection, @PathVariable Long inCollection_id) {
        return inCollectionService.updateInCollection(inCollection, inCollection_id);
    }

    
    
}
