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

import com.aledguedes.shop.eccomerce.dtoRequest.TagsRequest;
import com.aledguedes.shop.eccomerce.dtoResponse.TagsResponse;
import com.aledguedes.shop.eccomerce.service.TagsService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/api/tags")
public class TagsController {

    private final TagsService tagsService;

    @GetMapping
    public List<TagsResponse> listAll() {
        return tagsService.listAll();
    }

    @GetMapping(value = "/{tags_id}")
    public TagsResponse tagsById(@PathVariable Long tags_id) {
        return tagsService.tagsById(tags_id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TagsResponse createTags(@RequestBody @Valid TagsRequest tags) {
        return tagsService.createTags(tags);
    }

    @PutMapping(value = "/{tags_id}")
    public TagsResponse updateTags(@RequestBody @Valid TagsRequest tags, @PathVariable Long tags_id) {
        return tagsService.updateTags(tags, tags_id);
    }
}
